package de.licklib.kotlinbackend.controller

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/file")
class FileController {

    @PostMapping("/upload")
    fun uploadFile(@RequestParam("file") file: MultipartFile): ResponseEntity<String> {
        log.info("upload file: ${file.originalFilename}")
        return ResponseEntity.ok().body(file.originalFilename)
    }

    companion object {
        private val log = LoggerFactory.getLogger(FileController::class.java)
    }

}