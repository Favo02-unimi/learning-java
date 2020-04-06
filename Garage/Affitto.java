public abstract class Affitto {

    static double tariffaOrariaNormale = 0.50;
    static double tariffaOrariaGrande = 0.80;
    static double tariffaOrariaLusso = 1.00;

    static double tariffaMensileNormale = 100.00;
    static double tariffaMensileGrande = 130.00;
    static double tariffaMensileLusso = 200.00;

    static double penale = 10.00;

    public static void changeTariffeOrarie(double normale, double grande, double lusso) {
        tariffaOrariaNormale = normale;
        tariffaOrariaGrande = grande;
        tariffaOrariaLusso = lusso;
    }

    public static void changeTariffeMensili(double normale, double grande, double lusso) {
        tariffaMensileNormale = normale;
        tariffaMensileGrande = grande;
        tariffaMensileLusso = lusso;
    }

    public static void changePenale(double penale) {
        Affitto.penale = penale;
    }

    public static String printTariffe() {
        return  "Tariffe garage:" +
                "\n-Orarie:" +
                "\n--Posto normale: " + tariffaOrariaNormale +
                "\n--Posto grande: " + tariffaOrariaGrande +
                "\n--Posto lusso: " + tariffaOrariaLusso +
                "\n--Penale: " + penale +
                "\n-Mensili:" +
                "\n--Posto normale: " + tariffaMensileNormale +
                "\n--Posto grande: " + tariffaMensileGrande +
                "\n--Posto lusso: " + tariffaMensileLusso;
    }

    public abstract double calcolaPrezzo(String tipo);

    public abstract String getPassword();

    public abstract int getAccessiRimanenti();

    public abstract void accessoGiornaliero();

}
