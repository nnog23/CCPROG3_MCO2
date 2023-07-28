import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class VendingMachineGUI extends JFrame {
    // Your vending machine logic and data members go here

    RegularVendingMachine vendingMachine = null;



    public VendingMachineGUI() {
        // Initialize your vending machine and set up the GUI components here

        // Call a method to set up the GUI components
        initializeGUI();
    }

    private void initializeGUI() {
        // Add your GUI components here, such as buttons, labels, text fields, etc.

        
        // Example:
        JLabel label = new JLabel("Welcome to the Vending Machine Factory");

        JButton create_button = new JButton("Create a Vending Machine");
        JButton test_button = new JButton("Test a Vending Machine");
        JButton exit_button = new JButton("Exit");
        JButton regular_vend = new JButton("Regular Vending Machine");
        JButton special_vend = new JButton("Special Vending Machine");
        JButton yes = new JButton("Yes");
        JButton no = new JButton("No");
        JButton submit = new JButton("Submit");

        JLabel item_name_label = new JLabel("Item Name:");
        JTextField item_name = new JTextField(20);
 


        JLabel item_price_label = new JLabel("Item Price:");
        JTextField item_price = new JTextField(20);
     

        JLabel item_quantity_label = new JLabel("Item Quantity:");
        JTextField item_quantity = new JTextField(20);


        JLabel item_calories_label = new JLabel("Item Calories:");
        JTextField item_calories = new JTextField(20);

        JLabel item_category_label = new JLabel("Item Category:");
        JTextField item_category = new JTextField(20);

        JLabel item_process_label = new JLabel("Item Process:");
        JTextField item_process = new JTextField(20);

        JLabel item_independence_label = new JLabel("Item Independence:");
        JTextField item_independence = new JTextField(20);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        topPanel.add(label);

        JPanel buttonPanel = new JPanel(new FlowLayout());



        JPanel inputPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

      

        JPanel mainPanel = new JPanel(new BorderLayout());

        
        buttonPanel.add(create_button);
        buttonPanel.add(test_button);
        buttonPanel.add(exit_button);
        
       

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);


        create_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                if(vendingMachine == null){
                    
                
                    label.setText("Choose the type of vending machine you want to create:");

                    buttonPanel.remove(create_button);
                    buttonPanel.remove(test_button);
                    buttonPanel.remove(exit_button);
                    

                    buttonPanel.add(regular_vend);
                    buttonPanel.add(special_vend);

                    buttonPanel.revalidate();
                    buttonPanel.repaint();

                }

            }
        });

        test_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                if(vendingMachine == null){

                    label.setText("Create a vending machine first.");

                }

            }
        });


        exit_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               

            }
        });


        regular_vend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                buttonPanel.remove(label);
                vendingMachine = new RegularVendingMachine();

            }
        });


        special_vend.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {       
                
                int i;

                vendingMachine = new SpecialVendingMachine();

                int numCategories = 0;
                String customizableItem = null;
                String newCategory = null;
                String newProcess = null;
                int newMax = 0;

                

                  while (customizableItem == null){

                    customizableItem = JOptionPane.showInputDialog("Enter name of the customizable item");

                     if (customizableItem == null) {
                    // The user clicked the "Cancel" button, so show the dialog again
                    continue;
                    

                }

                };

                 ((SpecialVendingMachine)vendingMachine).setCustomizableItem(customizableItem);

                while(numCategories <= 0){

                String inputCategories = JOptionPane.showInputDialog("Enter the number of item categories:");

                if (inputCategories == null) {
                    // The user clicked the "Cancel" button, so show the dialog again
                    continue;
                }

                numCategories = Integer.parseInt(inputCategories);

                }

                

                ((SpecialVendingMachine)vendingMachine).setCategoryList(numCategories);
                ((SpecialVendingMachine)vendingMachine).setProcessList(numCategories);
                ((SpecialVendingMachine)vendingMachine).setMaxList(numCategories);

                String [] CategoryList = ((SpecialVendingMachine)vendingMachine).getCategoryList();
                String [] ProcessList = ((SpecialVendingMachine)vendingMachine).getProcessList();
                int [] Max = ((SpecialVendingMachine)vendingMachine).getMax();


                for(i = 0; i < numCategories; i++){

                while (newCategory == null){

                    newCategory = JOptionPane.showInputDialog("Enter the name of the item category " + "no. " + (i + 1));

                     if (newCategory == null) {
                    // The user clicked the "Cancel" button, so show the dialog again
                    continue;
                    

                }

                CategoryList[i] = newCategory;
                    
                
                    

                };

                newCategory = null;

                while (newProcess == null){

                    newProcess = JOptionPane.showInputDialog("Enter the process message of " + CategoryList[i]);

                     if (newProcess == null) {
                    // The user clicked the "Cancel" button, so show the dialog again
                    continue;
                    

                }

                ProcessList[i] = newProcess;
                

                };

                while(newMax <= 0){

                String inputCategories = JOptionPane.showInputDialog("Enter the maximum number of " + CategoryList[i]);

                if (inputCategories == null) {
                    // The user clicked the "Cancel" button, so show the dialog again
                    continue;
                }

                newMax = Integer.parseInt(inputCategories);

                Max[i] = newMax;

                }

                newMax = 0;


                }

                
                label.setText("Create the first eight (8) items for your special vending machine");

                
                for(i = 0; i < numCategories; i++){

                    

                }

                buttonPanel.remove(special_vend);
                buttonPanel.remove(regular_vend);
                inputPanel.add(item_name_label, gbc);
                gbc.gridx = 1;
                inputPanel.add(item_name, gbc);

                gbc.gridx = 0;
                gbc.gridy = 1;
                inputPanel.add(item_price_label, gbc);
                gbc.gridx = 1;
                inputPanel.add(item_price, gbc);

                gbc.gridx = 0;
                gbc.gridy = 2;
                inputPanel.add(item_quantity_label, gbc);
                gbc.gridx = 1;
                inputPanel.add(item_quantity, gbc);

                gbc.gridx = 0;
                gbc.gridy = 3;
                inputPanel.add(item_calories_label, gbc);
                gbc.gridx = 1;
                inputPanel.add(item_calories, gbc);
                
                gbc.gridx = 0;
                gbc.gridy = 4;
                inputPanel.add(item_category_label, gbc);
                gbc.gridx = 1;
                inputPanel.add(item_category, gbc);

                gbc.gridx = 0;
                gbc.gridy = 5;
                inputPanel.add(item_independence_label, gbc);
                gbc.gridx = 1;
                inputPanel.add(item_independence, gbc);

                buttonPanel.add(submit);

                inputPanel.revalidate();
                inputPanel.repaint();
                buttonPanel.revalidate();
                buttonPanel.repaint();
                
                
            
        }

        });

          submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                int itemCreated = 0;

                String itemName = item_name.getText();
                int itemPrice = Integer.parseInt(item_price.getText());
                int itemQuantity = Integer.parseInt(item_quantity.getText());
                float itemCalories = Float.parseFloat(item_calories.getText());
                String itemCategory = item_category.getText();
                String itemProcess = item_process.getText();
                Boolean itemIndependence = Boolean.parseBoolean(item_independence.getText());
                
                while((itemIndependence != true && itemIndependence != false) || itemQuantity < 10){

                if((itemIndependence != true && itemIndependence != false) || itemQuantity < 10){

                        label.setText("Invalid input, try again.");

                 }
                    
                itemName = item_name.getText();
                itemPrice = Integer.parseInt(item_price.getText());
                itemQuantity = Integer.parseInt(item_quantity.getText());
                itemCalories = Float.parseFloat(item_calories.getText());
                itemCategory = item_category.getText();
                itemProcess = item_process.getText();
                itemIndependence = Boolean.parseBoolean(item_independence.getText());
                    
                }

                label.setText("Success!");
                
                itemCreated++;

                vendingMachine.getItemList().add(new Item(itemName, itemPrice, itemQuantity, itemCalories, itemCategory, itemProcess, itemIndependence));

                if(itemCreated == 2){

                
                }

            }
            
    
            
        });

        

        // Set JFrame properties
        setTitle("Vending Machine Factory");
        setSize(650, 400); // Set the size of the window
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Close the application when the window is closed
        setLocationRelativeTo(null); // Center the window on the screen
        setResizable(false); // Prevent resizing the window
    }

    // Other methods and logic for your vending machine can go here



    public static void main(String[] args) {
        // Run the GUI in the event dispatch thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VendingMachineGUI().setVisible(true);
            }
        });
    }
}