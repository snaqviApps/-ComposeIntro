package edu.coding.randomuserApp.randomuser.presentation

import edu.coding.randomuserApp.randomuser.data.remote.response.Name
import edu.coding.randomuserApp.randomuser.domain.model.Randomuser

data class RandomuserState(
    val randomuserName : Name? = null,
    val isLoading: Boolean = false
)