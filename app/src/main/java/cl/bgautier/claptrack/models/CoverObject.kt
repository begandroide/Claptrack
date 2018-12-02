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
data class CoverObject(
        @PrimaryKey var imageId: Int,
        var url: String? = null,
        var width: Int? = null,
        var height: Int? = null,
        var cloudinary_id: String? = null,
        @ColumnInfo(name = "game_id") var gameId: Int
)