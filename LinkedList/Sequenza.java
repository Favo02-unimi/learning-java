public class Sequenza {

    Nodo testa;

    //costruttore, vuoto perchè non deve fare nulla
    public Sequenza(){}

    //toString, scorre tutta la lista e aggiunge alla string out il valore di ogni nodo
    public String toString() {
        String out = "Numero di valori: " + conta() + "\n";
        Nodo temp = testa;
        while(temp != null){
            out += temp.toString() + ", ";
            temp=temp.next;
        }
        return out + "\n";
    }

    //conta quanti nodi compongono la sequenza, scorrendola e incrementando cont ogni giro
    public int conta(){
        int cont = 0;
        Nodo temp = testa;
        while(temp != null){
            cont++;
            temp=temp.next;
        }
        return cont;
    }

    //inserisci in coda, scorre fino all'ultimo e aggiunge un new Nodo
    public void inserisci(int value){
        if (testa==null){
            testa = new Nodo(value);
            return;
        }
        Nodo temp = testa;
        while(temp.next != null){
            temp=temp.next;
        }
        temp.next = new Nodo(value);
    }

    //cancella in coda, scorre fino al penultimo (temp.next) e arrivato slega l'ultimo
    public void cancella(){
        if(testa == null){
            return;
        }
        if(testa.next==null){
            testa = null;
            return;
        }
        Nodo temp = testa;
        while(temp.next.next != null){
            temp=temp.next;
        }
        temp.next = null;
    }

    public void cancellaValore(int value){
        //caso limite che la lista sia vuota
        if (testa == null){
            return;
        }
        //caso limite che il valore sia la testa
        if (testa.value == value){
            testa = testa.next;
            return;
        }
        //cancellazione senza casi limite
        Nodo temp = testa;
        while (temp.next.value != value){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    //cerca il nodo con value, scorre fino a quando non trova il value
    public Nodo cerca(int value){
        Nodo temp = testa;
        while (temp!=null && temp.value !=value){
            temp = temp.next;
        }
        return temp;
    }

    //cerca il nodo con value, scorre (contando) fino a quando non trova il value e ritorna il cont
    public int cercaIndice(int value){
        Nodo temp = testa;
        int cont = 0;
        while (temp!=null && temp.value !=value){
            temp = temp.next;
            cont++;
        }
        if(cont == conta()){
            return -1;
        }
        return cont;
    }
}
