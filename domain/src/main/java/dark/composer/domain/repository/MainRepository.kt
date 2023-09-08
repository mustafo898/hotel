package dark.composer.domain.repository

import dark.composer.domain.common.Resource
import dark.composer.domain.model.booking.BookingDataModel
import dark.composer.domain.model.hotel.HotelModel
import dark.composer.domain.model.rooms.RoomsHeaderModel
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getRooms():Flow<Resource<RoomsHeaderModel>>
    suspend fun getHotel():Flow<Resource<HotelModel>>
    suspend fun getBookingData():Flow<Resource<BookingDataModel>>
}