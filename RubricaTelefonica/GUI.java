import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class GUI {

    Rubrica rubrica;

    private ArrayList<JLabel> contacts;
    private JLabel numberContacts;

    private JFrame window;
    private Container content;
    private JPanel buttonArea;
    private JPanel contactsArea;

    public JButton addContact;
    public JButton removeContact;
    public JButton sortName;
    public JButton sortSurname;

    private int selection;

    private Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

    public GUI(Rubrica rubrica){
        this.rubrica = rubrica;

        buttonArea = new JPanel();
        contactsArea = new JPanel();

        window = new JFrame("Rubrica by Favo");
        window.setBounds(5,5, 700, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        content = window.getContentPane();
        content.setLayout(new BorderLayout());
        buttonArea.setLayout(new GridLayout(1,4));
        contactsArea.setLayout(new GridLayout(15,1));

        content.add(buttonArea, BorderLayout.NORTH);
        content.add(contactsArea, BorderLayout.CENTER);

        setupButtonArea();
        setupContactArea();

        window.setVisible(true);
    }

    public void setName(){
        selection = 1;
    }

    public void setSurname(){
        selection = 2;
    }

    private void setupButtonArea(){
        addContact = new JButton("Aggiung contatto");
        removeContact = new JButton("Rimuovi contatto");
        sortName = new JButton("Ordina per nome");
        sortSurname = new JButton("Ordina per cognome");

        sortName.setBackground(Color.GRAY);
        sortSurname.setBackground(Color.GRAY);
        removeContact.setBackground(Color.GRAY);
        addContact.setBackground(Color.GRAY);

        sortName.setForeground(Color.WHITE);
        sortSurname.setForeground(Color.WHITE);
        removeContact.setForeground(Color.WHITE);
        addContact.setForeground(Color.WHITE);

        sortName.setBorder(border);
        sortSurname.setBorder(border);
        addContact.setBorder(border);
        removeContact.setBorder(border);

        buttonArea.add(addContact);
        buttonArea.add(removeContact);
        buttonArea.add(sortName);
        buttonArea.add(sortSurname);
    }

    private void setupContactArea(){
        contacts = new ArrayList<>();
        numberContacts = new JLabel("Sono presenti " + rubrica.conta() + " contatti.");
        contactsArea.add(numberContacts);
    }

    public void refreshNumber(){
        numberContacts.setText("Sono presenti " + rubrica.conta() + " contatti.");
        if(selection == 1){
            refreshContactsName();
        }
        if(selection == 2){
            refreshContactsSurname();
        }
    }

    public void refreshContactsName(){

        for (JLabel contact : contacts) {
            contactsArea.remove(contact);
        }
        contacts.clear();
        Contatto temp = rubrica.getTestaNome();
        while (temp!=null){
            contacts.add(new JLabel(temp.toStringOneLine()));
            temp = temp.getNextNome();
        }
        for (int i = 0; i < contacts.size(); i++) {
            contactsArea.add(contacts.get(i));
            contacts.get(i).setBorder(border);
        }
    }

    public void refreshContactsSurname(){
        for (JLabel contact : contacts) {
            contactsArea.remove(contact);
        }
        contacts.clear();
        Contatto temp = rubrica.getTestaCognome();
        while (temp!=null){
            contacts.add(new JLabel(temp.toStringOneLine()));
            temp = temp.getNextCognome();
        }
        for (int i = 0; i < contacts.size(); i++) {
            contactsArea.add(contacts.get(i));
            contacts.get(i).setBorder(border);
        }
    }

    static void showError(String message, String title){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE );
    }
    static String showInputString(String question){
        String n;
        n = JOptionPane.showInputDialog(null,
                question,
                "Input", JOptionPane.QUESTION_MESSAGE);
        if(n.length()<2){
            return n.toUpperCase();
        }
        return (n.substring(0,1).toUpperCase())+(n.substring(1).toLowerCase());
    }
    static int showInputInt(String question){
        int n;
        n = Integer.parseInt(JOptionPane.showInputDialog(null,
                question,
                "Input", JOptionPane.QUESTION_MESSAGE));
        return n;
    }
    static int showInputSelection(String question, String answer1, String answer2){
        String[] options = {answer1, answer2};
        int n = JOptionPane.showOptionDialog(null,
                question,
                "Selection",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        if(n==0){
            return 1;
        }
        if(n==1){
            return 2;
        }
        return -1;
    }

}
