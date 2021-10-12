package com.alabs.multitypeadapter.utils.extensions

/**
 * Преобразовывет List в ArrayList
 */
fun <T> List<T>.toArrayList() = ArrayList(this)