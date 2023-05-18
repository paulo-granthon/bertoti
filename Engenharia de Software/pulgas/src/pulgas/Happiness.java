package pulgas;

public class Happiness {
    public static String overallHappiness (int factor) { return overallHappiness(factor, true, false); }
    public static String overallHappiness (int factor, boolean punctuation, boolean plural) {
        if (factor < 8) return "muito " + (plural ? "infelizes" : "infeliz") + (punctuation ? "!!" : "");
        if (factor < 20) return (plural ? "infelizes" : "infeliz") + (punctuation ? "!" : "");
        if (factor < 36) return "um pouco triste" + (plural ? "s" : "") + (punctuation ? "..." : "");
        if (factor < 48) return "meio desanimado" + (plural ? "s" : "") + (punctuation ? "..." : "");
        if (factor < 56) return "ok" + (punctuation ? "." : "");
        if (factor < 64) return "bem" + (punctuation ? "." : "");
        if (factor < 72) return "feliz" + (plural ? "es" : "");
        if (factor < 92) return "muito feliz" + (plural ? "es" : "") + (punctuation ? "!" : "");
        if (factor < 100) return "extremamente feliz" + (plural ? "es" : "") + (punctuation ? "!!" : "");
        return "em êxtase" + (punctuation ? "!!!" : "");
    }
    public static String factorAdjective (int factor) {
        if (factor < -20) return "extremamente mais infeliz...";
        if (factor < -10) return "mais infeliz.";
        if (factor < 0) return "um pouco infeliz.";
        if (factor < 8) return "um pouco mais feliz.";
        if (factor < 20) return "mais feliz.";
        if (factor < 50) return "muito mais feliz!";
        return "extremamente mais feliz!!";
    }
}
