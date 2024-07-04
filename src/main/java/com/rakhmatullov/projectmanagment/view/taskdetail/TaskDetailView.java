package com.rakhmatullov.projectmanagment.view.taskdetail;


import com.rakhmatullov.projectmanagment.entity.Task;
import com.rakhmatullov.projectmanagment.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "tasks/:id", layout = MainView.class)
@ViewController("Task_.detail")
@ViewDescriptor("task-detail-view.xml")
@EditedEntityContainer("taskDc")
@DialogMode(width = "AUTO", height = "AUTO")
public class TaskDetailView extends StandardDetailView<Task> {
}