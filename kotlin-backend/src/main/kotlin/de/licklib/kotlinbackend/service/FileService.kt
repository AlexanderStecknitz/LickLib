package de.licklib.kotlinbackend.service

import de.licklib.kotlinbackend.model.File
import de.licklib.kotlinbackend.properties.BucketProperties
import io.minio.MinioClient
import org.springframework.stereotype.Service

@Service
class FileService(
    private val bucketService: BucketService,
    private val bucketProperties: BucketProperties
) {

    fun uploadFile(file: File) {
        bucketService.uploadFile(
            file = file,
            bucketName = bucketProperties.bucket
        )
    }

}