package com.example.exposeddaodslprogrammatictransaction

import com.example.exposeddaodslprogrammatictransaction.app.tables.Comments
import com.example.exposeddaodslprogrammatictransaction.app.tables.Posts
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ExposedDaoDslProgrammaticTransactionApplication

fun main(args: Array<String>) {
    Database.connect("jdbc:h2:mem:regular;DB_CLOSE_DELAY=-1;", "org.h2.Driver")
    transaction {
        addLogger(StdOutSqlLogger)
        SchemaUtils.create(Posts, Comments)
    }

    runApplication<ExposedDaoDslProgrammaticTransactionApplication>(*args)
}
