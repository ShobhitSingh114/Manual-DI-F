package com.example.manual_di.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.manual_di.domain.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel(
    private val authRepository: AuthRepository
): ViewModel() {

    fun login() {
        viewModelScope.launch {
            authRepository.login("test@test.com", "test123")
        }
    }
}



//@HiltViewModel
//class MainViewModel @Inject constructor(
//    private val authRepository: AuthRepository
//): ViewModel() {
//    fun login() {
//        viewModelScope.launch {
//            authRepository.login("test@test.com", "test123")
//        }
//    }
//}