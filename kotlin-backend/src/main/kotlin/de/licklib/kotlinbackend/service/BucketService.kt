package de.licklib.kotlinbackend.service

import de.licklib.kotlinbackend.model.File
import io.minio.MinioClient
import io.minio.PutObjectArgs
import org.springframework.stereotype.Service
import java.io.InputStream

@Service
class BucketService(
    private val minioClient: MinioClient
) {

    fun uploadFile(file: File, bucketName: String) {
        minioClient.putObject(
            PutObjectArgs.builder()
                .bucket(bucketName)
                .`object`(file.name)
                .stream(file.inputStream, file.size, -1)
                .contentType(file.contentType)
                .build()
        );
    }

}