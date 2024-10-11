import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class CurrencyConverter {

    // Updated conversion rates (as of Oct 11, 2024, 08:59 UTC)
    private static final HashMap<String, Double> exchangeRates = new HashMap<>();

    // Populate the exchange rates
    static {
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.913213);
        exchangeRates.put("GBP", 0.764869);
        exchangeRates.put("INR", 84.062089);
        exchangeRates.put("AUD", 1.483853);
        exchangeRates.put("CAD", 1.376470);
        exchangeRates.put("JPY", 148.722827);
        exchangeRates.put("CNY", 7.068984);
        exchangeRates.put("CHF", 0.856098);
        exchangeRates.put("ZAR", 17.457014);
        exchangeRates.put("SGD", 1.305213);
        exchangeRates.put("RUB", 96.163881);
        exchangeRates.put("BRL", 5.582292);
        exchangeRates.put("KRW", 1349.047820);
        exchangeRates.put("MXN", 19.427594);
        exchangeRates.put("PLN", 3.919862);
        exchangeRates.put("TRY", 34.294928);
        exchangeRates.put("SEK", 10.381665);
        exchangeRates.put("NZD", 1.639676);
    }

    public static void main(String[] args) {
        // Creating JFrame
        JFrame frame = new JFrame("Currency Converter");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Header (updated to black)
        JLabel headerLabel = new JLabel("Currency Converter");
        headerLabel.setBounds(150, 10, 300, 30);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(Color.BLACK); // Header color changed to black
        frame.add(headerLabel);

        // Currency Dropdowns
        String[] currencies = {"USD", "EUR", "GBP", "INR", "AUD", "CAD", "JPY", "CNY", "CHF", "ZAR", 
                               "SGD", "RUB", "BRL", "KRW", "MXN", "PLN", "TRY", "SEK", "NZD"};

        // Combo box for selecting currencies
        JComboBox<String> fromCurrency = new JComboBox<>(currencies);
        fromCurrency.setBounds(50, 60, 150, 30);
        frame.add(fromCurrency);

        JComboBox<String> toCurrency = new JComboBox<>(currencies);
        toCurrency.setBounds(300, 60, 150, 30);
        frame.add(toCurrency);

        // Input field for amount
        JTextField amountField = new JTextField();
        amountField.setBounds(50, 120, 150, 30);
        frame.add(amountField);

        // Converted amount field (output)
        JTextField convertedField = new JTextField();
        convertedField.setBounds(300, 120, 150, 30);
        convertedField.setEditable(false);
        frame.add(convertedField);

        // Button to convert
        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(200, 180, 100, 30);
        frame.add(convertButton);

        // Convert button action
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String from = fromCurrency.getSelectedItem().toString();
                    String to = toCurrency.getSelectedItem().toString();
                    double amount = Double.parseDouble(amountField.getText());

                    double fromRate = exchangeRates.get(from);
                    double toRate = exchangeRates.get(to);

                    double convertedAmount = (amount / fromRate) * toRate;
                    convertedField.setText(String.format("%.2f", convertedAmount));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a numeric value.");
                }
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }
}
