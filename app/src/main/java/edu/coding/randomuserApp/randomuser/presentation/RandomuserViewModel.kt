package edu.coding.randomuserApp.randomuser.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.coding.randomuserApp.randomuser.data.remote.response.Name
import edu.coding.randomuserApp.randomuser.domain.repository.RandomUserRepository
import edu.coding.randomuserApp.randomuser.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RandomuserViewModel @Inject constructor(
    private val randomUserRepository: RandomUserRepository
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

            randomUserRepository.getTenRandomusers(
            )
                .collectLatest { result ->
                    when (result) {
                        is Resource.Success -> {
                            result.data?.let { randomuser ->
                                _randomuserState.update { randState ->
                                    randState.copy(
                                        randomuserName = randomuserState.value.randomuserName?.copy(
                                            first = randomuser.name.first,
                                            last = randomuser.name.last,
                                            title = randomuser.name.title
                                        ),
                                        isLoading = false
                                    )
                                }
                            }
                        }

                        is Resource.Error -> {
                            _randomuserState.update {
                                it.copy(
//                                    randomuserName = null,
                                    isLoading = false
                                )
                            }
                        }

                        is Resource.Loading -> {
                            _randomuserState.update {
                                it.copy(
//                                    randomuser = null,
                                    isLoading = true
                                )
                            }
                        }
                    }
                }
        }

    }


}