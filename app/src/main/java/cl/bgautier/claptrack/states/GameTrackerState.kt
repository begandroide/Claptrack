package cl.bgautier.claptrack.states

import cl.bgautier.claptrack.models.VideoGameObject
import org.rekotlin.StateType

data class GameTrackerState(
        val gameTrackerList: List<VideoGameObject>? = null,
        val nextPage: String? = null,
        val currentGameIndex: Int = 0
): StateType