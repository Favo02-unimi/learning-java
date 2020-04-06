//a.compareTo(b) SE IL NUMERO E' < 0 a VIENE PRIMA

public class Rubrica {

    private Contatto testaNome;
    private Contatto testaCognome;

    public Rubrica(){  }

    public void inserisci(Contatto newCont){
        //se vuoti entrambi
        if(testaNome == null && testaCognome == null){
            testaNome = newCont;
            testaCognome = newCont;
            return;
        }

        //--Inserimento per nome--//
        if (newCont.getNome().compareToIgnoreCase(testaNome.getNome()) < 0) {
            newCont.setNextNome(testaNome);
            testaNome = newCont;
        }
        else {
            Contatto temp = testaNome;
            while (temp.getNextNome() != null && temp.getNextNome().getNome().compareToIgnoreCase(newCont.getNome()) < 0) {
                temp = temp.getNextNome();
            }
            newCont.setNextNome(temp.getNextNome());
            temp.setNextNome(newCont);
        }

        //--Inserimento per cognome--//
        if (newCont.getCognome().compareToIgnoreCase(testaCognome.getCognome()) < 0) {
            newCont.setNextCognome(testaCognome);
            testaCognome = newCont;
        }
        else {
            Contatto temp = testaCognome;
            while (temp.getNextCognome() != null && temp.getNextCognome().getCognome().compareToIgnoreCase(newCont.getCognome()) < 0) {
                temp = temp.getNextCognome();
            }
            newCont.setNextCognome(temp.getNextCognome());
            temp.setNextCognome(newCont);
        }
    }

    public String stampaPerNome(){
        Contatto temp = testaNome;
        String out = "";
        while (temp!=null){
            out += temp.toString() + "\n";
            temp = temp.getNextNome();
        }
        return out;
    }

    public String stampaPerCognome(){
        Contatto temp = testaCognome;
        String out = "";
        while (temp!=null){
            out += temp.toString() + "\n";
            temp = temp.getNextCognome();
        }
        return out;
    }

    public int conta(){
        Contatto temp = testaCognome;
        int cont = 0;
        while (temp!=null){
            cont++;
            temp = temp.getNextCognome();
        }
        return cont;
    }

    public void elimina(String nome, String cognome){
        boolean trovato = false;
        if (testaNome.getNome().equalsIgnoreCase(nome)){
            if (testaNome.getCognome().equalsIgnoreCase(cognome)){
                testaNome = testaNome.getNextNome();
            }
        }
        else {
            Contatto temp = testaNome.getNextNome();
            while (temp.getNextNome() != null) {
                if (temp.getNextNome().getNome().equalsIgnoreCase(nome)) {
                    if (temp.getNextNome().getCognome().equalsIgnoreCase(cognome)) {
                        temp.setNextNome(temp.getNextNome().getNextNome());
                        System.out.println(nome + " " + cognome + " eliminato.");
                        trovato = true;
                        break;
                    }
                }
                temp = temp.getNextNome();
            }
        }
        if (testaCognome.getCognome().equalsIgnoreCase(cognome)){
            if (testaCognome.getNome().equalsIgnoreCase(nome)){
                testaCognome = testaCognome.getNextCognome();
            }
        }
        if (trovato){
            Contatto temp = testaCognome.getNextCognome();
            while (temp.getNextCognome()!=null) {
                if(temp.getNextCognome().getCognome().equalsIgnoreCase(cognome)){
                    if(temp.getNextCognome().getNome().equalsIgnoreCase(nome)){
                        temp.setNextCognome(temp.getNextCognome().getNextCognome());
                        System.out.println(nome + " " + cognome + " eliminato.");
                        break;
                    }
                }
                temp = temp.getNextCognome();
            }
        }
        else {
            System.out.println(nome + " " + cognome + " non trovato nella rubrica.");
        }
    }

    public Contatto getTestaNome() {
        return testaNome;
    }

    public Contatto getTestaCognome() {
        return testaCognome;
    }

}
