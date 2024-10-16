package edu.ruben.pokeapp.app.domain

sealed class ErrorApp {
    object InternetErrorApp : ErrorApp()
    object ServerErrorApp: ErrorApp()
    object DataErrorApp: ErrorApp()
    object UnknowErrorApp: ErrorApp()
}