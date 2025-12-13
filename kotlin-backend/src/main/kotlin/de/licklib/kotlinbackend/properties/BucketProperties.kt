package de.licklib.kotlinbackend.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "bucket")
data class BucketProperties(
    val endpoint: String,
    val accessKey: String,
    val secretKey: String,
    val bucket: String
)