package com.ravikantsharma.translator_kmm.translate.data.local

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.ravikantsharma.translator_kmm.database.sqldelight.TranslateDatabase

actual class DatabaseDriverFactory(
    private val context: Context
) {
    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(TranslateDatabase.Schema, context, "translate.db")
    }
}