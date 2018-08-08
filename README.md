# gradle-composite-build-with-plugins

Usage: ./gradlew build

Minimal project to reproduce [bug](https://github.com/gradle/gradle/issues/6197)

```
FAILURE: Build failed with an exception.

* What went wrong:
Could not determine the dependencies of task ':custom-java-library-plugin:compileGroovy'.
> ProjectScopeServices has been closed.

* Try:
Run with --info or --debug option to get more log output. Run with --scan to get full insights.

* Exception is:
org.gradle.api.internal.tasks.TaskDependencyResolveException: Could not determine the dependencies of task ':custom-java-library-plugin:compileGroovy'.
        at org.gradle.api.internal.tasks.CachingTaskDependencyResolveContext.getDependencies(CachingTaskDependencyResolveContext.java:66)
        at org.gradle.execution.taskgraph.TaskDependencyResolver.resolveDependenciesFor(TaskDependencyResolver.java:46)
        at org.gradle.execution.taskgraph.LocalTaskInfo.getDependencies(LocalTaskInfo.java:89)
        at org.gradle.execution.taskgraph.LocalTaskInfo.resolveDependencies(LocalTaskInfo.java:62)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionPlan.addToTaskGraph(DefaultTaskExecutionPlan.java:168)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph.addTasks(DefaultTaskExecutionGraph.java:126)
        at org.gradle.execution.TaskNameResolvingBuildConfigurationAction.configure(TaskNameResolvingBuildConfigurationAction.java:47)
        at org.gradle.execution.DefaultBuildConfigurationActionExecuter.configure(DefaultBuildConfigurationActionExecuter.java:48)
        at org.gradle.execution.DefaultBuildConfigurationActionExecuter.access$000(DefaultBuildConfigurationActionExecuter.java:25)
        at org.gradle.execution.DefaultBuildConfigurationActionExecuter$1.proceed(DefaultBuildConfigurationActionExecuter.java:54)
        at org.gradle.execution.DefaultTasksBuildExecutionAction.configure(DefaultTasksBuildExecutionAction.java:44)
        at org.gradle.execution.DefaultBuildConfigurationActionExecuter.configure(DefaultBuildConfigurationActionExecuter.java:48)
        at org.gradle.execution.DefaultBuildConfigurationActionExecuter.access$000(DefaultBuildConfigurationActionExecuter.java:25)
        at org.gradle.execution.DefaultBuildConfigurationActionExecuter$1.proceed(DefaultBuildConfigurationActionExecuter.java:54)
        at org.gradle.execution.ExcludedTaskFilteringBuildConfigurationAction.configure(ExcludedTaskFilteringBuildConfigurationAction.java:47)
        at org.gradle.execution.DefaultBuildConfigurationActionExecuter.configure(DefaultBuildConfigurationActionExecuter.java:48)
        at org.gradle.execution.DefaultBuildConfigurationActionExecuter.select(DefaultBuildConfigurationActionExecuter.java:36)
        at org.gradle.initialization.DefaultGradleLauncher$CalculateTaskGraph.run(DefaultGradleLauncher.java:305)
        at org.gradle.internal.operations.DefaultBuildOperationExecutor$RunnableBuildOperationWorker.execute(DefaultBuildOperationExecutor.java:300)
        at org.gradle.internal.operations.DefaultBuildOperationExecutor$RunnableBuildOperationWorker.execute(DefaultBuildOperationExecutor.java:292)
        at org.gradle.internal.operations.DefaultBuildOperationExecutor.execute(DefaultBuildOperationExecutor.java:174)
        at org.gradle.internal.operations.DefaultBuildOperationExecutor.run(DefaultBuildOperationExecutor.java:90)
        at org.gradle.internal.operations.DelegatingBuildOperationExecutor.run(DelegatingBuildOperationExecutor.java:31)
        at org.gradle.initialization.DefaultGradleLauncher.constructTaskGraph(DefaultGradleLauncher.java:190)
        at org.gradle.initialization.DefaultGradleLauncher.doBuildStages(DefaultGradleLauncher.java:145)
        at org.gradle.initialization.DefaultGradleLauncher.scheduleTasks(DefaultGradleLauncher.java:211)
        at org.gradle.composite.internal.DefaultIncludedBuild.execute(DefaultIncludedBuild.java:239)
        at org.gradle.composite.internal.DefaultIncludedBuildController.doBuild(DefaultIncludedBuildController.java:196)
        at org.gradle.composite.internal.DefaultIncludedBuildController.run(DefaultIncludedBuildController.java:106)
        at org.gradle.composite.internal.DefaultIncludedBuildControllers$BuildOpRunnable.run(DefaultIncludedBuildControllers.java:118)
        at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:63)
        at org.gradle.internal.concurrent.ManagedExecutorImpl$1.run(ManagedExecutorImpl.java:46)
        at org.gradle.internal.concurrent.ThreadFactoryImpl$ManagedThreadRunnable.run(ThreadFactoryImpl.java:55)
Caused by: java.lang.IllegalStateException: ProjectScopeServices has been closed.
        at org.gradle.internal.service.DefaultServiceRegistry.serviceRequested(DefaultServiceRegistry.java:261)
        at org.gradle.internal.service.DefaultServiceRegistry.getService(DefaultServiceRegistry.java:296)
        at org.gradle.internal.service.DefaultServiceRegistry.find(DefaultServiceRegistry.java:291)
        at org.gradle.internal.service.DefaultServiceRegistry.get(DefaultServiceRegistry.java:281)
        at org.gradle.internal.service.DefaultServiceRegistry.get(DefaultServiceRegistry.java:276)
        at org.gradle.execution.taskgraph.TaskInfoFactory$TaskInAnotherBuild.<init>(TaskInfoFactory.java:79)
        at org.gradle.execution.taskgraph.TaskInfoFactory.getOrCreateNode(TaskInfoFactory.java:57)
        at org.gradle.execution.taskgraph.TaskInfoWorkDependencyResolver$1.execute(TaskInfoWorkDependencyResolver.java:39)
        at org.gradle.execution.taskgraph.TaskInfoWorkDependencyResolver$1.execute(TaskInfoWorkDependencyResolver.java:36)
        at org.gradle.api.internal.tasks.WorkDependencyResolver$1.resolve(WorkDependencyResolver.java:43)
        at org.gradle.execution.taskgraph.TaskInfoWorkDependencyResolver.resolve(TaskInfoWorkDependencyResolver.java:36)
        at org.gradle.api.internal.tasks.CachingTaskDependencyResolveContext$TaskGraphImpl.getNodeValues(CachingTaskDependencyResolveContext.java:104)
        at org.gradle.internal.graph.CachingDirectedGraphWalker$GraphWithEmpyEdges.getNodeValues(CachingDirectedGraphWalker.java:211)
        at org.gradle.internal.graph.CachingDirectedGraphWalker.doSearch(CachingDirectedGraphWalker.java:121)
        at org.gradle.internal.graph.CachingDirectedGraphWalker.findValues(CachingDirectedGraphWalker.java:73)
        at org.gradle.api.internal.tasks.CachingTaskDependencyResolveContext.getDependencies(CachingTaskDependencyResolveContext.java:64)
        ... 32 more
```

