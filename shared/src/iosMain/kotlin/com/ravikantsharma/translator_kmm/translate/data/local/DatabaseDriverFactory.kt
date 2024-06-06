package com.ravikantsharma.translator_kmm.translate.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.ravikantsharma.translator_kmm.database.sqldelight.TranslateDatabase


actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(TranslateDatabase.Schema, "translate.db")
    }
}