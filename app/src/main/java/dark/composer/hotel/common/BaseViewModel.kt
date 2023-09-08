package dark.composer.hotel.common

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dark.composer.domain.common.Resource
import dark.composer.hotel.common.models.UIListState
import dark.composer.hotel.common.models.UIObjectState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    fun <T> getList(
        repositoryCall: suspend () -> Flow<Resource<List<T>>>,
    ): Flow<UIListState<T>> {
        val listState = MutableStateFlow(UIListState<T>())

        viewModelScope.launch(Dispatchers.IO) {
            repositoryCall().onEach {
                when (it) {
                    is Resource.Error -> {
                        listState.value = UIListState(it.message ?: "")
                    }

                    is Resource.Loading -> {
                        listState.value = UIListState(isLoading = true)
                    }

                    is Resource.Success -> {
                        listState.value = UIListState(data = it.data)
                    }
                }
            }.launchIn(CoroutineScope(Dispatchers.IO))
        }

        return listState.asStateFlow()
    }

    fun <T> getObject(
        repositoryCall: suspend () -> Flow<Resource<T>>,
    ): Flow<UIObjectState<T>> {
        val objectState = MutableStateFlow(UIObjectState<T>())

        viewModelScope.launch {
            repositoryCall().onEach {
                when (it) {
                    is Resource.Error -> {
                        objectState.value = UIObjectState(it.message ?: "")
                    }

                    is Resource.Loading -> {
                        objectState.value = UIObjectState(isLoading = true)
                    }

                    is Resource.Success -> {
                        objectState.value = UIObjectState(data = it.data)
                    }
                }
            }.launchIn(CoroutineScope(Dispatchers.IO))
        }

        return objectState.asStateFlow()
    }

}