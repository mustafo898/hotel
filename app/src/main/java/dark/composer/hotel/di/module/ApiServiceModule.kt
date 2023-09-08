package dark.composer.hotel.di.module

import dagger.Module
import dagger.Provides
import dark.composer.data.remote.MainService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiServiceModule {

    @Singleton
    @Provides
    fun provideMainService(retrofit: Retrofit): MainService =
        retrofit.create(MainService::class.java)

}