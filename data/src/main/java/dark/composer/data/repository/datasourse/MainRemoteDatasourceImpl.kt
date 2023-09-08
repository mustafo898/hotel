package dark.composer.data.repository.datasourse

import dark.composer.data.remote.MainService
import dark.composer.data.remote.dto.booking.BookingDataDto
import dark.composer.data.remote.dto.hotel.HotelDto
import dark.composer.data.remote.dto.rooms.RoomsHeaderDto
import retrofit2.Response
import javax.inject.Inject

class MainRemoteDatasourceImpl @Inject constructor(
    private val service: MainService
) : MainRemoteDatasource {
    override suspend fun getRooms(): Response<RoomsHeaderDto> {
        return service.getRooms()
    }

    override suspend fun getHotel(): Response<HotelDto> {
        return service.getHotel()
    }

    override suspend fun getBookingData(): Response<BookingDataDto> {
        return service.getBookingData()
    }
}