import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Paziente implements Serializable {

    public static final int COD_ROSSO = 5;
    public static final int COD_GIALLO = 4;
    public static final int COD_AZZURRO = 3;
    public static final int COD_VERDE = 2;
    public static final int COD_BIANCO = 1;


    private String nome;
    private LocalDate dataDiNascita;
    private boolean isMaschio;
    private boolean isGravidanza;
    private boolean isHandicap;

    private boolean isPazienteDebole;
    private int codice;

    public Paziente(String nome, String dataDiNascita, boolean isMaschio, boolean isGravidanza, boolean isHandicap) {
        this.nome = nome;
        try {
            this.dataDiNascita = LocalDate.parse(dataDiNascita);
        } catch (DateTimeParseException e) {
            System.err.println("Errore: data di nascita non inserita correttamente");
        }
        this.isMaschio = isMaschio;
        this.isGravidanza = isGravidanza;
        this.isHandicap = isHandicap;

        if (isGravidanza || isHandicap || this.dataDiNascita.plusYears(80).isBefore(LocalDate.now()) || this.dataDiNascita.plusYears(14).isAfter(LocalDate.now())) {
            isPazienteDebole = true;
        }
        System.out.println(toString());
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public boolean isMaschio() {
        return isMaschio;
    }

    public boolean isGravidanza() {
        return isGravidanza;
    }

    public boolean isHandicap() {
        return isHandicap;
    }

    public boolean isPazienteDebole() {
        return isPazienteDebole;
    }

    public int getCodice() {
        return codice;
    }

    public String getCodiceString() {
        switch (codice){
            case (COD_ROSSO):
                return "rosso";
            case (COD_GIALLO):
                return "giallo";
            case (COD_VERDE):
                return "verde";
            case (COD_BIANCO):
                return "bianco";
            case (COD_AZZURRO):
                return "azzurro";
            default:
                return "non assegnato";
        }
    }

    public String toString() {
        return nome + ":" +
                "\nData di nascita: " + dataDiNascita.toString() +
                "\nSesso: " + ((isMaschio) ? "uomo" : "donna") +
                "\nPaziente debole: " + ((isPazienteDebole) ? "si" : "no") +
                "\nCodice: " + getCodiceString();
    }

}
