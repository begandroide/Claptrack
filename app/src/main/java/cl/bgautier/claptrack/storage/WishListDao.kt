package cl.bgautier.claptrack.storage

import androidx.room.*
import cl.bgautier.claptrack.models.VideoGameObject
import io.reactivex.Flowable

@Dao
interface WishListDao {
    @Query("SELECT * from wishList")
    fun getAll(): Flowable<List<VideoGameObject>>

    @Insert
    fun insert(videoGameObject: VideoGameObject): Long

    @Update
    fun update(games: List<VideoGameObject>): Int

    @Delete
    fun delete(videoGameObject: VideoGameObject): Int

    @Delete
    fun deleteAll(games: List<VideoGameObject>): Int
}