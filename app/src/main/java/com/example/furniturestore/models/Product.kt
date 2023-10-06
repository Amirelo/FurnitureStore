package com.example.furniturestore.models

import android.os.Parcel
import android.os.Parcelable

data class Product(
    var id: Int,
    var prodName: String,
    var price:Double,
    var description: String,
    var addedDate: String,
    var prodImg: String,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readDouble(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(prodName)
        parcel.writeDouble(price)
        parcel.writeString(description)
        parcel.writeString(addedDate)
        parcel.writeString(prodImg)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}


