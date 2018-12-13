package cl.bgautier.claptrack

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import cl.bgautier.claptrack.reducers.appReducer
import cl.bgautier.claptrack.middlewares.apiMiddleWare
import cl.bgautier.claptrack.models.UserPreferencesObject
import cl.bgautier.claptrack.storage.ClaptrackDatabase
import org.rekotlin.Store
import timber.log.Timber

val Store = Store(
    reducer = ::appReducer,
    state = null,
    middleware = listOf(apiMiddleWare)
)

val Preference: UserPreferencesObject =  UserPreferencesObject(1, "default")


inline fun debugMode(block: () -> Unit) {
    if (BuildConfig.DEBUG) {
        block()
    }
}

class ClapTrackApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        debugMode { Timber.plant(Timber.DebugTree())}
        claptrackDatabase = ClaptrackDatabase.getInstance(this)
    }

    companion object {
        @get:Synchronized lateinit var instance: ClapTrackApplication
            private set
        var claptrackDatabase: ClaptrackDatabase? = null
        val store = Store
    }
}