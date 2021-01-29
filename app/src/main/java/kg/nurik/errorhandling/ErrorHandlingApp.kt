package kg.nurik.errorhandling

import android.app.Application
import kg.nurik.errorhandling.di.appModules
import org.koin.core.context.startKoin

class ErrorHandlingApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            (this@ErrorHandlingApp)
            modules(appModules)
        }
    }

}