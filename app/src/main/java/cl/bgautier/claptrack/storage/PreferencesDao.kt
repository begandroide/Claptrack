package cl.bgautier.claptrack.storage

import android.content.res.Resources
import androidx.room.*
import cl.bgautier.claptrack.models.*
import io.reactivex.Flowable

@Dao
interface PreferencesDao {
    @Query("SELECT * FROM user_preference")
    fun getAll(): Flowable<List<UserPreferences>>

    @Insert
    fun insertTheme(themePreferece: ThemePreferenceObject): Long

    @Insert
    fun insertGenre(genrePreference: GenrePreferenceObject): Long

    @Insert
    fun insertPlatform(platformPreference: PlatformPreferenceObject): Long

    @Insert
    fun insertUserPreference(userPreference: UserPreferencesObject): Long

    @Transaction
    fun insert(themePreferece: ThemePreferenceObject?, genrePreference: GenrePreferenceObject?, platformPreference: PlatformPreferenceObject?){
        if(themePreferece != null){
            insertTheme(themePreferece)
        }
        if(genrePreference != null){
            insertGenre(genrePreference)
        }
        if(platformPreference != null){
            insertPlatform(platformPreference)
        }
    }
    @Update
    fun updateTheme(themePreferece: ThemePreferenceObject): Int

    @Update
    fun updateGenre(genrePreference: GenrePreferenceObject): Int

    @Update
    fun updatePlatform(platformPreference: PlatformPreferenceObject): Int

    @Transaction
    fun update(themePreferece: ThemePreferenceObject?, genrePreference: GenrePreferenceObject?, platformPreference: PlatformPreferenceObject?){
        if(themePreferece != null){
            updateTheme(themePreferece)
        }
        if(genrePreference != null){
            updateGenre(genrePreference)
        }
        if(platformPreference != null){
            updatePlatform(platformPreference)
        }
    }
    @Delete
    fun delete(preferences: List<UserPreferencesObject>): Int

    @Delete
    fun deletePlatform(platformPreference: PlatformPreferenceObject): Int

    @Delete
    fun deleteTheme(themePreferece: ThemePreferenceObject): Int

    @Delete
    fun deleteGenre(genrePreference: GenrePreferenceObject): Int
}