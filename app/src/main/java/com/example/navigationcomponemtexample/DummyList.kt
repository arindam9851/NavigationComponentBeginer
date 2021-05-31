package com.example.navigationcomponemtexample

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class DummyList:ArrayList<DummyModel>(),Parcelable {
}