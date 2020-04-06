public class SequenzaOrdinata extends Sequenza{

    public SequenzaOrdinata() {
        super();
    }

    public void inserisci(int value){
        if(testa == null){
            testa = new Nodo(value);
            return;
        }
        if(testa.next == null){
            testa.next = new Nodo(value);
            return;
        }
        Nodo temp = testa;
        while(temp.next.value < value){
            temp = temp.next;
            if (temp.next == null){
                break;
            }
        }
        Nodo newNodo = new Nodo(value);
        newNodo.next = temp.next;
        temp.next = newNodo;
    }
}
