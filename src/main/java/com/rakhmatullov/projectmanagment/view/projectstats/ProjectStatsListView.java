package com.rakhmatullov.projectmanagment.view.projectstats;

import com.rakhmatullov.projectmanagment.app.ProjectStatsService;
import com.rakhmatullov.projectmanagment.entity.ProjectStats;
import com.rakhmatullov.projectmanagment.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.core.LoadContext;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Route(value = "projectStatses", layout = MainView.class)
@ViewController("ProjectStats.list")
@ViewDescriptor("project-stats-list-view.xml")
@LookupComponent("projectStatsesDataGrid")
@DialogMode(width = "50em")
public class ProjectStatsListView extends StandardListView<ProjectStats> {
    @Autowired
    private ProjectStatsService projectStatsService;

    @Install(to = "projectStatsesDl", target = Target.DATA_LOADER)
    protected List<ProjectStats> projectStatsesDlLoadDelegate(LoadContext<ProjectStats> loadContext) {
        return projectStatsService.fetchProjectStatistics();
    }

}
