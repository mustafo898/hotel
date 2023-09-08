package dark.composer.domain.use_case

import dark.composer.domain.common.Resource
import dark.composer.domain.model.booking.BookingDataModel
import dark.composer.domain.model.hotel.HotelModel
import dark.composer.domain.model.rooms.RoomsHeaderModel
import dark.composer.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainUseCase @Inject constructor(
    private val repository: MainRepository
) {
    suspend fun getRooms(): Flow<Resource<RoomsHeaderModel>> = repository.getRooms()
    suspend fun getHotel(): Flow<Resource<HotelModel>> = repository.getHotel()
    suspend fun getBookingData(): Flow<Resource<BookingDataModel>> = repository.getBookingData()
}