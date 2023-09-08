package dark.composer.hotel

import android.app.Application
import dark.composer.hotel.di.component.AppComponent
import dark.composer.hotel.di.component.DaggerAppComponent
import dark.composer.hotel.di.module.ApiServiceModule
import dark.composer.hotel.di.module.DataSourceModule
import dark.composer.hotel.di.module.NetworkModule
import dark.composer.hotel.di.module.RepositoryModule

class App : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .networkModule(NetworkModule(this))
            .repositoryModule(RepositoryModule())
            .apiServiceModule(ApiServiceModule())
            .dataSourceModule(DataSourceModule())
            .build()

    }
}