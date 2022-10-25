package net.denis.memebuilder.di

import android.app.Application
import net.denis.memebuilder.di.modules.featuresModule
import net.denis.memebuilder.di.modules.networkModule
import net.denis.memebuilder.di.modules.repositoryModule
import net.denis.memebuilder.di.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class MemeBuilderApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MemeBuilderApplication)
            modules(listOf(
                featuresModule,
                networkModule,
                repositoryModule,
                viewModelModule
            ))
        }
    }

}