@file:OptIn(ExperimentalForeignApi::class)

package framework

import framework.entity.BackgroundProcess
import kotlinx.cinterop.ExperimentalForeignApi
import platform.BackgroundTasks.BGProcessingTask
import platform.BackgroundTasks.BGProcessingTaskRequest
import platform.BackgroundTasks.BGTaskScheduler

class BackgroundProcessManagerIosImpl : BackgroundProcessManager {

    private val runningProcesses = mutableMapOf<String, BGProcessingTaskRequest>()

    override fun startBackgroundProcess(process: BackgroundProcess) {
        // Register the background task
        BGTaskScheduler.sharedScheduler().registerForTaskWithIdentifier(process.tag, usingQueue = null) { task ->
            // Handle the background task
            handleBackgroundTask(task as BGProcessingTask, process)
        }

        // Schedule the background task
        scheduleBackgroundTask(process)
    }

    override fun stopBackgroundProcess(process: BackgroundProcess) {
        BGTaskScheduler.sharedScheduler().cancelTaskRequestWithIdentifier(process.tag)
        runningProcesses.remove(process.tag)
    }


    override fun stopAllBackgroundProcesses() {
        BGTaskScheduler.sharedScheduler().cancelAllTaskRequests()
        runningProcesses.clear()
    }

    private fun handleBackgroundTask(task: BGProcessingTask, process: BackgroundProcess) {
        task.expirationHandler = {
            // Task expired before completion
            process.onFailure()
            runningProcesses.remove(process.tag)
        }

        // Execute the background process
        process.process()

        task.setTaskCompletedWithSuccess(true)
        process.onSuccess()
        runningProcesses.remove(process.tag)

        // Schedule the next background task
        scheduleBackgroundTask(process)
    }

    private fun scheduleBackgroundTask(process: BackgroundProcess) {
        val request = BGProcessingTaskRequest(process.tag)
        request.requiresNetworkConnectivity = true
        request.requiresExternalPower = false

        BGTaskScheduler.sharedScheduler().submitTaskRequest(request, error = null)

        runningProcesses[process.tag] = request
    }
}

actual fun provideBackgroundProcessManager(): BackgroundProcessManager = BackgroundProcessManagerIosImpl()