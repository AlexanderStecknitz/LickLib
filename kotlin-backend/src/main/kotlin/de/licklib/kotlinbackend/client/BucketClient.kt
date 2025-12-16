package de.licklib.kotlinbackend.client

import de.licklib.kotlinbackend.properties.BucketProperties
import io.minio.MinioClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BucketClient(
    private val bucketProperties: BucketProperties
) {
    @Bean
    fun bucketClientConfig(): MinioClient {
        val minioClient = MinioClient.builder()
            .endpoint(bucketProperties.endpoint)
            .credentials(bucketProperties.accessKey, bucketProperties.secretKey)
            .build()

        return minioClient
    }
}