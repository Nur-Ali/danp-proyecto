package com.danp.proyecto_01.data

import androidx.lifecycle.*
import kotlinx.coroutines.launch


class ProductViewModel(private val repository: ProductRepository) : ViewModel() {
    val allProducts: LiveData<List<Product>> = repository.allProducts.asLiveData()

    fun getProduct(id: Int): LiveData<Product> = repository.getProduct(id).asLiveData()

    fun addProduct(product: Product) = viewModelScope.launch {
        repository.insertProduct(product)
    }

    fun updateProduct(product: Product) = viewModelScope.launch {
        repository.updateProduct(product)
    }

    fun deleteProduct(product: Product) = viewModelScope.launch {
        repository.deleteProduct(product)
    }

    fun isItemValid(carPlate: String, carColor: String, carBrand: String, carModel: String): Boolean {
        if (carPlate.trim().isBlank()
            || carColor.trim().isBlank()
            || carBrand.trim().isBlank()
            || carModel.trim().isBlank()
        ) {
            return false
        }
        return true
    }
}

class ProductViewModelFactory(private val repository: ProductRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProductViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
