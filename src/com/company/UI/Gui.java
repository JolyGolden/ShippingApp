package com.company.UI;

import com.company.containers.BigContainer;
import com.company.containers.Container;
import com.company.containers.SmallContainer;
import com.company.methods.Calculation;
import items.*;
import items.Desktop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {
    private JTextField laptopQuantityField;
    private JTextField mouseQuantityField;
    private JTextField desktopQuantityField;
    private JTextField lcdQuantityField;
    private JButton calculateButton;
    private JTextArea resultArea;

    public Gui() {
        setTitle("Shipping Cost Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Laptop Quantity:"));
        laptopQuantityField = new JTextField();
        inputPanel.add(laptopQuantityField);
        inputPanel.add(new JLabel("Mouse Quantity:"));
        mouseQuantityField = new JTextField();
        inputPanel.add(mouseQuantityField);
        inputPanel.add(new JLabel("Desktop Quantity:"));
        desktopQuantityField = new JTextField();
        inputPanel.add(desktopQuantityField);
        inputPanel.add(new JLabel("LCD Quantity:"));
        lcdQuantityField = new JTextField();
        inputPanel.add(lcdQuantityField);
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        inputPanel.add(calculateButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            // Retrieve the quantities entered by the user
            int laptopQuantity = Integer.parseInt(laptopQuantityField.getText());
            int mouseQuantity = Integer.parseInt(mouseQuantityField.getText());
            int desktopQuantity = Integer.parseInt(desktopQuantityField.getText());
            int lcdQuantity = Integer.parseInt(lcdQuantityField.getText());

            // Perform the shipping cost calculation
            Calculation calculation = new Calculation();

            // Add products
            Item laptop = new Laptop(0.6, 0.5, 0.5, 6.5);
            Item mouse = new Mouse(0.3, 0.3, 0.2, 0.2);
            Item desktop = new Desktop(1, 1.5, 0.5, 20);
            Item lcdScreen = new LCDScreen(1.2, 1.4, 0.8, 2.6);

            // Add products to the calculation
            calculation.addProduct(laptop);
            calculation.addProduct(mouse);
            calculation.addProduct(desktop);
            calculation.addProduct(lcdScreen);

            calculation.addOrder(laptopQuantity);
            calculation.addOrder(mouseQuantity);
            calculation.addOrder(desktopQuantity);
            calculation.addOrder(lcdQuantity);

            // Calculate the best shipping method
            calculation.bestShipping();
            calculation.shippingPrice();

            StringBuilder resultBuilder = new StringBuilder();

            double totalVolume  = calculation.calculateTotalVolume();
            // Display the results in the text area
            resultArea.setText("Shipping Containers:\n");
//            for (Container container : calculation.getContainersList()) {
//                resultArea.append(container.toString() + "\n");
//            }
            int bigContainerCount = 0;
            int smallContainerCount = 0;

            for (Container container : calculation.getContainersList()) {
                if (container instanceof BigContainer) {
                    bigContainerCount++;
                } else if (container instanceof SmallContainer) {
                    smallContainerCount++;
                }
            }

            //resultBuilder.append("Quantity of Small Containers: ").append(smallContainerCount).append("\n");
            resultArea.append("Amount of laptops: " + laptopQuantity + "," + "weight is " + laptop.getWeight() * laptopQuantity + "kg, "+  "volume is " +  laptop.calculateVolume() * laptopQuantity + "\n");
            resultArea.append("Amount of mouses: " + mouseQuantity + "," + "weight is " + mouse.getWeight() * mouseQuantity + "kg, "+  "volume is " +  mouse.calculateVolume() * mouseQuantity + "\n");
            resultArea.append("Amount of desktops: " + desktopQuantity + "," + "weight is " + desktop.getWeight() * desktopQuantity + "kg, "+  "volume is " +  desktop.calculateVolume() * desktopQuantity + "\n");
            resultArea.append("Amount of LCD Screens: " + lcdQuantity + "," + "weight is " + lcdScreen.getWeight() * lcdQuantity + "kg, "+  "volume is " +  lcdScreen.calculateVolume() * lcdQuantity  + "\n");
            resultArea.append("Total Volume = " + totalVolume + "m^3" + "\n");
            resultArea.append("Total Shipping Price: " + calculation.shippingPrice() + " Euro" + "\n");
            resultArea.append(("Big Containers: " + bigContainerCount + "\n"));
            resultArea.append(("Small Containers: " + smallContainerCount) + "\n");
        }
    }
}
