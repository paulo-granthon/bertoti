package pulgas.utils;

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
    public static final String RandomName (RandGen randGen) {
        return NAMES[randGen.randInt(NAMES.length)];
    }

}
