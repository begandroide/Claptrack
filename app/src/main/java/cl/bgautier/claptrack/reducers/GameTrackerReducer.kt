package cl.bgautier.claptrack.reducers

import cl.bgautier.claptrack.actions.NextGame
import cl.bgautier.claptrack.actions.SetGameList
import cl.bgautier.claptrack.actions.SetNextPage
import cl.bgautier.claptrack.states.GameTrackerState
import org.rekotlin.Action

fun gameTrackerReducer(action: Action, gameTrackerState: GameTrackerState?): GameTrackerState {
    var state = gameTrackerState ?: GameTrackerState()
    when(action){
        is SetGameList -> {
            state = state.copy(gameTrackerList= action.games)
        }
        is SetNextPage -> {
            state = state.copy(nextPage = action.nextPage)
        }
        is NextGame -> {
            if(state.currentGameIndex >= 49){
                state = state.copy(currentGameIndex = 0)
            }
            else{
                state = state.copy(currentGameIndex = state.currentGameIndex + 1)
            }
        }
    }

    return state
}