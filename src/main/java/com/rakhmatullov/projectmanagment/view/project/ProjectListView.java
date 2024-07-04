package com.rakhmatullov.projectmanagment.view.project;

import com.rakhmatullov.projectmanagment.entity.Project;
import com.rakhmatullov.projectmanagment.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "projects", layout = MainView.class)
@ViewController("Project.list")
@ViewDescriptor("project-list-view.xml")
@LookupComponent("projectsDataGrid")
@DialogMode(width = "64em")
public class ProjectListView extends StandardListView<Project> {
}