package cl.bgautier.claptrack.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.bgautier.claptrack.models.*

@Database(entities = [
    VideoGameObject::class,
    UserPreferencesObject::class,
    LogoObject::class,
    CoverObject::class,
    ScreenshotsObject::class,
    VideoObject::class,
    EsrbObject::class,
    PegiObject::class,
    CompanyObject::class
],version = 1)
abstract class ClaptrackDatabase : RoomDatabase() {
    abstract fun WishListDao(): WishListDao
}