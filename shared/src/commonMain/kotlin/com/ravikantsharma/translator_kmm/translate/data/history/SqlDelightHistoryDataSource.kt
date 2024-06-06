package com.ravikantsharma.translator_kmm.translate.data.history

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.ravikantsharma.translator_kmm.core.domain.util.CommonFlow
import com.ravikantsharma.translator_kmm.core.domain.util.toCommonFlow
import com.ravikantsharma.translator_kmm.translate.domain.history.HistoryDataSource
import com.ravikantsharma.translator_kmm.translate.domain.history.HistoryItem
import com.ravikantsharma.translator_kmm.database.sqldelight.TranslateDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock

class SqlDelightHistoryDataSource(
    db: TranslateDatabase
) : HistoryDataSource {

    private val queries = db.translateQueries

    override fun getHistory(): CommonFlow<List<HistoryItem>> {
        return queries
            .getHistory()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { history ->
                history.map { it.toHistoryItem() }
            }.toCommonFlow()
    }

    override suspend fun insertHistoryItem(item: HistoryItem) {
        queries.insertHistory(
            id = item.id,
            fromLanguage = item.fromLanguageCode,
            fromText = item.fromText,
            toLanguageCode = item.toLanguageCode,
            toText = item.toText,
            timestamp = Clock.System.now().toEpochMilliseconds()
        )
    }
}