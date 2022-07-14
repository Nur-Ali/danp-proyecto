package com.danp.proyecto_01.data

import android.app.Application

class ProductApplication : Application() {
    private val database by lazy { ProductRoomDatabase.getDatabase(this) }
    val repository by lazy { ProductRepository(database.productDao()) }
}