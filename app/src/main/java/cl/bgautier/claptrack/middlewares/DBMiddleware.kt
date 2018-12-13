package cl.bgautier.claptrack.middlewares

import android.annotation.SuppressLint
import android.util.Log
import cl.bgautier.claptrack.ClapTrackApplication
import cl.bgautier.claptrack.actions.*
import cl.bgautier.claptrack.models.GenrePreferenceObject
import cl.bgautier.claptrack.models.PlatformPreferenceObject
import cl.bgautier.claptrack.models.ThemePreferenceObject
import cl.bgautier.claptrack.states.AppState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.rekotlin.DispatchFunction
import org.rekotlin.Middleware


val claptrackDB = ClapTrackApplication.claptrackDatabase

internal val dbMiddleware:Middleware<AppState> = {dispatch, getState ->
    { next ->
        { action ->
            when(action){
                is LoadPreferences -> {
                    loadPreferences(dispatch)
                }
                is SaveTheme -> {
                    saveTheme(dispatch, action.themePreferenceObject)
                }
                is SaveGenre -> {
                    saveGenre(dispatch, action.genrePreferenceObject)
                }
                is SavePlatform -> {
                    savePlatform(dispatch, action.platformPreferenceObject)
                }
                is DeleteTheme -> {
                    deleteTheme(dispatch, action.themePreferenceObject)
                }
                is DeleteGenre -> {
                    deleteGenre(dispatch, action.genrePreferenceObject)
                }
                is DeletePlatform -> {
                    deletePlatform(dispatch, action.platformPreferenceObject)
                }
            }
            next(action)
        }
    }
}

@SuppressLint("CheckResult")
private fun loadPreferences(dispatch: DispatchFunction){
    claptrackDB?.preferencesDao()?.getAll()?.subscribeOn(Schedulers.io())!!
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {preferences ->
                    preferences.forEach { preference -> Log.i("PREFERENCE", preference.prefence!!.name) }
                    dispatch(SetPreferences(preferences[0]))
                },
                { err ->
                    Log.e("Error loadPreferences", err.toString())
                }
            )
}

private fun saveTheme(dispatch: DispatchFunction, themePreferenceObject: ThemePreferenceObject){
    claptrackDB?.preferencesDao()?.insertTheme(themePreferenceObject)
    dispatch(SetTheme(themePreferenceObject))
}

private fun saveGenre(dispatch: DispatchFunction, genrePreferenceObject: GenrePreferenceObject){
    claptrackDB?.preferencesDao()?.insertGenre(genrePreferenceObject)
    dispatch(SetGenre(genrePreferenceObject))
}

private fun savePlatform(dispatch: DispatchFunction, platformPreferenceObject: PlatformPreferenceObject){
    claptrackDB?.preferencesDao()?.insertPlatform(platformPreferenceObject)
    dispatch(SetPlatform(platformPreferenceObject))
}

private fun deleteTheme(dispatch: DispatchFunction, themePreferenceObject: ThemePreferenceObject){
    claptrackDB?.preferencesDao()?.deleteTheme(themePreferenceObject)
    dispatch(RemoveTheme(themePreferenceObject))
}

private fun deleteGenre(dispatch: DispatchFunction, genrePreferenceObject: GenrePreferenceObject){
    claptrackDB?.preferencesDao()?.deleteGenre(genrePreferenceObject)
    dispatch(RemoveGenre(genrePreferenceObject))
}

private fun deletePlatform(dispatch: DispatchFunction, platformPreferenceObject: PlatformPreferenceObject){
    claptrackDB?.preferencesDao()?.deletePlatform(platformPreferenceObject)
    dispatch(RemovePlatform(platformPreferenceObject))
}





