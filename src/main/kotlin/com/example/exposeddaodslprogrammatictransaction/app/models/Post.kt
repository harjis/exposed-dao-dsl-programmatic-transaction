package com.example.exposeddaodslprogrammatictransaction.app.models

import com.example.exposeddaodslprogrammatictransaction.app.tables.Comments
import com.example.exposeddaodslprogrammatictransaction.app.tables.Posts
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import java.util.*

class Post(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<Post>(Posts)

    val comments by Comment referrersOn Comments.post

    var name by Posts.name
}
