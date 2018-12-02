package com.example.eduardopozo.claptrack.actions


import cl.bgautier.claptrack.models.VideoGameObject
import org.rekotlin.Action

class SearchGame(val query: String): Action
class SetSearchResult(val games: List<VideoGameObject>): Action
class SetSearchNextPage(val next: String): Action