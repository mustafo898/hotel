package dark.composer.hotel.presentation.main

import dark.composer.domain.model.hotel.HotelModel
import dark.composer.domain.use_case.MainUseCase
import dark.composer.hotel.common.BaseViewModel
import dark.composer.hotel.common.models.UIObjectState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val useCase: MainUseCase
) : BaseViewModel() {
    fun getHotel(): Flow<UIObjectState<HotelModel>> = getObject { useCase.getHotel() }
}