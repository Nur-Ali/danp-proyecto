package com.danp.proyecto_01.data

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class ProductRepository(private val productDao: ProductDao) {
    val allProducts: Flow<List<Product>> = productDao.getAllProducts()

    fun getProduct(id: Int): Flow<Product> {
        return productDao.getProduct(id)
    }

    @Suppress("RedundantSuppressModifier")
    @WorkerThread
    suspend fun insertProduct(product: Product) {
        productDao.insert(product)
    }

    @Suppress("RedundantSuppressModifier")
    @WorkerThread
    suspend fun addProduct(product: Product) {
        productDao.insert(product)
    }

    @Suppress("RedundantSuppressModifier")
    @WorkerThread
    suspend fun updateProduct(product: Product) {
        productDao.update(product)

    }

    @Suppress("RedundantSuppressModifier")
    @WorkerThread
    suspend fun deleteProduct(product: Product){
        productDao.delete(product)
    }
}