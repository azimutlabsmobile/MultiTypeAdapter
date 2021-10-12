package com.alabs.multitypeadapter.multiTypeAdapter

import com.google.gson.annotations.SerializedName

open class SearchMultiType(
    @SerializedName("UISearch.id") open val id: String,
    @SerializedName("UISearch.value") open val value: String
)