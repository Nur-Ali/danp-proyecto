package com.danp.proyecto_01.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class Product (
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "name")
    val productName: String,

    @ColumnInfo(name = "description")
    val productDescription: String,

    @ColumnInfo(name = "image")
    val productImage: String,

    @ColumnInfo(name = "amount")
    val productAmount: String,

    @ColumnInfo(name = "price")
    val productPrice: String,

    @ColumnInfo(name = "status")
    val productStatus: String,

    @ColumnInfo(name = "colorText")
    val productColorText: String,

    @ColumnInfo(name = "type")
    val productType: String,

    @ColumnInfo(name = "registrationDate")
    val productRegistrationDate: String,

    @ColumnInfo(name = "expirationDate")
    val productExpirationDate: String,

    @ColumnInfo(name = "purchaseDate")
    val productPurchaseDate: String,

)