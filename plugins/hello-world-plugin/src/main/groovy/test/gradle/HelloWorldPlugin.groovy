package test.gradle


import org.gradle.api.Plugin
import org.gradle.api.Project

class HelloWorldPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        println "Hi Gradle team"
    }
}
