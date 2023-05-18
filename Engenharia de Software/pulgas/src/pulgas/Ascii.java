package pulgas;

public class Ascii {
    public static String dog (Race race) {
        switch (race) {
            case Labrador: return "             .--~~,__\n:-....,-------`~~'._.'\n `-,,,  ,_      ;'~U'\n  _,-' ,'`-__; '--.\n (_/'~~      ''''(;";
            case Pincher: return "/)___(\\\n (o o)\n  \\o/\\__-----.\n   \\      __  \\\n    \\| /_/  \\ /\\__/\n     ||      \\\\\n     ||      //\n     /|     /|";
            case PitBull: return "       ,\n       |`-.__\n       / ' _/\n      ****` \n     /    }\n    /  \\ /\n\\ /`   \\\\\\\n `\\    /_\\\\\n  `~~~~~``~`";
            case BorderCollie: return " \\ ______/ V`-,\n  }        /~~\n /_)^ --,r'\n|b      |b";
            case Caramelo: return "                _,)\n        _..._.-;-'\n     .-'     `(\n    /      ;   \\\n   ;.' ;`  ,;  ;\n  .'' ``. (  \\ ;\n / f_ _L \\ ;  )\\\n \\/|` '|\\/;; <;/\n((; \\_/  \n     \"";
            case PoodleImortal: return "         __\n        /  \\\n       / ..|\\\n      (_\\  |_)\n      /  \\@' \n     /     \\\n_   /  `   |\n\\\\/  \\  | _\\\n \\   /_ || \\\\_\n  \\____)|_) \\_)";
            default: return ".";
        }
    }
}
