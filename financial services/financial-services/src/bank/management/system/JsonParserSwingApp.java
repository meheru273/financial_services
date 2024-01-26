package bank.management.system;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonParserSwingApp extends JFrame {

    private JTextArea outputTextArea;

    public JsonParserSwingApp() {
        setTitle("JSON Parser");
        setSize(700, 500);
        setLocation(400,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setupUI();


        SwingUtilities.invokeLater(this::fetchAndParseJson);
    }

    private void setupUI() {
        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputTextArea);

        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(250, 2, 109));
        backButton.setBounds(300,400,100,40);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
                main_Class.main(new String[0]);
            }
        });

        /*JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);*/

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(backButton, BorderLayout.SOUTH);
    }

    private void fetchAndParseJson() {
        try {
            URL url = new URL("https://api.myjson.online/v1/records/2a5238ee-82a7-4d84-b460-f745de9f9f4d");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                parseJson(response.toString());
            } else {
                outputTextArea.append("Failed to fetch JSON data. HTTP Error Code: " + responseCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
            outputTextArea.append("Exception occurred: " + e.getMessage());
        }
    }

    private void parseJson(String jsonData) {
        try {
            Gson gson = new Gson();
            JsonObject mainObject = gson.fromJson(jsonData, JsonObject.class);
            JsonObject dataObject = mainObject.getAsJsonObject("data");
            JsonObject bankObject = dataObject.getAsJsonObject("bank");

            // Accessing values from JSON
            String bankName = bankObject.getAsJsonPrimitive("name").getAsString();
            outputTextArea.append("Bank Name: " + bankName + "\n");

            JsonArray branchesArray = bankObject.getAsJsonArray("branches");
            outputTextArea.append("Branches:\n");

            for (int i = 0; i < branchesArray.size(); i++) {
                JsonObject branch = branchesArray.get(i).getAsJsonObject();
                String location = branch.getAsJsonPrimitive("location").getAsString();
                int branchId = branch.getAsJsonPrimitive("branch_id").getAsInt();
                String branchName = branch.getAsJsonPrimitive("branch_name").getAsString();

                outputTextArea.append("  Location: " + location + ", Branch ID: " + branchId + ", Branch Name: " + branchName + "\n");
            }

            JsonArray customersArray = bankObject.getAsJsonArray("customers");
            outputTextArea.append("Customers:\n");

            for (int i = 0; i < customersArray.size(); i++) {
                JsonObject customer = customersArray.get(i).getAsJsonObject();
                String customerName = customer.getAsJsonPrimitive("name").getAsString();
                int customerId = customer.getAsJsonPrimitive("customer_id").getAsInt();

                outputTextArea.append("  Customer Name: " + customerName + ", Customer ID: " + customerId + "\n");

                JsonArray accountsArray = customer.getAsJsonArray("accounts");
                outputTextArea.append("    Accounts:\n");

                for (int j = 0; j < accountsArray.size(); j++) {
                    JsonObject account = accountsArray.get(j).getAsJsonObject();
                    String accountType = account.getAsJsonPrimitive("type").getAsString();
                    double balance = account.getAsJsonPrimitive("balance").getAsDouble();
                    String accountNumber = account.getAsJsonPrimitive("account_number").getAsString();

                    outputTextArea.append("      Type: " + accountType + ", Balance: " + balance + ", Account Number: " + accountNumber + "\n");
                }
            }

            JsonArray transactionsArray = bankObject.getAsJsonArray("transactions");
            outputTextArea.append("Transactions:\n");

            for (int i = 0; i < transactionsArray.size(); i++) {
                JsonObject transaction = transactionsArray.get(i).getAsJsonObject();
                String date = transaction.getAsJsonPrimitive("date").getAsString();
                String transactionType = transaction.getAsJsonPrimitive("type").getAsString();
                double amount = transaction.getAsJsonPrimitive("amount").getAsDouble();
                String accountNumber = transaction.getAsJsonPrimitive("account_number").getAsString();
                int transactionId = transaction.getAsJsonPrimitive("transaction_id").getAsInt();

                outputTextArea.append("  Date: " + date + ", Type: " + transactionType + ", Amount: " + amount +
                        ", Account Number: " + accountNumber + ", Transaction ID: " + transactionId + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
            outputTextArea.append("Error parsing JSON: " + e.getMessage());
        }
    }







    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JsonParserSwingApp().setVisible(true);
        });
    }
}