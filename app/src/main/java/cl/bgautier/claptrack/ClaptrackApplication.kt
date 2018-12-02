package cl.bgautier.claptrack

import android.app.Application
import androidx.room.Room
import cl.bgautier.claptrack.reducers.appReducer
import cl.bgautier.claptrack.middlewares.apiMiddleWare
import cl.bgautier.claptrack.storage.ClaptrackDatabase
import org.rekotlin.Store
import timber.log.Timber

val Store = Store(
    reducer = ::appReducer,
    state = null,
    middleware = listOf(apiMiddleWare)
)


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
        claptrackDatabase = Room
                            .databaseBuilder(this, ClaptrackDatabase::class.java, "ClapTrackDB")
                            .build()
    }

    companion object {
        @get:Synchronized lateinit var instance: ClapTrackApplication
            private set
        var claptrackDatabase: ClaptrackDatabase? = null
        val store = Store
    }
}