package com.ravikantsharma.translator_kmm.translate.data.history

import com.ravikantsharma.translator_kmm.translate.domain.history.HistoryItem
import database.HistoryEntity

fun HistoryEntity.toHistoryItem(): HistoryItem {
    return HistoryItem(
        id = id,
        fromLanguageCode = fromLanguage,
        fromText = fromText,
        toLanguageCode = toLanguageCode,
        toText = toText
    )
}