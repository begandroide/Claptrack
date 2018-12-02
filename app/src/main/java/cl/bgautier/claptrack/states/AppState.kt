package cl.bgautier.claptrack.states

import org.rekotlin.StateType

data class AppState(
        val gameTrackerState: GameTrackerState? = null,
        val wishListState: WishListState? = null,
        val preferencesState: PreferencesState? = null,
        val searchState: SearchState? = null
): StateType