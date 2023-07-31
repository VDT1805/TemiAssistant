package com.ibsystem.temifoodorder.presentation.screen.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.ibsystem.temifoodorder.domain.model.ProductItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(

) : ViewModel() {
    private val _productCartList = MutableStateFlow<List<ProductItem>>(emptyList())
    val productCartList = _productCartList.asStateFlow()

    init {
        getAllProductCartList()
    }

    private fun getAllProductCartList() {
        // TODO: getAllProductCartList
    }

    fun deleteCart(productItem: ProductItem) {
        // TODO: deleteCart
    }

}