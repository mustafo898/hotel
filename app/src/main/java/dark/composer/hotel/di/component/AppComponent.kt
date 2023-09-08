package dark.composer.hotel.di.component

import dagger.Component
import dark.composer.hotel.di.module.ApiServiceModule
import dark.composer.hotel.di.module.DataSourceModule
import dark.composer.hotel.di.module.NetworkModule
import dark.composer.hotel.di.module.RepositoryModule
import dark.composer.hotel.presentation.booking.BookingFragment
import dark.composer.hotel.presentation.detail.DetailFragment
import dark.composer.hotel.presentation.main.MainFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules =
    [
        ApiServiceModule::class,
        DataSourceModule::class,
        NetworkModule::class,
        RepositoryModule::class,
    ]
)

interface AppComponent {
    fun inject(mainFragment: MainFragment)
    fun inject(mainFragment: DetailFragment)
    fun inject(bookingFragment: BookingFragment)
}