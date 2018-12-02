package cl.bgautier.claptrack.states

import cl.bgautier.claptrack.models.VideoGameObject
import org.rekotlin.StateType

data class WishListState(
    val wishList: MutableList<VideoGameObject> = arrayListOf()
): StateType