package net.engineeringdigest.journalApp.scheduler;

import net.engineeringdigest.journalApp.cache.AppCache;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepoImpl;
import net.engineeringdigest.journalApp.service.EmailService;
import net.engineeringdigest.journalApp.service.SentimentAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserScheduler {
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepoImpl userRepo;

    @Autowired
    private AppCache appCache;
    @Autowired
    private SentimentAnalysisService sentimentAnalysisService;
    @Scheduled(cron = "0 0 9 * * SUN")
    public void fetchUsersAndSendSaMail(){
        List<User> users= userRepo.getUserForSA();
        for (User user: users){
            List<JournalEntry> journalEntries = user.getJournalEntries();
            List<String> filtered = journalEntries
                    .stream()
                    .filter(x -> x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS)))
                    .map(x->x.getContent())
                    .collect(Collectors.toList());
            String entry = String.join(" ", filtered);
            String  sentiment = sentimentAnalysisService.getSentiment(entry);
            emailService.sendEmail(user.getEmail(),"sentiment for last 7 days",sentiment);
        }
    }

    @Scheduled(cron = "0 0/10 * ? * *")
    public void clearAppCache(){
        appCache.init();
    }
}
