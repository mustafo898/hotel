package dark.composer.data.repository.datasourse

import dark.composer.data.remote.dto.booking.BookingDataDto
import dark.composer.data.remote.dto.hotel.HotelDto
import dark.composer.data.remote.dto.rooms.RoomsHeaderDto
import retrofit2.Response

interface MainRemoteDatasource {
    suspend fun getRooms(): Response<RoomsHeaderDto>
    suspend fun getHotel(): Response<HotelDto>
    suspend fun getBookingData(): Response<BookingDataDto>
}