package com.example.exposeddaodslprogrammatictransaction.app.controllers

import com.example.exposeddaodslprogrammatictransaction.app.models.Post
import com.example.exposeddaodslprogrammatictransaction.app.services.PostSaveService
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class PostController(val postSaveService: PostSaveService) {
    @GetMapping
    fun index(): List<PostView> {
        return transaction {
            Post.all().map { PostView(it.name) }
        }
    }

    @GetMapping("/dao")
    fun createWithDAO() = postSaveService.createInvalidDataDAO()

    @GetMapping("/dsl")
    fun createWithDSL() = postSaveService.createInvalidDataDSL()
}

data class PostView(val name: String)
