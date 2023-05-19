package pulgas.utils;

import java.util.Random;

public class Names {
    public static final String[] NAMES = new String[] {
        "Miguel",
        "Gael",
        "Maria Alice",
        "Arthur",
        "Helena",
        "Heitor",
        "Alice",
        "Theo",
        "Laura",
        "Davi",
        "Samuel",
        "Bernardo",
        "Gabriel",
        "Ravi",
        "João Miguel",
        "Noah",
        "Maria Cecilia",
        "Cecilia",
        "Maite",
        "Heloisa",
    };
    public static final String RandomName (Random random) {
        return NAMES[random.nextInt(NAMES.length)];
    }

}
