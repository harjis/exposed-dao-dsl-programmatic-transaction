package com.example.exposeddaodslprogrammatictransaction.app.services

import com.example.exposeddaodslprogrammatictransaction.app.models.Comment
import com.example.exposeddaodslprogrammatictransaction.app.models.Post
import com.example.exposeddaodslprogrammatictransaction.app.tables.Comments
import com.example.exposeddaodslprogrammatictransaction.app.tables.Posts
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service

@Service
class PostSaveService {
    fun createInvalidDataDAO() {
        transaction {
            Post.new {
                name = "Post 1 created with DAO"
            }
            Comment.new {
                body = "Post 1 is cool"
            }
        }
    }

    fun createInvalidDataDSL() {
        transaction {
            Posts.insert {
                it[name] = "Post 1 created with DSL"
            }

            Comments.insert {
                it[body] = "Post 1 is cool"
            }
        }
    }
}
