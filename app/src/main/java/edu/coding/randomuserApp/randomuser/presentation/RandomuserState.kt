package edu.coding.randomuserApp.randomuser.presentation

import edu.coding.randomuserApp.randomuser.domain.model.Randomuser

data class RandomuserState(
//    val randomuserList: List<Randomuser> = emptyList(),
    val randomuserEntry: Randomuser? = null,
    val isLoading: Boolean = false
)