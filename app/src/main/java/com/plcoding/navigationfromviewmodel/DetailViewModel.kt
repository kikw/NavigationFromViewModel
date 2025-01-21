package com.plcoding.navigationfromviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel() {

    fun goBack() {
        viewModelScope.launch {
            navigator.navigateUp()
        }
    }
}