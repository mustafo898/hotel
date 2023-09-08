package dark.composer.data.mapper

import dark.composer.data.remote.dto.booking.BookingDataDto
import dark.composer.data.remote.dto.hotel.AboutTheHotelDto
import dark.composer.data.remote.dto.hotel.HotelDto
import dark.composer.data.remote.dto.rooms.RoomDto
import dark.composer.data.remote.dto.rooms.RoomsHeaderDto
import dark.composer.domain.model.booking.BookingDataModel
import dark.composer.domain.model.hotel.AboutTheHotelModel
import dark.composer.domain.model.hotel.HotelModel
import dark.composer.domain.model.rooms.RoomModel
import dark.composer.domain.model.rooms.RoomsHeaderModel

fun RoomDto.toModel(): RoomModel {
    return RoomModel(id, image_urls, name, peculiarities, price, price_per)
}

fun RoomsHeaderDto.toModel(): RoomsHeaderModel {
    return RoomsHeaderModel(rooms.map { it.toModel() })
}

fun BookingDataDto.toModel(): BookingDataModel {
    return BookingDataModel(
        arrival_country,
        departure,
        fuel_charge,
        horating,
        hotel_adress,
        hotel_name,
        id,
        number_of_nights,
        nutrition,
        rating_name,
        room,
        service_charge,
        tour_date_start,
        tour_date_stop,
        tour_price
    )
}

fun HotelDto.toModel(): HotelModel {
    return HotelModel(
        about_the_hotel.toModel(),
        adress,
        id,
        image_urls,
        minimal_price,
        name,
        price_for_it,
        rating,
        rating_name
    )
}

fun AboutTheHotelDto.toModel(): AboutTheHotelModel {
    return AboutTheHotelModel(description, peculiarities)
}