package cl.bgautier.claptrack.middlewares

import android.annotation.SuppressLint
import android.util.Log
import cl.bgautier.claptrack.actions.LoadGameList
import cl.bgautier.claptrack.actions.NextGame
import cl.bgautier.claptrack.actions.SetGameList
import cl.bgautier.claptrack.actions.SetNextPage
import cl.bgautier.claptrack.apiServices.ApiClient
import cl.bgautier.claptrack.apiServices.IGDBApiService
import cl.bgautier.claptrack.models.VideoGameObject
import cl.bgautier.claptrack.states.AppState
import cl.bgautier.claptrack.states.GameTrackerState
import com.example.eduardopozo.claptrack.actions.SearchGame
import com.example.eduardopozo.claptrack.actions.SetSearchNextPage
import com.example.eduardopozo.claptrack.actions.SetSearchResult
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.rekotlin.DispatchFunction
import org.rekotlin.Middleware
import retrofit2.Response

val apiService = ApiClient.client?.create(IGDBApiService::class.java)

internal val apiMiddleWare: Middleware<AppState> = { dispatch, getState ->
    { next ->
        { action ->
            val state: GameTrackerState? = getState()?.gameTrackerState
            when(action){
                is LoadGameList -> {
                    Log.i("API LOAD", "Fetching games from the Api")
                    getGames(dispatch)
                }
                is NextGame -> {
                    Log.i("currGameIndex", state!!.currentGameIndex.toString())
                    if(state!!.currentGameIndex >= 49){
                        Log.i("API LOAD NEXT PAGE", "Fetching new pages of videogames at "+state.nextPage!!)
                        getNextPageOfGames(dispatch, state.nextPage!!)
                    }
                }
                is SearchGame -> {
                    getSearchResult(dispatch, action.query)
                }
            }
            next(action)
        }
    }

}

@SuppressLint("CheckResult")
private fun getGames(dispatch: DispatchFunction){
    val call: Observable<Response<List<VideoGameObject>>> = apiService!!.games(platforms="49")
    call.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            {res ->
                val games: List<VideoGameObject> = res.body()!!
                val nextPage: String = res.headers().get("X-Next-Page")!!
                games.forEach{game -> Log.d("GAME", game.name)}
                dispatch(SetGameList(games))
                dispatch(SetNextPage(nextPage))
            },
            {error -> Log.e("Error", error.toString())}
        )
}

@SuppressLint("CheckResult")
private fun getNextPageOfGames(dispatch: DispatchFunction, nextPageUrl: String){
    val call: Observable<Response<List<VideoGameObject>>> = apiService!!.nextPage(nextPageUrl)
    call.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            {res ->
                val games: List<VideoGameObject> = res.body()!!
                val nextPage: String = res.headers().get("X-Next-Page")!!.substring(1)
                games.forEach{game -> Log.d("GAME", game.name)}
                dispatch(SetGameList(games))
                dispatch(SetNextPage(nextPage))
            },
            {error -> Log.e("ERROR", error.toString())}
        )
}

@SuppressLint("CheckResult")
private fun getSearchResult(dispatch: DispatchFunction, query: String){
    val call: Observable<Response<List<VideoGameObject>>>? = apiService?.search(query= query, platforms = "49")
    call?.subscribeOn(Schedulers.io())!!
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ res ->
                val games: List<VideoGameObject> = res.body()!!
                val nextPage: String = res.headers().get("X-Next-Page")!!
                games.forEach { game -> Log.d("GAME_SEARCH", game.name) }
                dispatch(SetSearchResult(games))
                dispatch(SetSearchNextPage(nextPage))
            },
            {err -> Log.e("ERROR", err.toString())}
        )
}