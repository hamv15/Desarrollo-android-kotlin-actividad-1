package com.hamv.modulo4.intent

import java.io.Serializable

data class Auto(
    val marca: String,
    val modelo: String,
    val year: Int,
    val km: Double,
    val activo: Boolean
): Serializable
