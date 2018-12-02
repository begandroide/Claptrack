package cl.bgautier.claptrack.states

import cl.bgautier.claptrack.models.UserPreferencesObject
import org.rekotlin.StateType

data class PreferencesState(
    val preferences: List<UserPreferencesObject>? = null
): StateType