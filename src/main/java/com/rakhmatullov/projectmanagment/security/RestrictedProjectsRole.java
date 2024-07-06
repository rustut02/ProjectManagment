package com.rakhmatullov.projectmanagment.security;

import com.rakhmatullov.projectmanagment.entity.Project;
import com.rakhmatullov.projectmanagment.entity.User;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.security.model.RowLevelBiPredicate;
import io.jmix.security.model.RowLevelPolicyAction;
import io.jmix.security.role.annotation.PredicateRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;
import org.springframework.context.ApplicationContext;

@RowLevelRole(name = "RestrictedProjectsRole", code = RestrictedProjectsRole.CODE)
public interface RestrictedProjectsRole {
    String CODE = "restricted-projects-role";

    @PredicateRowLevelPolicy(entityClass = Project.class, actions = {RowLevelPolicyAction.UPDATE, RowLevelPolicyAction.DELETE})
    default RowLevelBiPredicate<Project, ApplicationContext> projectPredicate() {
        return (project, applicationContext) -> {
            CurrentAuthentication currentAuthentication = applicationContext
                    .getBean(CurrentAuthentication.class);
            User currentUser = (User)currentAuthentication.getUser();
            return currentUser.equals(project.getManager());
        };
    }
}