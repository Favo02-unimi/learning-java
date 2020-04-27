public class Player {

    public static final int CHAMPION = 5000;
    public static final int DIAMOND = 4400;
    public static final int PLATINUM_I = 4000;
    public static final int PLATINUM_II = 3600;
    public static final int PLATINUM_III = 3200;
    public static final int GOLD_I = 3000;
    public static final int GOLD_II = 2800;
    public static final int GOLD_III = 2600;
    public static final int SILVER_I = 2500;
    public static final int SILVER_II = 2400;
    public static final int SILVER_III = 2300;
    public static final int SILVER_IV = 2200;
    public static final int SILVER_V = 2100;
    public static final int BRONZE_I = 2000;
    public static final int BRONZE_II = 1900;
    public static final int BRONZE_III = 1800;
    public static final int BRONZE_IV = 1700;
    public static final int BRONZE_V = 1600;
    public static final int COPPER_I = 1500;
    public static final int COPPER_II = 1400;
    public static final int COPPER_III = 1300;
    public static final int COPPER_IV = 1200;
    public static final int COPPER_V = 1100;
    public static final int UNRANKED = 0;

    private String name;
    private int level;
    private int eu_mmr;
    private int na_mmr;
    private int as_mmr;
    private String eu_rank;
    private String na_rank;
    private String as_rank;
    private double kd;

    public Player(String name, int level, int eu_mmr, int na_mmr, int as_mmr, double kd) {
        this.name = name;
        this.level = level;
        this.eu_mmr = eu_mmr;
        this.na_mmr = na_mmr;
        this.as_mmr = as_mmr;
        this.kd = kd;
        rank();
    }

    private void rank() {
        if (eu_mmr >= CHAMPION) {
            eu_rank = "Champion";
        }
        if (eu_mmr >= DIAMOND) {
            eu_rank = "Diamond";
        }
        else if (eu_mmr >= PLATINUM_I) {
            eu_rank = "Platinum I";
        }
        else if (eu_mmr >= PLATINUM_II) {
            eu_rank = "Platinum II";
        }
        else if (eu_mmr >= PLATINUM_III) {
            eu_rank = "Platinum III";
        }
        else if (eu_mmr >= GOLD_I) {
            eu_rank = "Gold I";
        }
        else if (eu_mmr >= GOLD_II) {
            eu_rank = "Gold II";
        }
        else if (eu_mmr >= GOLD_III) {
            eu_rank = "Gold III";
        }
        else if (eu_mmr >= SILVER_I) {
            eu_rank = "Silver I";
        }
        else if (eu_mmr >= SILVER_II) {
            eu_rank = "Silver II";
        }
        else if (eu_mmr >= SILVER_III) {
            eu_rank = "Silver III";
        }
        else if (eu_mmr >= SILVER_IV) {
            eu_rank = "Silver IV";
        }
        else if (eu_mmr >= SILVER_V) {
            eu_rank = "Silver V";
        }
        else if (eu_mmr >= BRONZE_I) {
            eu_rank = "Bronze I";
        }
        else if (eu_mmr >= BRONZE_II) {
            eu_rank = "Bronze II";
        }
        else if (eu_mmr >= BRONZE_III) {
            eu_rank = "Bronze III";
        }
        else if (eu_mmr >= BRONZE_IV) {
            eu_rank = "Bronze IV";
        }
        else if (eu_mmr >= BRONZE_V) {
            eu_rank = "Bronze V";
        }
        else if (eu_mmr >= COPPER_I) {
            eu_rank = "Copper I";
        }
        else if (eu_mmr >= COPPER_II) {
            eu_rank = "Copper II";
        }
        else if (eu_mmr >= COPPER_III) {
            eu_rank = "Copper III";
        }
        else if (eu_mmr >= COPPER_IV) {
            eu_rank = "Copper IV";
        }
        else if (eu_mmr == UNRANKED) {
            eu_rank = "Unranked";
        }
        else {
            eu_rank = "Copper V";
        }

        //---------------------------------------------------

        if (na_mmr >= CHAMPION) {
            na_rank = "Champion";
        }
        if (na_mmr >= DIAMOND) {
            na_rank = "Diamond";
        }
        else if (na_mmr >= PLATINUM_I) {
            na_rank = "Platinum I";
        }
        else if (na_mmr >= PLATINUM_II) {
            na_rank = "Platinum II";
        }
        else if (na_mmr >= PLATINUM_III) {
            na_rank = "Platinum III";
        }
        else if (na_mmr >= GOLD_I) {
            na_rank = "Gold I";
        }
        else if (na_mmr >= GOLD_II) {
            na_rank = "Gold II";
        }
        else if (na_mmr >= GOLD_III) {
            na_rank = "Gold III";
        }
        else if (na_mmr >= SILVER_I) {
            na_rank = "Silver I";
        }
        else if (na_mmr >= SILVER_II) {
            na_rank = "Silver II";
        }
        else if (na_mmr >= SILVER_III) {
            na_rank = "Silver III";
        }
        else if (na_mmr >= SILVER_IV) {
            na_rank = "Silver IV";
        }
        else if (na_mmr >= SILVER_V) {
            na_rank = "Silver V";
        }
        else if (na_mmr >= BRONZE_I) {
            na_rank = "Bronze I";
        }
        else if (na_mmr >= BRONZE_II) {
            na_rank = "Bronze II";
        }
        else if (na_mmr >= BRONZE_III) {
            na_rank = "Bronze III";
        }
        else if (na_mmr >= BRONZE_IV) {
            na_rank = "Bronze IV";
        }
        else if (na_mmr >= BRONZE_V) {
            na_rank = "Bronze V";
        }
        else if (na_mmr >= COPPER_I) {
            na_rank = "Copper I";
        }
        else if (na_mmr >= COPPER_II) {
            na_rank = "Copper II";
        }
        else if (na_mmr >= COPPER_III) {
            na_rank = "Copper III";
        }
        else if (na_mmr >= COPPER_IV) {
            na_rank = "Copper IV";
        }
        else if (na_mmr == UNRANKED) {
            na_rank = "Unranked";
        }
        else {
            na_rank = "Copper V";
        }

        //---------------------------------------------------

        if (as_mmr >= CHAMPION) {
            as_rank = "Champion";
        }
        if (as_mmr >= DIAMOND) {
            as_rank = "Diamond";
        }
        else if (as_mmr >= PLATINUM_I) {
            as_rank = "Platinum I";
        }
        else if (as_mmr >= PLATINUM_II) {
            as_rank = "Platinum II";
        }
        else if (as_mmr >= PLATINUM_III) {
            as_rank = "Platinum III";
        }
        else if (as_mmr >= GOLD_I) {
            as_rank = "Gold I";
        }
        else if (as_mmr >= GOLD_II) {
            as_rank = "Gold II";
        }
        else if (as_mmr >= GOLD_III) {
            as_rank = "Gold III";
        }
        else if (as_mmr >= SILVER_I) {
            as_rank = "Silver I";
        }
        else if (as_mmr >= SILVER_II) {
            as_rank = "Silver II";
        }
        else if (as_mmr >= SILVER_III) {
            as_rank = "Silver III";
        }
        else if (as_mmr >= SILVER_IV) {
            as_rank = "Silver IV";
        }
        else if (as_mmr >= SILVER_V) {
            as_rank = "Silver V";
        }
        else if (as_mmr >= BRONZE_I) {
            as_rank = "Bronze I";
        }
        else if (as_mmr >= BRONZE_II) {
            as_rank = "Bronze II";
        }
        else if (as_mmr >= BRONZE_III) {
            as_rank = "Bronze III";
        }
        else if (as_mmr >= BRONZE_IV) {
            as_rank = "Bronze IV";
        }
        else if (as_mmr >= BRONZE_V) {
            as_rank = "Bronze V";
        }
        else if (as_mmr >= COPPER_I) {
            as_rank = "Copper I";
        }
        else if (as_mmr >= COPPER_II) {
            as_rank = "Copper II";
        }
        else if (as_mmr >= COPPER_III) {
            as_rank = "Copper III";
        }
        else if (as_mmr >= COPPER_IV) {
            as_rank = "Copper IV";
        }
        else if (as_mmr == UNRANKED) {
            as_rank = "Unranked";
        }
        else {
            as_rank = "Copper V";
        }
    }

    public String toString() {
        if (level == 0) {
            return "Player inesistente.";
        }
        return "Level: " + level +
                "\nEU Rank: " + eu_rank +
                "\nEU MMR: " + eu_mmr +
                "\nNA Rank: " + na_rank +
                "\nNA MMR: " + na_mmr +
                "\nAS Rank: " + as_rank +
                "\nAS MMR: " + as_mmr +
                "\nK/D: " + kd;
    }

    public String toStringHTML() {
        if (level == 0) {
            return "Player inesistente.";
        }
        return "<html>Level: " + level + "<br/>" +
                "\nEU Rank: " + eu_rank + "<br/>" +
                "\nEU MMR: " + eu_mmr + "<br/>" +
                "\nNA Rank: " + na_rank + "<br/>" +
                "\nNA MMR: " + na_mmr + "<br/>" +
                "\nAS Rank: " + as_rank + "<br/>" +
                "\nAS MMR: " + as_mmr + "<br/>" +
                "\nK/D: " + kd + "</html>";
    }
    
    public String getRank() {
        if ((eu_mmr > na_mmr) && (eu_mmr > as_mmr)) {
            return eu_rank;
        }
        else if ((na_mmr > eu_mmr) && (na_mmr > as_mmr)) {
            return na_rank;
        }
        else if ((as_mmr > eu_mmr) && (as_mmr > na_mmr)) {
            return as_rank;
        }
        return "No rank";
    }

}
