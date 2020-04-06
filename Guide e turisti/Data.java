public class Data {
    private int giorno, mese, anno;
    private Orario fasciaOraria;

    public Data(int giorno, int mese, int anno){
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
    }

    public Data(int giorno, int mese, int anno, Orario fasciaOraria){
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
        this.fasciaOraria = fasciaOraria;
    }

    public String toString() {
        return giorno + "/" + mese + "/" + anno + " " + fasciaOraria.toString();
    }

    public boolean equals(Data data){
        return (data.anno == this.anno && data.mese == this.mese && data.giorno == this.giorno)
                && data.fasciaOraria.equals(this.fasciaOraria);
    }
}
