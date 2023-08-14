package com.example.roadmapproject.ui.login


import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel() {

    val mLoginLiveData = MutableLiveData<String>()
    val mPasswordLiveData = MutableLiveData<String>()
    val mLoginPasswordMediator = MediatorLiveData<Boolean>()

    init {
        mLoginPasswordMediator.addSource(mLoginLiveData) { validateForm() }
        mLoginPasswordMediator.addSource(mPasswordLiveData) { validateForm() }

    }

    private fun validateForm() {
        val isValidEmail = android.util.Patterns.EMAIL_ADDRESS.matcher(mLoginLiveData.value.toString()).matches()
        val isValidPassword = mPasswordLiveData.value.toString().length in 8..15
        mLoginPasswordMediator.value = isValidEmail && isValidPassword
    }

    override fun onCleared() {
        // DO NOT forget to remove sources from mediator
        mLoginPasswordMediator.removeSource(mLoginLiveData)
        mLoginPasswordMediator.removeSource(mPasswordLiveData)
    }

}