package edu.coding.randomuserApp.randomuser.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.coding.randomuserApp.randomuser.data.remote.response.Name
import edu.coding.randomuserApp.randomuser.domain.repository.RandomUserRepository
import edu.coding.randomuserApp.randomuser.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomuserViewModel @Inject constructor(
    private val iRandomUserRepository: RandomUserRepository
) : ViewModel() {
    private val _randomuserState = MutableStateFlow(RandomuserState())
    val randomuserState = _randomuserState.asStateFlow()

    init {
        getRandomuser()
    }

    private fun getRandomuser() {
        viewModelScope.launch {
            _randomuserState.update {
                it.copy(isLoading = true)
            }

            iRandomUserRepository.getTenRandomusers(
//                id = -1,
                name = Name(
                    first = "",
                    last = "",
                    title = ""
                )
            )
                .collectLatest { result ->
                    when (result) {
                        is Resource.Success -> {
                            _randomuserState.update {
                                it.copy(
                                    randomuserEntry = result.data,
                                    isLoading = false
                                )
                            }
                        }

                        is Resource.Error -> {
                            _randomuserState.update {
                                it.copy(
                                    randomuserEntry = null,
                                    isLoading = false
                                )
                            }
                        }

                        is Resource.Loading -> {
                            _randomuserState.update {
                                it.copy(
                                    randomuserEntry = null,
                                    isLoading = true
                                )
                            }
                        }
                    }
                }
        }

    }


}