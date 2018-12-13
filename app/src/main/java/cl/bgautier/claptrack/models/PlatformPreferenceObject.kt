package cl.bgautier.claptrack.models

import androidx.room.*

@Entity(indices = arrayOf(Index("preference_id")),
        tableName = "Platform_Preference",foreignKeys = arrayOf(ForeignKey(
        entity = UserPreferencesObject::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("preference_id")
)))
data class PlatformPreferenceObject(
        @PrimaryKey
        var id: Int,

        var name: String? = null,

        @ColumnInfo(name="preference_id")
        var preferenceId: Int
)