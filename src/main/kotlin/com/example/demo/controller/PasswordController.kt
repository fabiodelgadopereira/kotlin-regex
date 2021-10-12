package com.example.demo.controller

import com.example.demo.service.PasswordService
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping()
class PasswordController(private val repository: PasswordService){

    private val logger = KotlinLogging.logger {}

    @GetMapping("/password/{value}", "/password/")
    fun index(@PathVariable value: String?): ResponseEntity<String> {

        try {
            if (value == null) return  ResponseEntity.ok("false")

            logger.info { " PasswordController : value : "+value}
            return ResponseEntity.ok(repository.regexPasswordValidation(value).toString())

        } catch (e: Exception) {
            logger.debug { "Error: PasswordController "+e.message }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null)

        }
    }
}