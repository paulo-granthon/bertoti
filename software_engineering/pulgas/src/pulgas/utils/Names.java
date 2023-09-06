package pulgas.utils;

public class Names {
    public static final String[] DOG_NAMES = new String[] {
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
        "Coragem",
        "Pitty",
        "Bianca Langa"
    };
    public static final String[] PERSON_NAMES = new String[] {
        "Tânia",
        "Paulo",
        "Marcos",
        "Jhonatan",
        "Naira",
        "Pedro",
        "Sofia",
        "Lucas",
        "Isabella",
        "Miguel",
        "Alice",
        "André",
        "Laura",
        "Guilherme",
        "Luísa",
        "Rafael",
        "Maria",
        "Leonardo",
        "Camila",
        "Gustavo",
        "Helena",
        "Bruno",
        "Beatriz",
        "Tiago",
        "Ana",
    };
    public static final String[] PERSON_SURNAMES = new String[] {
        "Cruz",
        "Popovicz",
        "Malaquias",
        "Silva",
        "Santos",
        "Pereira",
        "Costa",
        "Oliveira",
        "Rodrigues",
        "Almeida",
        "Ferreira",
        "Carvalho",
        "Souza",
        "Santos",
        "Gonçalves",
        "Ribeiro",
        "Fernandes",
        "Martins",
        "Santos",
        "Correia",
        "Lopes",
        "Mendes",
        "Moreira",
    };
    public static final String RandomDogName (RandGen randGen) {
        return DOG_NAMES[randGen.randInt(DOG_NAMES.length)];
    }
    public static final String RandomName (RandGen randGen) {
        StringBuilder sb = new StringBuilder(PERSON_NAMES[randGen.randInt(PERSON_NAMES.length)])
        .append(" ").append(PERSON_SURNAMES[randGen.randInt(PERSON_SURNAMES.length)]);
        while (randGen.happens(0, 100, 25)) {
            sb.append(" ").append(PERSON_SURNAMES[randGen.randInt(PERSON_SURNAMES.length)]);
        }
        return sb.toString();
    }

}
