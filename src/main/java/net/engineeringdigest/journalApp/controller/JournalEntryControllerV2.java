package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/_journal")
public class JournalEntryControllerV2 {


    @GetMapping()
    public List<JournalEntry> getAll() {
        return null;
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) {
        return false;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId) {
        return null;
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId) {
        return null;
    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable Long id, @RequestBody JournalEntry entry) {
        return null;
    }


}
