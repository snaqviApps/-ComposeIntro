package edu.coding.randomuserApp.randomuser.util

sealed class Screen(val rout: String) {
    object Home : Screen("main")
    object Details : Screen("details")
}