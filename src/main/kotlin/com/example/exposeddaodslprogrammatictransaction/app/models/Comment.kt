package com.example.exposeddaodslprogrammatictransaction.app.models

import com.example.exposeddaodslprogrammatictransaction.app.tables.Comments
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import java.util.*

class Comment(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<Comment>(Comments)

    var post by Post referencedOn Comments.post

    var body by Comments.body
}
