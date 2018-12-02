package cl.bgautier.claptrack.states

import cl.bgautier.claptrack.models.VideoGameObject
import org.rekotlin.StateType

data class SearchState(
        val results: List<VideoGameObject>? = null,
        val nextPage: String? = null
): StateType