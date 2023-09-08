package dark.composer.hotel.di.module

import dagger.Module
import dagger.Provides
import dark.composer.data.repository.MainRepositoryImpl
import dark.composer.data.repository.datasourse.MainRemoteDatasource
import dark.composer.domain.repository.MainRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(mainRemoteDataSource: MainRemoteDatasource): MainRepository {
        return MainRepositoryImpl(mainRemoteDataSource)
    }
}