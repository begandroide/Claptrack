package cl.bgautier.claptrack.reducers

import cl.bgautier.claptrack.actions.AddGameToWishList
import com.example.eduardopozo.claptrack.actions.deleteGame
import cl.bgautier.claptrack.states.WishListState
import org.rekotlin.Action

fun wishListReducer(action: Action, wishListState: WishListState?): WishListState {
    var state = wishListState ?: WishListState()
    when(action){
        is AddGameToWishList -> {
            state.wishList.add(action.game)
            state = state.copy()
        }

        is deleteGame -> {
            state.wishList.remove(action.game)
            state = state.copy()
        }
    }

    return state
}