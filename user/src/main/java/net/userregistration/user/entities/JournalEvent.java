package net.userregistration.user.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JournalEvent {

    @Id
    private String eventId;
    private String eventType;
    private LocalDateTime eventDateTime;

}
