package net.journalevents.repositories;

import net.journalevents.entities.JournalEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalEventRepositories extends JpaRepository<JournalEvent, String> {
}
