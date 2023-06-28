import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField resultsTextField;

    public void runEncryption() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("George Encryptor");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setSize(400, 400);

        JLabel byLabel = new JLabel("By gwyneorge, georgethomidis@gmail.com");
        byLabel.setBounds(10, 10, 400, 20);
        mainPanel.add(byLabel);

        comboBox1 = new JComboBox<>(new String[]{"Cipher", "Vigenere", "Caesar"});
        comboBox1.setBounds(50, 50, 150, 30);
        mainPanel.add(comboBox1);

        comboBox2 = new JComboBox<>(new String[]{"Encpt/Dcpt", "Encrypt", "Decrypt"});
        comboBox2.setBounds(210, 50, 150, 30);
        mainPanel.add(comboBox2);

        JLabel label1 = new JLabel("Text:");
        label1.setBounds(180, 100, 40, 20);
        mainPanel.add(label1);

        textField1 = new JTextField();
        textField1.setBounds(100, 130, 200, 30);
        mainPanel.add(textField1);

        JLabel label2 = new JLabel("Key");
        label2.setBounds(180, 170, 40, 20);
        mainPanel.add(label2);

        textField2 = new JTextField();
        textField2.setBounds(150, 200, 100, 30);
        mainPanel.add(textField2);

        JButton startButton = new JButton("Start");
        startButton.setBounds(150, 240, 100, 30);
        mainPanel.add(startButton);

        JPanel resultsPanel = new JPanel();
        resultsPanel.setLayout(null);
        resultsPanel.setBounds(50, 280, 310, 100);
        mainPanel.add(resultsPanel);

        JLabel resultsLabel = new JLabel("Results:");
        resultsLabel.setBounds(10, 10, 60, 20);
        resultsPanel.add(resultsLabel);

        resultsTextField = new JTextField();
        resultsTextField.setBounds(10, 40, 290, 30);
        resultsPanel.add(resultsTextField);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startEncryption();
            }
        });

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void startEncryption() {
        String cipherChoice = (String) comboBox1.getSelectedItem();
        String operationChoice = (String) comboBox2.getSelectedItem();
        String plainText = textField1.getText();
        String key = textField2.getText();

        String result;
        if (cipherChoice.equals("Vigenere")) {
            if (operationChoice.equals("Encrypt")) {
                result = VigenereCipher.encrypt(plainText, key);
            } else {
                result = VigenereCipher.decrypt(plainText, key);
            }
        } else if (cipherChoice.equals("Caesar")) {
            int shift = Integer.parseInt(key);
            if (operationChoice.equals("Encrypt")) {
                result = CaesarCipher.encrypt(plainText, shift);
            } else {
                result = CaesarCipher.decrypt(plainText, shift);
            }
        } else {
            result = "Invalid cipher choice.";
        }

        resultsTextField.setText(result);
    }
}
