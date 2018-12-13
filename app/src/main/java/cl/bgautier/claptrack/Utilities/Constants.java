package cl.bgautier.claptrack.Utilities;

import android.util.SparseArray;

public class Constants {
    private static final SparseArray<String> GAMECATEGORY;
    static {
        GAMECATEGORY = new SparseArray<>();
        GAMECATEGORY.put(0, "Main game");
        GAMECATEGORY.put(1, "DLC / Addon");
        GAMECATEGORY.put(2, "Expansion");
        GAMECATEGORY.put(3, "Bundle");
        GAMECATEGORY.put(4, "Standalone expansion");
    }
    private static final SparseArray<String> PLATFORMS;
    static {
        PLATFORMS = new SparseArray<>();
        PLATFORMS.put(18, "NES");
        PLATFORMS.put(30, "Sega 32X");
        PLATFORMS.put(78, "Sega CD");
        PLATFORMS.put(59, "Atari 2600");
        PLATFORMS.put(99, "FAMICOM");
        PLATFORMS.put(64, "Sega Master System");
        PLATFORMS.put(60, "Atari 7800");
        PLATFORMS.put(61, "Atari Lynx");
        PLATFORMS.put(33, "Game Boy");
        PLATFORMS.put(58, "Super FAMICOM");
        PLATFORMS.put(29, "Sega Genesis");
        PLATFORMS.put(35, "Sega Game Gear");
        PLATFORMS.put(19, "SNES");
        PLATFORMS.put(87, "Virtual Boy");
        PLATFORMS.put(62, "Atari Jaguar");
        PLATFORMS.put(22, "Game Boy Color");
        PLATFORMS.put(4, "Nintendo 64");
        PLATFORMS.put(7, "PlayStation");
        PLATFORMS.put(32, "Sega Saturn");
        PLATFORMS.put(11, "Xbox");
        PLATFORMS.put(24, "Game Boy Advance");
        PLATFORMS.put(23, "Dreamcast");
        PLATFORMS.put(8, "PlayStation 2");
        PLATFORMS.put(21, "Nintendo GameCube");
        PLATFORMS.put(9, "PlayStation 3");
        PLATFORMS.put(12, "Xbox 360");
        PLATFORMS.put(5, "Wii");
        PLATFORMS.put(41, "Wii U");
        PLATFORMS.put(20, "Nintendo DS");
        PLATFORMS.put(159, "Nintendo DSi");
        PLATFORMS.put(38, "PSP");
        PLATFORMS.put(130, "Nintendo Switch");
        PLATFORMS.put(72, "Ouya");
        PLATFORMS.put(49, "Xbox One");
        PLATFORMS.put(41, "Wii U");
        PLATFORMS.put(46, "PS Vita");
        PLATFORMS.put(37, "Nintendo 3DS");
        PLATFORMS.put(137, "New Nintendo 3DS");
        PLATFORMS.put(34, "Android");
        PLATFORMS.put(39, "IOS");
        PLATFORMS.put(3, "Linux");
        PLATFORMS.put(14, "Mac");
        PLATFORMS.put(6, "PC");
        PLATFORMS.put(48, "PlayStation 4");
    }
    private static final SparseArray<String> THEMES;
    static {
        THEMES = new SparseArray<>();
        THEMES.put(31, "Drama");
        THEMES.put(23, "Stealth");
        THEMES.put(41, "4X (explore, expand, exploit, and exterminate)");
        THEMES.put(35, "Kids");
        THEMES.put(22, "Historical");
        THEMES.put(28, "Business");
        THEMES.put(33, "Sandbox");
        THEMES.put(42, "Erotic");
        THEMES.put(39, "Warfare");
        THEMES.put(40, "Party");
        THEMES.put(38, "Open World");
        THEMES.put(27, "Comedy");
        THEMES.put(19, "Horror");
        THEMES.put(17, "Fantasy");
        THEMES.put(21, "Survival");
        THEMES.put(43, "Mystery");
        THEMES.put(34, "Educational");
        THEMES.put(20, "Thriller");
        THEMES.put(32, "Non-fiction");
        THEMES.put(18, "Science Fiction");
        THEMES.put(1, "Action");
    }
    private static final SparseArray<String> GENRES;
    static {
        GENRES = new SparseArray<>();
        GENRES.put(16, "Turn-based strategy (TBS)");
        GENRES.put(2, "Point-and-click");
        GENRES.put(13, "Simulator");
        GENRES.put(24, "Tactical");
        GENRES.put(26, "Quiz/Trivia");
        GENRES.put(33, "Arcade");
        GENRES.put(9, "Puzzle");
        GENRES.put(30, "Pinball");
        GENRES.put(11, "Real Time Strategy (RTS)");
        GENRES.put(25, "Hack and Slash/Beat 'em up");
        GENRES.put(4,"Fighting");
        GENRES.put(8, "Platform");
        GENRES.put(10, "Racing");
        GENRES.put(15, "Strategy");
        GENRES.put(14, "Sport");
        GENRES.put(32, "Indie");
        GENRES.put(12, "Role Playing (RPG)");
        GENRES.put(31, "Adventure");
        GENRES.put(5,"Shooter");
        GENRES.put(7, "Music");
    }
}
