package com.android.newsapp.data.db

import androidx.room.TypeConverter
import com.android.newsapp.data.model.Source

/**
 * Room TypeConverters for converting Source objects to and from a format
 * that can be stored in the database.
 */
class Converters {
    /**
     * Converts a Source object to a String.
     *
     * @param source The Source object to be converted.
     * @return The name of the source as a String.
     */
    @TypeConverter
    fun fromSource(source: Source): String? {
        return source.name
    }

    /**
     * Converts a String to a Source object.
     *
     * @param name The name of the source as a String.
     * @return The Source object created from the name.
     */
    @TypeConverter
    fun toSource(name: String): Source {
        // For simplicity, both id and name are set to the provided name.
        return Source(name, name)
    }
}
