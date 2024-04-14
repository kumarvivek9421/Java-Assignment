package net.journalevents.services.Impl;

import net.journalevents.entities.JournalEvent;
import net.journalevents.exception.ResourceNotFoundException;
import net.journalevents.repositories.JournalEventRepositories;
import net.journalevents.services.JournalEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class JournalEventServiceImpl implements JournalEventService {

    @Autowired
    private JournalEventRepositories journalEventRepo;

    public JournalEventServiceImpl(JournalEventRepositories journalEventRepo) {
        this.journalEventRepo = journalEventRepo;
    }

    @Override
    public JournalEvent createEvent(JournalEvent journalEvent) {
        String randomId = UUID.randomUUID().toString();
        journalEvent.setEventId(randomId);
        journalEvent.setEventDateTime(LocalDateTime.now());
        return journalEventRepo.save(journalEvent);
    }

    @Override
    public JournalEvent updateEventById(JournalEvent journalEvent, String eventId) {
        JournalEvent updateEvent = this.journalEventRepo.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("JournalEvent", "Id", eventId));
        updateEvent.setEventType(journalEvent.getEventType());

        return this.journalEventRepo.save(updateEvent);
    }

    @Override
    public JournalEvent getEventById(String eventId) {
        return journalEventRepo.findById(eventId)
                .orElseThrow(()->new ResourceNotFoundException("JournalEvent", "Id", eventId));
    }

    @Override
    public List<JournalEvent> getAllEvent() {
        List<JournalEvent> allEvent = this.journalEventRepo.findAll();
       // List<List<JournalEvent>> collect = allEvent.stream().map(journal).collect(Collectors.toList());
        return allEvent;
    }

    @Override
    public void deleteEventById(String eventId) {
        JournalEvent journalEvent = this.journalEventRepo.findById(eventId)
                .orElseThrow(()-> new ResourceNotFoundException("JournalEvent", "Id", eventId));
        this.journalEventRepo.delete(journalEvent);
    }
}
