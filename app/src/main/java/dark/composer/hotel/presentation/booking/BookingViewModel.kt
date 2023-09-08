package dark.composer.hotel.presentation.booking

import dark.composer.domain.model.booking.BookingDataModel
import dark.composer.domain.use_case.MainUseCase
import dark.composer.hotel.common.BaseViewModel
import dark.composer.hotel.common.models.UIObjectState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookingViewModel @Inject constructor(
    private val useCase: MainUseCase
) : BaseViewModel() {
    fun getBookingData(): Flow<UIObjectState<BookingDataModel>> =
        getObject { useCase.getBookingData() }
}