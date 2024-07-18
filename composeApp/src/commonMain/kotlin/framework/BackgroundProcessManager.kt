package framework

import framework.entity.BackgroundProcess

interface BackgroundProcessManager {
    fun startBackgroundProcess(process: BackgroundProcess)
    fun stopBackgroundProcess(process: BackgroundProcess)
    fun stopAllBackgroundProcesses()

}

expect fun provideBackgroundProcessManager(): BackgroundProcessManager