package cl.bgautier.claptrack.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(foreignKeys = arrayOf(ForeignKey(
    entity = VideoGameObject::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("game_id")
)), tableName = "Company")
data class PublisherObject(
    @PrimaryKey
    @ColumnInfo(name="id")
    var companyId: Long? = null,

    @ColumnInfo(name="name")
    var name: String? = null,

    @ColumnInfo(name="website")
    var website: String? = null,

    @ColumnInfo(name="height")
    var height: Int? = null,

    @ColumnInfo(name="cloudinary_id")
    var cloudinaryId: String? = null,

    //@Ignore var logo: LogoObject? = null,

    @ColumnInfo(name = "game_id")
    var gameId: Long
)
