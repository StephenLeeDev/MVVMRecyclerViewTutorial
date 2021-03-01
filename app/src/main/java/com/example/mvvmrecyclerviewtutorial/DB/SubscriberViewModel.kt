package com.example.mvvmrecyclerviewtutorial.DB

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmrecyclerviewtutorial.R
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository : SubscriberRepository) : ViewModel() {

    val subscriber = repository.subscribers

    @Bindable
    val textViewInputName = MutableLiveData<String>()

    @Bindable
    val textViewInputEmail = MutableLiveData<String>()

    @Bindable
    val buttonSaveOrUpdate = MutableLiveData<String>()

    @Bindable
    val buttonDeleteAll = MutableLiveData<String>()

    init {
        buttonSaveOrUpdate.value = R.string.save.toString()
        buttonDeleteAll.value = R.string.clear_all.toString()
    }

    fun saveOrUpdate() {
        val name : String = textViewInputName.value!!
        val email : String = textViewInputEmail.value!!
        insert(Subscriber(0, name, email))
        textViewInputName.value = null
        textViewInputEmail.value = null
    }

    fun clearAllOrUpdate() {
        clearAll()
    }

    fun insert(subscriber: Subscriber) = viewModelScope.launch {
        repository.insert(subscriber)
    }

    fun update(subscriber: Subscriber) = viewModelScope.launch {
        repository.update(subscriber)
    }

    fun delete(subscriber: Subscriber) = viewModelScope.launch {
        repository.delete(subscriber)
    }

    fun clearAll() = viewModelScope.launch {
        repository.deleteAll()
    }
}