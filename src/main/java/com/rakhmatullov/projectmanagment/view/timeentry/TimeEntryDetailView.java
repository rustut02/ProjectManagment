package com.rakhmatullov.projectmanagment.view.timeentry;

import com.rakhmatullov.projectmanagment.entity.TimeEntry;
import com.rakhmatullov.projectmanagment.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Route(value = "timeEntries/:id", layout = MainView.class)
@ViewController("TimeEntry.detail")
@ViewDescriptor("time-entry-detail-view.xml")
@EditedEntityContainer("timeEntryDc")
public class TimeEntryDetailView extends StandardDetailView<TimeEntry> {
    @Subscribe
    public void onInitEntity(final InitEntityEvent<TimeEntry> event) {
        LocalDateTime localDate = LocalDateTime.now();
        event.getEntity().setEntryDate(localDate);
    }

}