package cl.bgautier.claptrack.actions

import cl.bgautier.claptrack.models.VideoGameObject
import org.rekotlin.Action
//Load first page of games from the API
class LoadGameList: Action
//Set a list of games in gameTrackerList from GameTrackerState
class SetGameList(val games: List<VideoGameObject>): Action
//Set the next page of games in nextPage from GameTrackerState
class SetNextPage(val nextPage: String): Action
//Set the next index to find the current game in the gameTrakerList, also Loads the next page of games
class NextGame: Action

//class PopAndPush(val game: VideoGameObject): Action
//Add new game into the WishList
class AddGameToWishList(val game: VideoGameObject): Action