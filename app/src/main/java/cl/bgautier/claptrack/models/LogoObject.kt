package cl.bgautier.claptrack.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import cl.bgautier.claptrack.models.CompanyObject

@Entity(foreignKeys = arrayOf(ForeignKey(
    entity = CompanyObject::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("company_id")
)))
data class LogoObject(
        @PrimaryKey var imageId: Int,
        var url: String? = null,
        var width: Int? = null,
        var height: Int? = null,
        var cloudinary_id: String? = null,
        @ColumnInfo(name = "company_id") var companyId: Int
)