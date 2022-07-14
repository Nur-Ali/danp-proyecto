package com.danp.proyecto_01.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1, exportSchema = false)
public abstract class ProductRoomDatabase: RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var INSTANCE: ProductRoomDatabase? = null

        fun getDatabase(context: Context): ProductRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductRoomDatabase::class.java,
                    "product_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}