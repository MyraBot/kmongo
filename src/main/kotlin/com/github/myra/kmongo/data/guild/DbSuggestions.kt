package com.github.myra.kmongo.data.guild

import com.github.myra.kmongo.cache.dbSuggestions
import kotlinx.serialization.Serializable
import org.litote.kmongo.setValue

@Serializable
data class DbSuggestions(
    val guildId: String,
    val toggled: Boolean,
    var channel: String?
) {
    suspend fun setChannel(id: String?) = dbSuggestions.update(this.guildId, { it.channel = id }, setValue(DbSuggestions::channel, id))
}
