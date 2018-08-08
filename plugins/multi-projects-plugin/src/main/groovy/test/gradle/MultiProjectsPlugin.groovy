package test.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.TaskContainer

class MultiProjectsPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.subprojects {
            subproject ->
                afterEvaluate {
                    addSubprojectTasks(project, subproject.tasks)
                }
        }
    }

    private void addSubprojectTasks(Project project, TaskContainer tasks) {
        tasks.each {
            subprojectTask ->
                Task parentTask = project.tasks.findByName(subprojectTask.name)
                if (parentTask == null) {
                    parentTask = project.task(subprojectTask.name)
                }
                parentTask.dependsOn(subprojectTask)
        }
    }
}
