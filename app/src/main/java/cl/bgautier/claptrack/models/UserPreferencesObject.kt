package cl.bgautier.claptrack.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="userPreferences")
data class UserPreferencesObject(
    @PrimaryKey
    var id: Int,

    var platform: String? = null,
    var genre: String? = null
)