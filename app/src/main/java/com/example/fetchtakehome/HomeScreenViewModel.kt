package com.example.fetchtakehome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.FetchListUseCase
import com.example.data.GetListUseCase
import com.example.data.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val getListUseCase: GetListUseCase, private val fetchListUseCase: FetchListUseCase): ViewModel() {
    private var itemList = MutableStateFlow(listOf<Item>())
    val _itemList: StateFlow<List<Item>>
        get() = itemList

     fun getList(){
        viewModelScope.launch(Dispatchers.IO) {
            fetchListUseCase.execute()
            itemList.value = getListUseCase.execute().first()
        }
    }
}