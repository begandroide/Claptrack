package cl.bgautier.claptrack.reducers

import cl.bgautier.claptrack.states.AppState
import org.rekotlin.Action

fun appReducer(action: Action, appState: AppState?): AppState =
        AppState(
            gameTrackerState = gameTrackerReducer(action, appState?.gameTrackerState),
            searchState = searchReducer(action, appState?.searchState)
        )