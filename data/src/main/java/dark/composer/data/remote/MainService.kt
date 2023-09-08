package dark.composer.data.remote

import dark.composer.data.remote.dto.booking.BookingDataDto
import dark.composer.data.remote.dto.hotel.HotelDto
import dark.composer.data.remote.dto.rooms.RoomsHeaderDto
import retrofit2.Response
import retrofit2.http.*

interface MainService {

    @GET("f9a38183-6f95-43aa-853a-9c83cbb05ecd")
    suspend fun getRooms(): Response<RoomsHeaderDto>

    @GET("35e0d18e-2521-4f1b-a575-f0fe366f66e3")
    suspend fun getHotel(): Response<HotelDto>

    @GET("e8868481-743f-4eb2-a0d7-2bc4012275c8")
    suspend fun getBookingData(): Response<BookingDataDto>

}
