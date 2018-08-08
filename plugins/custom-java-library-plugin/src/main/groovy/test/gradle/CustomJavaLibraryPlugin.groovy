package test.gradle


import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaLibraryPlugin
import org.gradle.api.plugins.JavaPluginConvention
import org.gradle.api.plugins.MavenPlugin
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin
import org.gradle.testing.jacoco.plugins.JacocoPlugin
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class CustomJavaLibraryPlugin implements Plugin<Project> {
    private static Logger logger = LoggerFactory.getLogger(CustomJavaLibraryPlugin)

    @Override
    void apply(Project project) {
        applyCommonPlugins(project)
        configurePlugins(project)
    }

    private void configurePlugins(Project project) {
        def javaPluginConvention = project.getConvention().getPlugin(JavaPluginConvention.class)
        javaPluginConvention.setSourceCompatibility(JavaVersion.VERSION_1_10)
        javaPluginConvention.setTargetCompatibility(JavaVersion.VERSION_1_10)
    }


    private void applyCommonPlugins(Project project) {
        List<Class<? extends Plugin>> commonPlugins = [HelloWorldPlugin.class, JavaLibraryPlugin.class, MavenPlugin.class,
                                                       MavenPublishPlugin.class, JacocoPlugin.class]
        project.configure(project) {
            commonPlugins.each {
                plugin ->
                    logger.info("Applying common plugin: $plugin")
                    project.plugins.apply(plugin)
            }
        }
    }
}
