package cl.bgautier.claptrack.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import cl.bgautier.claptrack.models.VideoGameObject

@Entity(foreignKeys = arrayOf(
    ForeignKey(
        entity = VideoGameObject::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("game_id")
    )
))
data class VideoObject(
        @PrimaryKey var ersbId: Int,
        var name: String? = null,
        var video_id: String? = null,
        @ColumnInfo(name = "game_id") var gameId: Int
)