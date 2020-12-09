package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeEntryController {


    private final TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }


    public ResponseEntity<TimeEntry> create(TimeEntry timeEntryToCreate) {
        return ResponseEntity.created(null).body(timeEntryRepository.create(timeEntryToCreate));
    }

    public ResponseEntity<TimeEntry> read(long timeEntryId) {
        var timeEntryFound = timeEntryRepository.find(timeEntryId);
        if (timeEntryFound == null)
        {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(timeEntryFound);
        }

    }

    public ResponseEntity<List<TimeEntry>> list() {

        return ResponseEntity.ok(timeEntryRepository.list());
    }

    public ResponseEntity<TimeEntry> update(long timeEntryId, TimeEntry timeEntryToUpdate) {

        var timeEntryupdated = timeEntryRepository.update(timeEntryId, timeEntryToUpdate);
        if (timeEntryupdated == null)
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            return ResponseEntity.ok(timeEntryupdated);
        }

    }

    public ResponseEntity<Void> delete(long timeEntryId) {

        timeEntryRepository.delete(timeEntryId);

        return ResponseEntity.noContent().build();

    }
}
