package framework

import android.content.Context
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import framework.entity.BackgroundProcess
import org.koin.java.KoinJavaComponent.get

class BackgroundProcessManagerAndroidImpl(private val context: Context) : BackgroundProcessManager {
    override fun startBackgroundProcess(process: BackgroundProcess) {
        require(process.manager is Worker) {
            (process.manager as Worker).let {
                val workRequest: OneTimeWorkRequest =
                    OneTimeWorkRequest.Builder(it::class.java)
                        .addTag(process.tag).build()
                WorkManager.getInstance(context).enqueueUniqueWork(
                    process.tag,
                    ExistingWorkPolicy.REPLACE,
                    workRequest
                )
            }

        }
    }

    override fun stopBackgroundProcess(process: BackgroundProcess) {
       WorkManager.getInstance(context).cancelUniqueWork(process.tag)
    }

    override fun stopAllBackgroundProcesses() {
        WorkManager.getInstance(context).cancelAllWork()
    }

}


actual fun provideBackgroundProcessManager(): BackgroundProcessManager = BackgroundProcessManagerAndroidImpl(get(Context::class.java))