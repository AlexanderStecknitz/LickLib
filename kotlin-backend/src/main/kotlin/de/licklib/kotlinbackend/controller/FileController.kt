package de.licklib.kotlinbackend.controller

import de.licklib.kotlinbackend.controller.dto.UploadFileResponseDTO
import de.licklib.kotlinbackend.model.File
import de.licklib.kotlinbackend.service.FileService
import io.minio.MinioClient
import io.minio.PutObjectArgs
import io.minio.UploadObjectArgs
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/file")
class FileController(
    private val fileService: FileService
) {

    @PostMapping("/upload")
    fun uploadFile(@RequestParam("file") file: MultipartFile): ResponseEntity<UploadFileResponseDTO> {

        if(file.originalFilename == null || file.contentType == null) {
            return ResponseEntity.badRequest().build()
        }

        val originalName = file.originalFilename as String
        val contentType = file.contentType as String

        val file = File(
            name = originalName,
            size = file.size,
            contentType = contentType,
            duration = 1,
            inputStream = file.inputStream
        )

        val uploadedFile = fileService.uploadFile(file = file)

        log.info("upload file: ${uploadedFile.name}")

        val uploadFileResponseDTO = UploadFileResponseDTO(
            file = uploadedFile
        )

        return ResponseEntity.ok().body(uploadFileResponseDTO)
    }

    companion object {
        private val log = LoggerFactory.getLogger(FileController::class.java)
    }

}