package com.example.exposeddaodslprogrammatictransaction.app.tables

import org.jetbrains.exposed.dao.UUIDTable

object Posts : UUIDTable() {
    val name = varchar("name", 255)
}
