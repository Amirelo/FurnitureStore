package com.example.furniturestore.models

import android.os.Parcel
import android.os.Parcelable

data class ProductInfo(
    var productInfoID: Int,
    var height: Double,
    var width: Double,
    var depth: Double,
    var weight: Double,
    var mainMaterial: String?,
    var otherMaterial: String?,
    var productID: Int,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(productInfoID)
        parcel.writeDouble(height)
        parcel.writeDouble(width)
        parcel.writeDouble(depth)
        parcel.writeDouble(weight)
        parcel.writeString(mainMaterial)
        parcel.writeString(otherMaterial)
        parcel.writeInt(productID)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductInfo> {
        override fun createFromParcel(parcel: Parcel): ProductInfo {
            return ProductInfo(parcel)
        }

        override fun newArray(size: Int): Array<ProductInfo?> {
            return arrayOfNulls(size)
        }
    }
}