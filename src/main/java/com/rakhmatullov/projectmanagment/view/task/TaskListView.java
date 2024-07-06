package com.rakhmatullov.projectmanagment.view.task;

import com.rakhmatullov.projectmanagment.entity.Task;
import com.rakhmatullov.projectmanagment.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "tasks", layout = MainView.class)
@ViewController("Task_.list")
@ViewDescriptor("task-list-view.xml")
@LookupComponent("tasksDataGrid")
@DialogMode(width = "64em")
public class TaskListView extends StandardListView<Task> {
}