package pulgas.utils;

public class Reputation {
    public static String overallReputation (int factor) { return overallReputation(factor, true); }
    public static String overallReputation(int factor, boolean punctuation) {
        if (factor < 20) return "muito ruim" + (punctuation ? "!!" : "");
        if (factor < 40) return "ruim" + (punctuation ? "!" : "");
        if (factor < 60) return "regular" + (punctuation ? "." : "");
        if (factor < 80) return "bom" + (punctuation ? "." : "");
        if (factor < 90) return "muito bom" + (punctuation ? "!" : "");
        return "excelente" + (punctuation ? "!!" : "");
    }
    
    public static String factorAdjective(int factor) {
        if (factor < -20) return "extremamente pior...";
        if (factor < -10) return "pior.";
        if (factor < 0) return "um pouco pior.";
        if (factor < 10) return "um pouco melhor.";
        if (factor < 20) return "melhor.";
        if (factor < 50) return "muito melhor!";
        return "extremamente melhor!!";
    }
    }
