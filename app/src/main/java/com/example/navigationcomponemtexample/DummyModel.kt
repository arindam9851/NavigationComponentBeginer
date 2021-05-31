package com.example.navigationcomponemtexample

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DummyModel(var name :String, var dob: String) : Parcelable{

}