package cl.bgautier.claptrack.models

import androidx.room.*

@Entity(tableName = "Theme_Preference",
        indices = arrayOf(Index("preference_id")),
        foreignKeys = arrayOf(ForeignKey(
        entity = UserPreferencesObject::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("preference_id")
)))
data class ThemePreferenceObject(
        @PrimaryKey
        var id: Int,
        var name: String? = null,
        @ColumnInfo(name = "preference_id")
        var preferenceId: Int
)