import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JFormattedTextField inputCitta;
    private JButton cercaButton;
    private JPanel panel;
    private JLabel tempo;
    private JLabel temp;
    private JLabel tempMax;
    private JLabel tempMin;
    private JLabel umidita;

    public GUI() {
        cercaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String citta = inputCitta.getText();
                String tempo = null;
                double[] coord = new double[0], temp = new double[0];
                try {
                    tempo = MeteoAPI.getTempo(citta);
                    coord = MeteoAPI.getCoord(citta);
                    temp = MeteoAPI.getTemp(citta);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                GUI.this.tempo.setText("Meteo attuale per " + citta + " (" + coord[0] + "° long, " + coord[1] + "° lat): " + tempo);
                GUI.this.temp.setText("Temperatura attuale: " + temp[0] + "°C");
                GUI.this.tempMax.setText("Temperatura massima: " + temp[1] + "°C");
                GUI.this.tempMin.setText("Temperatura minima: " + temp[2] + "°C");
                GUI.this.umidita.setText("Umidità: " + (int)temp[3] + "%");
              }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("");
        frame.setContentPane(new GUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
