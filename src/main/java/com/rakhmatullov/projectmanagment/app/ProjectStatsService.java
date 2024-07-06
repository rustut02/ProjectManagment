package com.rakhmatullov.projectmanagment.app;

import com.rakhmatullov.projectmanagment.entity.Project;
import com.rakhmatullov.projectmanagment.entity.ProjectStats;
import com.rakhmatullov.projectmanagment.entity.Task;
import io.jmix.core.DataManager;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ProjectStatsService {

    private final DataManager dataManager;

    public ProjectStatsService(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public List<ProjectStats> fetchProjectStatistics(){
        List<Project> projects = dataManager.load(Project.class).all().list();

        List<ProjectStats> projectStats = projects.stream().map(project -> {
            ProjectStats stat = dataManager.create(ProjectStats.class);
            stat.setId(project.getId());
            stat.setProjectName(project.getName());
            stat.setTasksCount(project.getTasks().size());
            Integer plannedEfforts = project.getTasks()
                    .stream()
                    .map(task -> Objects.requireNonNullElse(task.getEstimation(), 0))
                    .reduce(0, Integer::sum);
            stat.setPlannedEfforts(plannedEfforts);
            return stat;
        }).collect(Collectors.toList());
        return projectStats;
    }
}