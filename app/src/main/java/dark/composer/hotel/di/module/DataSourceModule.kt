package dark.composer.hotel.di.module

import dagger.Module
import dagger.Provides
import dark.composer.data.remote.MainService
import dark.composer.data.repository.datasourse.MainRemoteDatasource
import dark.composer.data.repository.datasourse.MainRemoteDatasourceImpl
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Provides
    @Singleton
    fun provideMainDataSource(mainApiService: MainService): MainRemoteDatasource {
        return MainRemoteDatasourceImpl(mainApiService)
    }

}