package cl.bgautier.claptrack.storage

import android.content.Context
import android.telecom.Call
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
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
    CompanyObject::class,
    GenrePreferenceObject::class,
    PlatformPreferenceObject::class,
    ThemePreferenceObject::class
],version = 1)
abstract class ClaptrackDatabase : RoomDatabase() {
    abstract fun wishListDao(): WishListDao
    abstract fun preferencesDao(): PreferencesDao

    companion object {
        private var claptrackDB: ClaptrackDatabase? = null

        private val PREFERENCE = UserPreferencesObject(1,"default")

        fun getInstance(context: Context): ClaptrackDatabase?{
            if(claptrackDB == null){
                synchronized(ClaptrackDatabase::class){
                    claptrackDB = Room.databaseBuilder(context, ClaptrackDatabase::class.java, "ClapTrack DB")
                            .addCallback(object: Callback(){
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    super.onCreate(db)
                                    getInstance(context)?.preferencesDao()?.insertUserPreference(PREFERENCE)
                                }
                            })
                            .build()
                }
            }
            return claptrackDB
        }
    }
}