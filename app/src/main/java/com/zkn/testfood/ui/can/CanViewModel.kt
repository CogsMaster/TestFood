package com.zkn.testfood.ui.can

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CanViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Can Fragment"
    }
    val text: LiveData<String> = _text
}