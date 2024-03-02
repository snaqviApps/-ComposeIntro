package edu.coding.composeintro.randomuser.util

sealed class Screen(val rout: String) {
    object Home : Screen("main")
    object Details : Screen("details")
}