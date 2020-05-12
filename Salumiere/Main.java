/*
Simulare la gestione di una salumeria in cui sono presenti diversi tipi di "prodotti".
La "salumeria" si occupa di memorizzare i numeri distribuiti ai "clienti" per far rispettare il loro turno
e i prodotti disponibili (con relativa quantità). I "salumieri" serviranno i clienti dopo aver letto la loro
"lista della spesa" (lista di prodotti-quantità voluta)
Per chi svolge la versione con i thread assumere per semplicità che ci sia un solo articolo per tipologia
(es. un prosciutto cotto). I salumieri possono lavorare in maniera concorrente ma non possono entrambi affettare
lo stesso pezzo di prosciutto. Spiegare le scelte operate con un breve documento di testo.
Se volete cimentarvi nel prevedere più articoli per tipologia, scrivere un programma semplice, efficiente e ben documentato.
Chi utilizza i thread può scegliere se implementare la classe "cliente" come thread oppure far creare oggetti
thread nel main. Utilizzare una lista della spesa randomica per ogni cliente generato.
*/

public class Main {
    public static void main(String[] args) {
        Salumeria salumeria = new Salumeria();
        for (int i = 0; i < 20; i++) {
            Cliente cliente = new Cliente(salumeria, i);
            Thread thread = new Thread(cliente);
            thread.start();
            //pausa();
        }
    }

    private static void pausa(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
