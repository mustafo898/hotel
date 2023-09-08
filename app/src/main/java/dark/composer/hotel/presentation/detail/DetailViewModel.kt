package dark.composer.hotel.presentation.detail

import dark.composer.domain.model.rooms.RoomsHeaderModel
import dark.composer.domain.use_case.MainUseCase
import dark.composer.hotel.common.BaseViewModel
import dark.composer.hotel.common.models.UIObjectState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val useCase: MainUseCase
) : BaseViewModel() {
    fun getRooms(): Flow<UIObjectState<RoomsHeaderModel>> = getObject { useCase.getRooms() }
}