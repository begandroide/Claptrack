package cl.bgautier.claptrack.reducers

import cl.bgautier.claptrack.actions.*
import cl.bgautier.claptrack.states.PreferencesState
import org.rekotlin.Action

fun preferencesReducer(action: Action, preferencesState: PreferencesState?): PreferencesState{
    var state = preferencesState ?: PreferencesState()
    when(action){
        is SetPreferences -> {
            state = state.copy(preferences = action.userPreferences)
        }
        is SetTheme -> {
            var newPreferences = state.preferences!!
            newPreferences.themes = newPreferences.themes + action.themePreferenceObject

            state = state.copy(preferences = newPreferences)
        }
        is SetGenre -> {
            var newPreferences = state.preferences!!
            newPreferences.genres = newPreferences.genres + action.genrePreferenceObject

            state = state.copy(preferences = newPreferences)
        }
        is SetPlatform -> {
            var newPreferences = state.preferences!!
            newPreferences.platforms = newPreferences.platforms + action.platformPreferenceObject

            state = state.copy(preferences = newPreferences)
        }

    }
    return state
}