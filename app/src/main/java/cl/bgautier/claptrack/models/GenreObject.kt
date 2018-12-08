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
data class GenreObject(
        @PrimaryKey var id: Int,
        var url: String? = null,
        var name: String? = null,
        var slug: String? = null,
        @ColumnInfo(name="game_id") var gameId: Int
)