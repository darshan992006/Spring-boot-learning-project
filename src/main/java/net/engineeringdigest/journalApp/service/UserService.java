package net.engineeringdigest.journalApp.service;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.JournalEntryRepo;
import net.engineeringdigest.journalApp.repository.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepo userRepo;

    private static final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    public void saveEntry(User user){
        userRepo.save(user);
    }
    public void saveNewUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER"));
        userRepo.save(user);
    }

    public List<User> getEvery(){
         return userRepo.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userRepo.findById(id);
    }

    public void deleteId(ObjectId id){
        userRepo.deleteById(id);
    }

    public void deleteByUserName(String userName){
        userRepo.deleteByUserName(userName);
    }

    public User findByUserName(String username){
        return userRepo.findByUserName(username);
    }


}
