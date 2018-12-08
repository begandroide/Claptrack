package cl.bgautier.claptrack.Utilities;

import java.util.HashMap;

public class Constants {
    private static final HashMap<Integer, String> GAMECATEGORY;
    static {
        GAMECATEGORY = new HashMap<Integer, String>();
        GAMECATEGORY.put(0, "Main game");
        GAMECATEGORY.put(1, "DLC / Addon");
        GAMECATEGORY.put(2, "Expansion");
        GAMECATEGORY.put(3, "Bundle");
        GAMECATEGORY.put(4, "Standalone expansion");
    }
    private static final HashMap<Integer, String> PLATFORMS;
    static {
        PLATFORMS = new HashMap<Integer, String>();
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
        PLATFORMS.put(20, "Nintendo DS");
        PLATFORMS.put(38, "PSP");
        PLATFORMS.put(130, "Nintendo Switch");
        PLATFORMS.put(72, "Ouya");
        PLATFORMS.put(49, "Xbox One");
        PLATFORMS.put(41, "Wii U");
        PLATFORMS.put(46, "PS Vita");
    }

}
