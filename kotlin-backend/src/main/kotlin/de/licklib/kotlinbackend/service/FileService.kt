package de.licklib.kotlinbackend.service

import de.licklib.kotlinbackend.model.File
import de.licklib.kotlinbackend.properties.BucketProperties
import org.springframework.stereotype.Service

@Service
class FileService(
    private val bucketService: BucketService,
    private val bucketProperties: BucketProperties
) {

    fun uploadFile(file: File): File {
        val uploadedFile = bucketService.uploadFile(
            file = file,
            bucketName = bucketProperties.name
        )

        return uploadedFile
    }

}