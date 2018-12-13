package cl.bgautier.claptrack.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Genre_Preference",foreignKeys = arrayOf(ForeignKey(
        entity = UserPreferencesObject::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("preference_id")
)))
data class GenrePreferenceObject(
        @PrimaryKey
        var id: Int,
        var name: String? = null,
        @ColumnInfo(name = "preference_id")
        var preferencesId: Int
)