package net.journalevents.controller;

import net.journalevents.entities.JournalEvent;
import net.journalevents.payload.ApiResponce;
import net.journalevents.repositories.JournalEventRepositories;
import net.journalevents.services.JournalEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/event/api")
public class JournalEventController {

    @Autowired
    private JournalEventRepositories journalEventRepo;
    @Autowired
    private JournalEventService journalEventService;

    public JournalEventController(JournalEventService journalEventService) {
        this.journalEventService = journalEventService;
    }
//    Create Event (http://localhost:9091/event/api/createEvent)
    @PostMapping("/createEvent")
    public ResponseEntity<JournalEvent> createEvent(@RequestBody JournalEvent journalEvent){
        JournalEvent createEvent = this.journalEventService.createEvent(journalEvent);
        return new ResponseEntity<>(createEvent, HttpStatus.CREATED);
    }
//    Create Event (http://localhost:9091/event/api/createEvent)
    @PutMapping("/{eventId}")
    public ResponseEntity<JournalEvent> updateEventById(@RequestBody JournalEvent journalEvent,
                                                    @PathVariable("eventId") String eventId){
        JournalEvent createEvent = this.journalEventService.updateEventById(journalEvent, eventId);
        return new ResponseEntity<>(createEvent, HttpStatus.CREATED);
    }


//    Get Single Event (http://localhost:9091/event/api/{userId})
    @GetMapping("/{eventId}")
    public ResponseEntity<?> getEventById(@PathVariable("eventId") String eventId){
//        JournalEvent eventById = this.journalEventService.getEventById(eventId);
//        return new ResponseEntity<>(eventById, HttpStatus.OK);

        Optional<JournalEvent> event = journalEventRepo.findById(eventId);
        if(!event.isEmpty()) {
            Optional<String> eventType = Optional.ofNullable(event.get().getEventType());
            return new ResponseEntity<>(eventType.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Sorry JournalEvent with given eventId is not present: ", HttpStatus.NOT_FOUND);
        }
    }

//    Get All Event (http://localhost:9091/event/api/createEvent)
    @GetMapping("/getAllEvent")
    public ResponseEntity<List<JournalEvent>> getAllEvent(){
        List<JournalEvent> allEvent = this.journalEventService.getAllEvent();
        if (allEvent != null && !allEvent.isEmpty()){
            return new ResponseEntity<>(allEvent, HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<ApiResponce> deleteById(@PathVariable("eventId") String eventId){
        this.journalEventService.deleteEventById(eventId);
        return new ResponseEntity<>(new ApiResponce("Event deleted successfully...!!", true), HttpStatus.OK);
    }
}
