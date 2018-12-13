package cl.bgautier.claptrack.states

import cl.bgautier.claptrack.models.UserPreferences
import org.rekotlin.StateType

data class PreferencesState(
    val preferences: UserPreferences? = null
): StateType