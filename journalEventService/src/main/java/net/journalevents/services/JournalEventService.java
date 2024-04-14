package net.journalevents.services;

import net.journalevents.entities.JournalEvent;

import java.util.List;

public interface JournalEventService {

//    Create Event
    JournalEvent createEvent(JournalEvent journalEvent);

//        Update Event
    JournalEvent updateEventById(JournalEvent journalEvent, String eventId);

//    Get Single Event
    JournalEvent getEventById(String eventId);

//    Get All Event
    List<JournalEvent> getAllEvent();

//    Delete Event
    void deleteEventById(String eventId);

}
