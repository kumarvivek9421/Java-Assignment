package net.journalevents.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "journalEvent")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JournalEvent {

    @Id
    private String eventId;
    private String eventType;
    private LocalDateTime eventDateTime;

}
