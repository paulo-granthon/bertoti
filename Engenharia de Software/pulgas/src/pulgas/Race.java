package pulgas;

public enum Race {
    Labrador("Labrador"),
    Pincher("Pincher"),
    PitBull("Pit Bull"),
    // Husky("Husky"),
    BorderCollie("BorderCollie"),
    // BullTerrier("Bull Terrier"),
    Caramelo("Caramelo"),
    PoodleImortal("Poodle Imortal"),
    ;

    public static final Race[] RACES = values();

    private String displayName;
    private Race (String displayName) { this.displayName = displayName; }
    
    public String getDisplayName() { return displayName; }

    public static final Race randomRace (RandGen randGen) {
        return RACES[randGen.randInt(RACES.length)];
    }

}
