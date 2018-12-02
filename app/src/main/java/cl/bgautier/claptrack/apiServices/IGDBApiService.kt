package cl.bgautier.claptrack.apiServices

import cl.bgautier.claptrack.models.VideoGameObject
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

const val userKey: String = "user-key:177f1b4cd5a1ddf48cc04308a0b20dd3"
const val accept: String = "Accept:application/json"

/*
* 18 - NES
* 30 - Sega 32X
* 78 - Sega CD
* 59 - Atari 2600
* 99 - FAMICOM
* 64 - Sega Master System
* 60 - Atari 7800
* 61 - Atari Lynx
* 33 - Game Boy
* 58 - Super Famicom
* 29 - Sega Genesis
* 35 - Sega Game Gear
* 19 - SNES
* 87 - Virtual Boy
* 62 - Atari Jaguar
* 22 - Game Boy Color
* 4 - Nintendo 64
* 7 - PlayStation
* 32 - Sega Saturn
* 11 - Xbox
* 24 - Game Boy Advance
* 23 - Dreamcast
* 8 - PlayStation 2
* 21 - Nintendo GameCube
* 9 - PlayStation 3
* 12 - Xbox 360
* 5 - Wii
* 20 - Nintendo DS
* 38 - PSP
* 130 - Nintendo Switch
* 72 - Ouya
* 49 - Xbox One
* 41 - Wii U
* 46 - PS Vita
*
* */

interface IGDBApiService {

    @Headers(userKey, accept)
    @GET("games/{ids}")
    fun getGamesByIds(@Path("ids") ids: String): Observable<List<VideoGameObject>>

    @Headers(userKey, accept)
    @GET("games/?scroll=1&fields=*")
    fun search(@Query("search") query: String,
               @Query("order") order: String = "rating",
               @Query("limit") limit: Int = 50,
               @Query("filter[platforms][any]") platforms: String?
    ): Observable<Response<List<VideoGameObject>>>

    @Headers(userKey, accept)
    @GET("games/?scroll=1&fields=*&expand=developers")
    fun games(@Query("order") order: String = "rating",
              @Query("limit") limit: Int = 50,
              @Query("filter[platforms][any]") platforms: String?
    ): Observable<Response<List<VideoGameObject>>>

    @Headers(userKey, accept)
    @GET("games{next}")
    fun nextPage(@Path("next") next: String): Observable<Response<List<VideoGameObject>>>
}