package cl.bgautier.claptrack.actions

import cl.bgautier.claptrack.models.*
import org.rekotlin.Action

class LoadPreferences: Action
class SetPreferences(val userPreferences: UserPreferences): Action
class SetPlatform(val platformPreferenceObject: PlatformPreferenceObject): Action
class SetTheme(val themePreferenceObject: ThemePreferenceObject): Action
class SetGenre(val genrePreferenceObject: GenrePreferenceObject): Action
class RemovePlatform(val platformPreferenceObject: PlatformPreferenceObject): Action
class RemoveTheme(val themePreferenceObject: ThemePreferenceObject): Action
class RemoveGenre(val genrePreferenceObject: GenrePreferenceObject): Action
class SavePlatform(val platformPreferenceObject: PlatformPreferenceObject): Action
class SaveTheme(val themePreferenceObject: ThemePreferenceObject): Action
class SaveGenre(val genrePreferenceObject: GenrePreferenceObject): Action
class DeletePlatform(val platformPreferenceObject: PlatformPreferenceObject): Action
class DeleteTheme(val themePreferenceObject: ThemePreferenceObject): Action
class DeleteGenre(val genrePreferenceObject: GenrePreferenceObject): Action