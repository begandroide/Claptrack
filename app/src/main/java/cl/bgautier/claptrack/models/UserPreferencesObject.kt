package cl.bgautier.claptrack.models

import androidx.room.*

@Entity(tableName = "user_preference")
data class UserPreferencesObject(
        @PrimaryKey
        var id: Int,

        var name: String
)

class UserPreferences(){
    @Embedded
    var prefence: UserPreferencesObject? = null

    @Relation(parentColumn = "id", entityColumn = "preference_id")
    lateinit var platforms: List<PlatformPreferenceObject>

    @Relation(parentColumn = "id", entityColumn = "preference_id")
    lateinit var genres: List<GenrePreferenceObject>

    @Relation(parentColumn = "id", entityColumn = "preference_id")
    lateinit var themes: List<ThemePreferenceObject>
}
