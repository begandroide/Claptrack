package cl.bgautier.claptrack.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = arrayOf(ForeignKey(
    entity = VideoGameObject::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("game_id")
)))
data class PegiObject(
        @PrimaryKey var ersbId: Int,
        var rating: Int? = null,
        var synopsis: String? = null,
        @ColumnInfo(name = "game_id") var gameId: Int
)