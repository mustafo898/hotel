package dark.composer.data.repository

import dark.composer.data.common.ResultHandler
import dark.composer.data.mapper.toModel
import dark.composer.data.repository.datasourse.MainRemoteDatasource
import dark.composer.domain.common.Resource
import dark.composer.domain.model.booking.BookingDataModel
import dark.composer.domain.model.hotel.HotelModel
import dark.composer.domain.model.rooms.RoomsHeaderModel
import dark.composer.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val datasource: MainRemoteDatasource
) : MainRepository, ResultHandler() {

    override suspend fun getRooms(): Flow<Resource<RoomsHeaderModel>> =
        loadResult({ datasource.getRooms() }, { data, flow ->
            try {
                flow.emit(Resource.Success(data.toModel()))
            } catch (e: Exception) {
                flow.emit(Resource.Error(e.message.toString()))
            }
        })

    override suspend fun getHotel(): Flow<Resource<HotelModel>> =
        loadResult({ datasource.getHotel() }, { data, flow ->
            try {
                flow.emit(Resource.Success(data.toModel()))
            } catch (e: Exception) {
                flow.emit(Resource.Error(e.message.toString()))
            }
        })

    override suspend fun getBookingData(): Flow<Resource<BookingDataModel>> =
        loadResult({ datasource.getBookingData() }, { data, flow ->
            try {
                flow.emit(Resource.Success(data.toModel()))
            } catch (e: Exception) {
                flow.emit(Resource.Error(e.message.toString()))
            }
        })

}