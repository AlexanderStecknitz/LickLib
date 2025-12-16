package de.licklib.kotlinbackend.model

import java.io.InputStream

data class File(
    val name: String,
    val size: Long,
    val contentType: String,
    val duration: Long,
    val inputStream: InputStream
)