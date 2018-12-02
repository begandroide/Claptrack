package cl.bgautier.claptrack.reducers

import com.example.eduardopozo.claptrack.actions.SetSearchNextPage
import com.example.eduardopozo.claptrack.actions.SetSearchResult
import org.rekotlin.Action
import cl.bgautier.claptrack.states.SearchState

fun searchReducer(action: Action, searchState: SearchState?): SearchState {
    var state = searchState ?: SearchState()
    when(action){
        is SetSearchResult-> {
            state = state.copy(results = action.games)
        }
        is SetSearchNextPage -> {
            state = state.copy(nextPage = action.next)
        }
    }
    return state
}