package cl.bgautier.claptrack.models


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "wishList")
data class VideoGameObject(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    var id: Long? = null,

        @ColumnInfo(name = "name")
    @SerializedName("name")
    var name: String? = null,

        @ColumnInfo(name = "url")
    @SerializedName("url")
    var url: String? = null,

        @ColumnInfo(name = "summary")
    @SerializedName("summary")
    var summary: String? = null,

        @ColumnInfo(name = "storyline")
    @SerializedName("storyline")
    var storyline: String? = null,

        @Ignore
    var developers: List<CompanyObject>? = null,

        @Ignore
    var ersb: EsrbObject? = null,

        @Ignore
    var pegi: PegiObject? = null,

        @Ignore
    var screenShoots: List<ScreenshotsObject>? = null,

        @Ignore
    var cover: CoverObject? = null,

        @Ignore
    var videos: List<VideoObject>? = null
)