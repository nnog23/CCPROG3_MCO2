import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Component;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

/**
 * class that serves as the view for the ui
 */

public class VendingMachineView{

    private JFrame mainFrame;
	private JLabel nameLbl, Items, ilName, ilPrice, ilQuantity, ilCalories, ilCategory, VendMenu, CreateRegAgainMenu, CreateSpecAgainMenu;
	private JTextField iName, iPrice, iQuantity, iCalories, iCategory;

    // FIRST MENU

	private JButton RegVend, SpecVend, TestVend, RegSubmit, SpecSubmit, SubmitItem;

    // TEST MENU

    private JButton VendFeatures, MaintFeatures;

    // VENDING MENU

    private JComboBox<String> denominations, category;
    private JLabel chooseItemLabel, moneyLabel, customizedPrice, customizedCalories;
    private JButton insertCash, selectItem, cancelTransaction, customizeProduct, printReceipt;
    private JButton confirmCash, confirmItem;
    private JTextField itemSelect, itemMaintenance;


    // CUSTOMIZE PRODUCT

    private JButton submitSinker, submitTeaBase, submitMilk, submitFlavoring, proceedTransaction, customconfirmcash, custominsertcash;

    // MAINTENANCE MENU 
    
    private JComboBox<String> items; // unadded to UML

    private JButton displayItemList, displayChangeList, replenishItem, replenishChange, replenishChangeConfirm, replenishItemConfirm, setPriceConfirm, addNewItem, 
    setPrice, collectPayment, printSummary, endMaintenance, endItemDisplay, endChangeDisplay, endTransactionDisplay;

    // replenishchangeconfirm unadded to UML
    // replenishitemconfirm unadded to UML
    // setpriceconfirm unadded to UML

    private JTextField replenishAmount; // unadded to UML
    private JTextArea changeListTextArea, transacListArea;   

    // NEW ITEM LIST

    private JTable itemListTable;//unadded to UML
    private JScrollPane itemListScrollPane; // unadded to UML
    
    // NEW CHANGE LIST

    private JTable changeListTable; // unadded to UML
    private JScrollPane changeListScrollPane; // unadded to UML

    // CREATE AGAIN MENU

    private JButton regyes, regno, specyes, specno;
	   
    /**
     *  constructor to create an instance of VendingMachineView
     */
    public VendingMachineView(){
        
        
        this.mainFrame = new JFrame ("Vending Machine Factory");
        
	//	this.mainFrame.setSize(375,500);
        //this.mainFrame.setLayout(new BoxLayout(mainFrame, BoxLayout.Y_AXIS));
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel buttonpanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
        
       this.mainFrame.setLayout(new BorderLayout());

       this.mainFrame.add(panel, BorderLayout.CENTER);



       // Set the mainFrame's size

       this.mainFrame.setSize(500, 700);
       panel.setSize(700,800);
       
       
        

       this.mainFrame.setLocationRelativeTo(null);

   

       this.mainFrame.setVisible(true);
       
       
       

        // FIRST MENU
        
        this.nameLbl = new JLabel("Welcome to the Vending Machine Factory");
        nameLbl.setPreferredSize(new Dimension(100,100));
        nameLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(this.nameLbl);
        panel.add(buttonpanel);
        
        RegVend = new JButton ("Create a Regular Vending Machine");
        SpecVend = new JButton ("Create a Special Vending Machine");
        TestVend = new JButton ("Test Vending Machine");
        
  

        //this.mainFrame.add(panel);
        buttonpanel.add(RegVend);
        buttonpanel.add(SpecVend);
        buttonpanel.add(TestVend);
        
        

        // TEST MENU (VENDING AND MAINTENANCE)

        this.VendMenu = new JLabel("Choose a mode: ");
        buttonpanel.add(VendMenu);
        VendMenu.setVisible(false);

        this.VendFeatures = new JButton("Test Vending Features");
        this.MaintFeatures = new JButton("Test Maintenance Features");

        VendFeatures.setBounds(10, 10, 75, 75);
        MaintFeatures.setBounds(10, 10, 75, 75);
        
        buttonpanel.add(VendFeatures);
        buttonpanel.add(MaintFeatures);
        
        this.VendFeatures.setVisible(false);
        this.MaintFeatures.setVisible(false);
        this.VendFeatures.setEnabled(false);
        this.MaintFeatures.setEnabled(false);
        
        //CREATE ITEMS PART

        this.Items = new JLabel("Create Items");
        this.ilName = new JLabel("Name: ");
        this.ilPrice = new JLabel("Price: ");
        this.ilQuantity = new JLabel("Quantity: ");
        this.ilCalories = new JLabel("Calories: ");
        this.ilCategory = new JLabel("Category: ");
        

        panel.add(Items);
        panel.add(ilName);
        
        this.Items.setVisible(false);
        this.ilName.setVisible(false);
        this.ilPrice.setVisible(false);
        this.ilQuantity.setVisible(false);
        this.ilCalories.setVisible(false);
        this.ilCategory.setVisible(false);
        

        this.iName = new JTextField();
		this.iName.setColumns(10);
        this.iPrice = new JTextField();
		this.iPrice.setColumns(10);
        this.iQuantity = new JTextField();
		this.iQuantity.setColumns(10);
        this.iCalories = new JTextField();
		this.iCalories.setColumns(10);
        this.iCategory = new JTextField();
		this.iCategory.setColumns(10);
  
        String[] categoryOptions = {"Sinker", "Tea Base", "Flavoring", "Milk"};
        this.category = new JComboBox<String>(categoryOptions);
        this.category.setMaximumSize(category.getPreferredSize());
        this.category.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        


        panel.add(iName);
        panel.add(ilPrice);
        panel.add(iPrice);
        panel.add(ilQuantity);
        panel.add(iQuantity);
        panel.add(ilCalories);
        panel.add(iCalories);
        panel.add(ilCategory);
        panel.add(category);


        this.iName.setVisible(false);
        this.iName.setEnabled(false);
        this.iPrice.setVisible(false);
        this.iPrice.setEnabled(false);
        this.iQuantity.setVisible(false);
        this.iQuantity.setEnabled(false);
        this.iCalories.setVisible(false);
        this.iCalories.setEnabled(false);
        this.category.setVisible(false);
        this.category.setEnabled(false);


        RegSubmit = new JButton("Add Regular Item");
        SpecSubmit = new JButton("Add Special Item");
        SubmitItem = new JButton("Submit");

        RegSubmit.setBounds(10, 10, 60, 60);
        SpecSubmit.setBounds(10, 10, 60, 60);
        SubmitItem.setBounds(10, 10, 60, 60);
        
        this.RegSubmit.setEnabled(false);
        this.RegSubmit.setVisible(false);
        this.SpecSubmit.setEnabled(false);
        this.SpecSubmit.setVisible(false);
        this.SubmitItem.setEnabled(false);
        this.SubmitItem.setVisible(false);

        panel.add(RegSubmit);
        panel.add(SpecSubmit);
        panel.add(SubmitItem);

        RegVend.setAlignmentX(Component.CENTER_ALIGNMENT);
        SpecVend.setAlignmentX(Component.CENTER_ALIGNMENT);
        TestVend.setAlignmentX(Component.CENTER_ALIGNMENT);

        //create "Add Item" button
        
        // VENDING MENU

        this.insertCash = new JButton("Insert Cash");
        this.selectItem = new JButton("Select Item");
        this.cancelTransaction = new JButton("Cancel Transaction");
        this.customizeProduct = new JButton("Customize Product");
        this.printReceipt = new JButton("Exit");
        this.customizedPrice = new JLabel ("Total price is: ");

        this.customizedPrice.setVisible(false);
        this.insertCash.setVisible(false);
        this.insertCash.setEnabled(false);
        this.selectItem.setVisible(false);
        this.selectItem.setEnabled(false);
        this.cancelTransaction.setVisible(false);
        this.cancelTransaction.setEnabled(false);
        this.customizeProduct.setVisible(false);
        this.customizeProduct.setEnabled(false);
        this.printReceipt.setVisible(false);
        this.printReceipt.setEnabled(false);

        insertCash.setBounds(10, 10, 60, 60);
        selectItem.setBounds(10, 10, 60, 60);
        cancelTransaction.setBounds(10, 10, 60, 60);
        customizeProduct.setBounds(10, 10, 60, 60);
        printReceipt.setBounds(10, 10, 60, 60);
        buttonpanel.add(customizedPrice);
        buttonpanel.add(insertCash);
        buttonpanel.add(selectItem);
        buttonpanel.add(cancelTransaction);
        buttonpanel.add(customizeProduct);
        buttonpanel.add(printReceipt);
        
        // INSERT CASH

        this.moneyLabel = new JLabel();
        this.moneyLabel.setVisible(false);
        buttonpanel.add(moneyLabel);
        
        String[] cashChoice = {"1000", "500", "200", "100", "50", "20", "10", "5", "1"};
        this.denominations = new JComboBox<String>(cashChoice);
        this.denominations.setMaximumSize(denominations.getPreferredSize());
        this.denominations.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonpanel.add(denominations);
        this.denominations.setVisible(false);
        this.denominations.setEnabled(false);

        this.confirmCash = new JButton("Insert denomination");
        this.confirmCash.setVisible(false);
        this.confirmCash.setEnabled(false);
        buttonpanel.add(confirmCash);
        
        // REPLENISH CHANGE

        this.replenishAmount = new JTextField();
        this.replenishAmount.setColumns(10);
        this.replenishChangeConfirm = new JButton("Replenish denomination");
        this.replenishChangeConfirm.setVisible(false);
        this.replenishChangeConfirm.setEnabled(false);
        this.replenishAmount.setVisible(false);
        this.replenishAmount.setEnabled(false);
        buttonpanel.add(replenishAmount);
        buttonpanel.add(replenishChangeConfirm);

        // REPLENISH ITEM   
        
        this.items = new JComboBox<String>();
        this.items.setMaximumSize(items.getPreferredSize());
        this.items.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonpanel.add(items);
        this.items.setVisible(false);
        this.items.setEnabled(false);

        
        this.replenishItemConfirm = new JButton("Replenish item");
        this.replenishItemConfirm.setVisible(false);
        this.replenishItemConfirm.setEnabled(false);

        buttonpanel.add(replenishItemConfirm);
        
        // SET PRICE

        this.setPriceConfirm = new JButton("Set Price");
        this.setPriceConfirm.setVisible(false);
        this.setPriceConfirm.setEnabled(false);

        buttonpanel.add(setPriceConfirm);

        // NEW ITEM LIST


        String[] columnINames = {"Item Name", "Price", "Quantity", "Calories", "Category"};
        
        Object[][] data = new Object[0][columnINames.length];
        
        DefaultTableModel tableModel = new DefaultTableModel(data, columnINames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Set all cells to non-editable
            }
        };
        
        itemListTable = new JTable(tableModel);
        itemListTable.getTableHeader().setReorderingAllowed(false);
        itemListScrollPane = new JScrollPane(itemListTable);
        panel.add(itemListScrollPane);

        itemListScrollPane.setVisible(false);


            
        // NEW CHANGE LIST

        String[] columnCNames = {"Denomination", "Amount"};
        Object[][] data2 = new Object[0][columnCNames.length];
        DefaultTableModel tableModel2 = new DefaultTableModel(data2, columnCNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Set all cells to non-editable
            }
        };
        changeListTable = new JTable(tableModel2);
        changeListTable.getTableHeader().setReorderingAllowed(false);
        changeListScrollPane = new JScrollPane(changeListTable);
        panel.add(changeListScrollPane);

        changeListScrollPane.setVisible(false);

        // SELECT ITEM
        

        this.chooseItemLabel = new JLabel("Input item number");
        buttonpanel.add(chooseItemLabel);
        this.chooseItemLabel.setVisible(false);
        this.confirmItem = new JButton ("Confirm");
        this.itemSelect = new JTextField();
        this.itemSelect.setColumns(10);
        panel.add(itemSelect);
        panel.add(confirmItem);
        this.itemSelect.setVisible(false);
        this.itemSelect.setEnabled(false);
        this.confirmItem.setVisible(false);
        this.confirmItem.setEnabled(false);
        
        // CUSTOMIZE PRODUCT
    
        this.customizedCalories = new JLabel("Customized Calories");
        this.customizedCalories.setVisible(false);
        
        buttonpanel.add(customizedCalories);
        
        this.custominsertcash = new JButton("Insert Cash");
        this.custominsertcash.setVisible(false);
        this.custominsertcash.setEnabled(false);

        this.customconfirmcash = new JButton("Insert denomination");
        this.customconfirmcash.setVisible(false);
        this.customconfirmcash.setEnabled(false);

        buttonpanel.add(custominsertcash);
        buttonpanel.add(customconfirmcash);

        this.proceedTransaction = new JButton("Proceed and Buy");
        this.proceedTransaction.setEnabled(false);
        this.proceedTransaction.setVisible(false);
        buttonpanel.add(proceedTransaction);
        
            // SINKERS

        

        this.submitSinker = new JButton("Confirm Sinkers");
        this.submitSinker.setEnabled(false);
        this.submitSinker.setVisible(false);

        
        buttonpanel.add(submitSinker);
        

            // TEABASES

        this.submitTeaBase = new JButton("Confirm Teabase");
        this.submitTeaBase.setEnabled(false);
        this.submitTeaBase.setVisible(false);

        buttonpanel.add(submitTeaBase);

            // MILKS

        this.submitMilk = new JButton("Confirm Milk");
        this.submitMilk.setEnabled(false);
        this.submitMilk.setVisible(false);

        buttonpanel.add(submitMilk);


            // FLAVORINGS

  

        this.submitFlavoring = new JButton("Confirm Flavoring");
        this.submitFlavoring.setEnabled(false);
        this.submitFlavoring.setVisible(false);

        buttonpanel.add(submitFlavoring);
        

        // MAINTENANCE MENU

        this.changeListTextArea = new JTextArea("");
        this.changeListTextArea.setPreferredSize(new Dimension(220,30));
        this.changeListTextArea.setEditable(false);
        this.changeListTextArea.setVisible(false);

        panel.add(changeListTextArea);
        

        this.displayItemList = new JButton("Display Item List");
        this.endItemDisplay = new JButton ("Back");
        this.displayChangeList = new JButton("Display Change List");
        this.endChangeDisplay = new JButton ("Back");
        this.replenishItem = new JButton("Replenish Item");
        this.replenishChange = new JButton("Replenish Change");
        this.addNewItem = new JButton("Add New Item");
        this.setPrice = new JButton("Set Price");
        this.collectPayment = new JButton("Collect Payment");
        this.printSummary = new JButton("Print Summary");
        this.endTransactionDisplay = new JButton ("Back");
        this.endMaintenance = new JButton("End Maintenance Features Test");

        this.transacListArea = new JTextArea ("");
        this.transacListArea.setPreferredSize(new Dimension(300,300));
        this.itemMaintenance = new JTextField();
        this.itemMaintenance.setColumns(10);
        this.transacListArea.setEditable(false);
        this.transacListArea.setVisible(false);

        this.displayItemList.setVisible(false);
        this.displayItemList.setEnabled(false);
        this.endItemDisplay.setVisible(false);
        this.endItemDisplay.setEnabled(false);

        this.displayChangeList.setVisible(false);
        this.displayChangeList.setEnabled(false);
        this.endChangeDisplay.setVisible(false);
        this.endChangeDisplay.setEnabled(false);


        this.replenishItem.setVisible(false);
        this.replenishItem.setEnabled(false);

        this.replenishChange.setVisible(false);
        this.replenishChange.setEnabled(false);

        this.addNewItem.setVisible(false);
        this.addNewItem.setEnabled(false);

        this.setPrice.setVisible(false);
        this.setPrice.setEnabled(false);
        this.itemMaintenance.setEnabled(false);
        this.itemMaintenance.setVisible(false);


        this.collectPayment.setVisible(false);
        this.collectPayment.setEnabled(false);

        this.printSummary.setVisible(false);
        this.printSummary.setEnabled(false);
        this.endTransactionDisplay.setVisible(false);
        this.endTransactionDisplay.setEnabled(false);

        this.endMaintenance.setVisible(false);
        this.endMaintenance.setEnabled(false);

        displayItemList.setBounds(10, 10, 60, 60);
        endItemDisplay.setBounds(10, 10, 60, 60);
        displayChangeList.setBounds(10, 10, 60, 60);
        endChangeDisplay.setBounds(10, 10, 60, 60);
        replenishItem.setBounds(10, 10, 60, 60);
        replenishChange.setBounds(10, 10, 60, 60);
        addNewItem.setBounds(10, 10, 60, 60);
        setPrice.setBounds(10, 10, 60, 60);
        collectPayment.setBounds(10, 10, 60, 60);
        printSummary.setBounds(10, 10, 60, 60);
        endTransactionDisplay.setBounds(10, 10, 60, 60);
        endMaintenance.setBounds(10, 10, 60, 60);

        buttonpanel.add(displayItemList);
        buttonpanel.add(endItemDisplay);
        buttonpanel.add(displayChangeList);
        buttonpanel.add(endChangeDisplay);
        buttonpanel.add(replenishItem);
        buttonpanel.add(replenishChange);
        buttonpanel.add(addNewItem);
        buttonpanel.add(setPrice);
        buttonpanel.add(itemMaintenance);
        buttonpanel.add(collectPayment);
        buttonpanel.add(printSummary);
        buttonpanel.add(transacListArea);
        buttonpanel.add(endTransactionDisplay);
        buttonpanel.add(endMaintenance);
    
        // CREATE AGAIN MENU
        
        this.CreateRegAgainMenu = new JLabel("<html>You have an existing regular vending machine, do you want to create again? XD <br/></html>");
        this.CreateSpecAgainMenu = new JLabel("<html>You have an existing special vending machine, do you want to create again? XD <br/></html>");
        this.regyes = new JButton("Yes");
        this.regno = new JButton("No");
        
        this.specyes = new JButton("Yes");
        this.specno = new JButton("No");

        this.regyes.setVisible(false);
        this.regyes.setEnabled(false);

        this.specyes.setVisible(false);
        this.specyes.setEnabled(false);

        this.regno.setVisible(false);
        this.regno.setEnabled(false);

        this.specno.setVisible(false);
        this.specno.setEnabled(false);

        this.CreateRegAgainMenu.setVisible(false);
        this.CreateSpecAgainMenu.setVisible(false);
  
        

        regyes.setBounds(10, 10, 60, 60);
        regno.setBounds(10, 10, 60, 60);
        specyes.setBounds(10, 10, 60, 60);
        specno.setBounds(10, 10, 60, 60);
        CreateRegAgainMenu.setPreferredSize(new Dimension(300,100));
        CreateSpecAgainMenu.setPreferredSize(new Dimension(300,100));
        
        buttonpanel.add(CreateRegAgainMenu);
        buttonpanel.add(CreateSpecAgainMenu);
        buttonpanel.add(regyes);
        buttonpanel.add(regno);
        buttonpanel.add(specyes);
        buttonpanel.add(specno);
        
        

    }

    // FIRST MENU LISTENERS CREATORS

    /**
     * sets an actionlistener for creating regular vending machine
     * @param actionListener is the actionlistener instance for the button
     */
    public void setRegVendBtnListener(ActionListener actionListener) {

		this.RegVend.addActionListener(actionListener);
        
        
	}
    /**
     * sets an actionlistener for creating special vending machine
     * @param actionListener is the actionlistener instance for the button
     */
    public void setSpecVendBtnListener(ActionListener actionListener) {

	
        this.SpecVend.addActionListener(actionListener);
        
	}
    /**
     *  sets an actionlistener for testing a vendingmachine
     * @param actionListener is the actionlistener instance for the button
     */

    public void setTestVendBtnListener(ActionListener actionListener) {

		this.TestVend.addActionListener(actionListener);
        
        
	}

    // TEST MENU LISTENERS CREATORS
    /**
     *  sets an actionlistener for entering the vending options menu
     * @param actionListener is the actionlistener instance for the button
     */

    public void setVendListener(ActionListener actionListener) {

	 this.VendFeatures.addActionListener(actionListener);
        
        
	}
    /**
     *  sets an actionlistener for entering the maintenance option menu
     * @param actionListener is the actionlistener instance for the button
     */

    public void setMaintListener(ActionListener actionListener) {

		this.MaintFeatures.addActionListener(actionListener);
        
        
	}
    
    // SUBMIT ITEMS LISTENERS CREATORS
    /**
     *  sets an actionlistener for submitting items in the regular vending machine
     * @param actionListener is the actionlistener instance for the button
     */

    public void setRegSubmitListener(ActionListener actionListener) {

		this.RegSubmit.addActionListener(actionListener);
        
        
	}
    /**
     *  sets an actionlistener for submitting items in the special vending machine
     * @param actionListener is the actionlistener instance for the button
     */

    public void setSpecSubmitListener(ActionListener actionListener) {

		this.SpecSubmit.addActionListener(actionListener);
        
        
	}

    /**
     *  sets an actionlistener for exiting the item create menu and entering the first menu
     * @param actionListener is the actionlistener instance for the button
     */
    public void setSubmitBtnListener(ActionListener actionListener){

        this.SubmitItem.addActionListener(actionListener);

    }

    // VENDING FEATURES LISTENERS CREATORS
    /**
     *  sets an actionlistener for entering the insert cash menu
     * @param actionListener is the actionlistener instance for the button
     */
    public void setInsertCashBtn(ActionListener actionListener){

        
        this.insertCash.addActionListener(actionListener);
        
    }
    /**
     *  sets an actionlistener for entering the select item menu
     * @param actionListener is the actionlistener instance for the button
     */
    
    public void setSelectItemBtn(ActionListener actionListener){


        this.selectItem.addActionListener(actionListener);
        
    }
    /**
     *  sets an actionlistener for cancelling a transaction
     * @param actionListener is the actionlistener instance for the button
     */
    public void setCancelTransactionBtn(ActionListener actionListener){


        this.cancelTransaction.addActionListener(actionListener);
        
    }
    /**
     *  sets an actionlistener for customizing product menu
     * @param actionListener is the actionlistener instance for the button
     */

    public void setCustomizeProductBtn(ActionListener actionListener){


        this.customizeProduct.addActionListener(actionListener);
        
    }
/**
     *  sets an actionlistener for proceeding with transaction
     * @param actionListener is the actionlistener instance for the button
     */
    public void setProceedTransactionBtn(ActionListener actionListener){


        this.proceedTransaction.addActionListener(actionListener);
        
    }
    /**
     *  sets an actionlistener for confirming cash during customized item creation
     * @param actionListener is the actionlistener instance for the button
     */

    public void setCustomConfirmCashBtn(ActionListener actionListener){


        this.customconfirmcash.addActionListener(actionListener);
        
    }


    /**
     *  sets an actionlistener for submitting the chosen sinkers
     * @param actionListener is the actionlistener instance for the button
     */
    public void setSubmitSinkerBtn(ActionListener actionListener){


        this.submitSinker.addActionListener(actionListener);
        
    }
    /**
     *  sets an actionlistener for exiting item display in maintenance
     * @param actionListener is the actionlistener instance for the button
     */
    public void endItemDisplay(ActionListener actionListener){


        this.endItemDisplay.addActionListener(actionListener);
        
    }
    /**
     *  sets an actionlistener for exiting change display in maintenance
     * @param actionListener is the actionlistener instance for the button
     */
    public void endChangeDisplay(ActionListener actionListener){


        this.endChangeDisplay.addActionListener(actionListener);
        
    }
    /**
     *  sets an actionlistener for exiting transaction display in maintenance 
     * @param actionListener is the actionlistener instance for the button
     */
    public void endTransactionDisplay(ActionListener actionListener){


        this.endTransactionDisplay.addActionListener(actionListener);
        
    }
    
    /**
     *  sets an actionlistener for submitting the chosen tea base
     * @param actionListener is the actionlistener instance for the button
     */
    public void setSubmitTeaBaseBtn(ActionListener actionListener){


        this.submitTeaBase.addActionListener(actionListener);
        
    }
    /**
     *  sets an actionlistener for submitting the chosen flavoring
     * @param actionListener is the actionlistener instance for the button
     */
    public void setSubmitFlavoringBtn(ActionListener actionListener){


        this.submitFlavoring.addActionListener(actionListener);
        
    }
    /**
     *  sets an actionlistener for submitting the chosen milk
     * @param actionListener is the actionlistener instance for the button
     */
    public void setSubmitMilkBtn(ActionListener actionListener){


        this.submitMilk.addActionListener(actionListener);
        
    }
    

    /**
     *  sets an actionlistener for printing a receipt
     * @param actionListener is the actionlistener instance for the button
     */
    public void setPrintReceiptBtn(ActionListener actionListener){
            

        this.printReceipt.addActionListener(actionListener);
        
    }
    


    // MAINTENANCE FEATURES LISTENERS CREATORS
    /**
     *  sets an actionlistener to enter the display item list menu
     * @param actionListener is the actionlistener instance for the button
     */

    public void setDisplayItemListBtn(ActionListener actionListener){

        this.displayItemList.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener to enter the display change list menu
     * @param actionListener is the actionlistener instance for the button
     */ 
    public void setDisplayChangeListBtn(ActionListener actionListener){

        this.displayChangeList.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for entering the replenish item menu
     * @param actionListener is the actionlistener instance for the button
     */

    public void setReplenishItemBtn(ActionListener actionListener){

        this.replenishItem.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for entering the replenish change menu
     * @param actionListener is the actionlistener instance for the button
     */

    public void setReplenishChangeBtn(ActionListener actionListener){

        this.replenishChange.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for confirming the change replenish
     * @param actionListener is the actionlistener instance for the button
     */
    public void setReplenishChangeConfirmBtn(ActionListener actionListener){ // unadded to uml, needs javadoc

        this.replenishChangeConfirm.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for confirming the item replenish
     * @param actionListener is the actionlistener instance for the button
     */
    public void setReplenishItemConfirmBtn(ActionListener actionListener){ // unadded to uml, needs javadoc

        this.replenishItemConfirm.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for confirming the item repricing
     * @param actionListener is the actionlistener instance for the button
     */

    public void setSetPriceConfirmBtn(ActionListener actionListener){ // unadded to uml, needs javadoc

        this.setPriceConfirm.addActionListener(actionListener);

    }

    /**
     *  sets an actionlistener for entering the add new item menu
     * @param actionListener is the actionlistener instance for the button
     */
    
    public void setAddNewItemBtn(ActionListener actionListener){

        this.addNewItem.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for entering the set price me
     * @param actionListener is the actionlistener instance for the button
     */

    public void setSetPriceBtn(ActionListener actionListener){

        this.setPrice.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for collecting money inside vending machine
     * @param actionListener is the actionlistener instance for the button
     */

    public void setCollectPaymentBtn(ActionListener actionListener){

        this.collectPayment.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for printing a summary of purchased items
     * @param actionListener is the actionlistener instance for the button
     */

    public void setPrintSummaryBtn(ActionListener actionListener){

        this.printSummary.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for exiting the maintenance menu and returning to second menu
     * @param actionListener is the actionlistener instance for the button
     */

    public void setEndMaintenanceBtn(ActionListener actionListener){

        this.endMaintenance.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for when yes is clicked when prompted to create a new regular vending machine
     * @param actionListener is the actionlistener instance for the button
     */

    public void setRegYesBtn(ActionListener actionListener){

        this.regyes.addActionListener(actionListener);

    
    }
    /**
     *  sets an actionlistener for when no is clicked when prompted to create a new regular vending machine
     * @param actionListener is the actionlistener instance for the button
     */
    public void setRegNoBtn(ActionListener actionListener){

        this.regno.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for when yes is clicked when prompted to create a new special vending machine
     * @param actionListener is the actionlistener instance for the button
     */

    public void setSpecYesBtn(ActionListener actionListener){

        this.specyes.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for when yes is clicked when prompted to create a new special vending machine
     * @param actionListener is the actionlistener instance for the button
     */

    public void setSpecNoBtn(ActionListener actionListener){

        this.specno.addActionListener(actionListener);

    }
    /**
     *  sets an actionlistener for when inserting cash of the chosen denomination
     * @param actionListener is the actionlistener instance for the button
     */

    public void insertCashBtns (ActionListener actionListener){

        this.confirmCash.addActionListener(actionListener);
        
    }

    public void setCustomInsertCashBtn (ActionListener actionListener){

        this.custominsertcash.addActionListener(actionListener);
        
    }

   /**
     *  sets an actionlistener for when confirming to purchase the selected item
     * @param actionListener is the actionlistener instance for the button
     */
    public void confirmItemBtn (ActionListener actionListener){
        this.confirmItem.addActionListener(actionListener);
    }

    /**
     * sets the status of the submit item button
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void SubmitItemStatus(boolean status){

        this.SubmitItem.setEnabled(status);
        this.SubmitItem.setVisible(status);

    }
    /**
     * sets the status of the first menu
     * @param status determines if they are visible/enabled or not (T/F) 
     */
    public void FirstMenuStatus (boolean status){

        this.RegVend.setEnabled(status);
        this.RegVend.setVisible(status);
        this.SpecVend.setEnabled(status);
        this.SpecVend.setVisible(status);
        this.TestVend.setEnabled(status);
        this.TestVend.setVisible(status);
        this.nameLbl.setVisible(status);
        
    }
    /**
     * sets the status of the second menu
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    
    public void SecondMenuStatus (boolean status){

        this.VendMenu.setVisible(status);
        this.VendFeatures.setVisible(status);
        this.MaintFeatures.setVisible(status);
        this.VendFeatures.setEnabled(status);
        this.MaintFeatures.setEnabled(status);


    }
    /**
     * sets the status of the vending menu
     * @param status determines if they are visible/enabled or not (T/F) 
     */


    public void VendingMenuStatus(boolean status){


        this.insertCash.setEnabled(status);
        this.insertCash.setVisible(status);
        
        this.selectItem.setEnabled(status);
        this.selectItem.setVisible(status);

        this.cancelTransaction.setEnabled(status);
        this.cancelTransaction.setVisible(status);

        this.customizeProduct.setEnabled(status);
        this.customizeProduct.setVisible(status);

        this.printReceipt.setEnabled(status);
        this.printReceipt.setVisible(status);



    }   


    /**
     * sets the status of the maintenance menu
     * @param status determines if they are visible/enabled or not (T/F) 
     */
    public void MaintMenuStatus(boolean status){

        this.displayItemList.setEnabled(status);
        this.displayItemList.setVisible(status);

        this.displayChangeList.setEnabled(status);
        this.displayChangeList.setVisible(status);

        this.replenishItem.setEnabled(status);
        this.replenishItem.setVisible(status);

        this.replenishChange.setEnabled(status);
        this.replenishChange.setVisible(status);

        this.addNewItem.setEnabled(status);
        this.addNewItem.setVisible(status);

        this.setPrice.setEnabled(status);
        this.setPrice.setVisible(status);

        this.collectPayment.setEnabled(status);
        this.collectPayment.setVisible(status);

        this.printSummary.setEnabled(status);
        this.printSummary.setVisible(status);

        this.endMaintenance.setEnabled(status);
        this.endMaintenance.setVisible(status);

    }
    /**
     * sets the status of the create a regular vending machine again menu
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void createRegAgainStatus(boolean status){


        this.regyes.setEnabled(status);
        this.regyes.setVisible(status);
        this.regno.setEnabled(status);
        this.regno.setVisible(status);
        this.CreateRegAgainMenu.setVisible(status);

    }

    /**
     * sets the status of the create a special vending machine again menu
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void createSpecAgainStatus(boolean status){


        this.specyes.setEnabled(status);
        this.specyes.setVisible(status);
        this.specno.setEnabled(status);
        this.specno.setVisible(status);
        this.CreateSpecAgainMenu.setVisible(status);

    }
    /**
     * sets the status of the item submitting menu for regular vending machine
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void RegularItemCreate(boolean status){

        this.Items.setVisible(status);
        this.ilName.setVisible(status);
        this.ilPrice.setVisible(status);
        this.ilQuantity.setVisible(status);
        this.ilCalories.setVisible(status);
        this.iName.setVisible(status);
        this.iName.setEnabled(status);
        this.iPrice.setVisible(status);
        this.iPrice.setEnabled(status);
        this.iQuantity.setVisible(status);
        this.iQuantity.setEnabled(status);
        this.iCalories.setVisible(status);
        this.iCalories.setEnabled(status);
        this.RegSubmit.setEnabled(status);
        this.RegSubmit.setVisible(status);
        
    }

    /**
     * sets the status of the item submitting for special vending machine
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void SpecialItemCreate(boolean status){

        this.Items.setVisible(status);
        this.ilName.setVisible(status);
        this.ilPrice.setVisible(status);
        this.ilQuantity.setVisible(status);
        this.ilCalories.setVisible(status);
        this.ilCategory.setVisible(status);
        this.iName.setVisible(status);
        this.iName.setEnabled(status);
        this.iPrice.setVisible(status);
        this.iPrice.setEnabled(status);
        this.iQuantity.setVisible(status);
        this.iQuantity.setEnabled(status);
        this.iCalories.setVisible(status);
        this.iCalories.setEnabled(status);
        this.category.setVisible(status);
        this.category.setEnabled(status);
        this.SpecSubmit.setEnabled(status);
        this.SpecSubmit.setVisible(status);

    }

    /**
     * sets the status of the insert cash menu
     * @param status determines if they are visible/enabled or not (T/F) 
     */
    
    public void insertCashState(boolean status){

        this.confirmCash.setVisible(status);
        this.confirmCash.setEnabled(status);
        this.denominations.setVisible(status);
        this.denominations.setEnabled(status);
        this.moneyLabel.setVisible(status);
        
    }

    public void custominsertCashState(boolean status){
        
        this.customconfirmcash.setVisible(status);
        this.customconfirmcash.setEnabled(status);
        this.denominations.setVisible(status);
        this.denominations.setEnabled(status);
        this.moneyLabel.setVisible(status);
        
    }

    /**
     * sets the status of the replenish change menu
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void replenishChangeState(boolean status){ // need javadoc

        this.replenishAmount.setVisible(status);
        this.replenishAmount.setEnabled(status);
        this.replenishChangeConfirm.setVisible(status);
        this.replenishChangeConfirm.setEnabled(status);
        this.denominations.setVisible(status);
        this.denominations.setEnabled(status);
        
        
    }
    /**
     * sets the status of the replenish item menu
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void replenishItemState(boolean status){ // need javadoc

        this.replenishAmount.setVisible(status);
        this.replenishAmount.setEnabled(status);
        this.replenishItemConfirm.setVisible(status);
        this.replenishItemConfirm.setEnabled(status);
        this.items.setVisible(status); 
        this.items.setEnabled(status); 

        

    }
    /**
     * sets the status of the set price menu
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void setPriceState(boolean status){ // need javadoc

        this.replenishAmount.setVisible(status);
        this.replenishAmount.setEnabled(status);
        this.setPriceConfirm.setVisible(status);
        this.setPriceConfirm.setEnabled(status);
        this.items.setVisible(status); 
        this.items.setEnabled(status); 
        
        
    }


    /**
     * sets the state for the maintenance feature item text field
     */
    public void itemMaintenanceState (boolean status){
        
        this.itemMaintenance.setEnabled(status);
        this.itemMaintenance.setVisible(status);

    }
    /**
     * sets the state for the text field to submit items in
     */
    public void itemSelectState (boolean status){
        this.itemSelect.setEnabled(status);
        this.itemSelect.setVisible(status);
    }
    /**
     * sets the status of the select item menu
     * @param status determines if they are visible/enabled or not (T/F) 
     */
    
    public void selectItemState (boolean status){

        this.chooseItemLabel.setVisible(status);
        this.itemListScrollPane.setVisible(status);
        this.itemSelect.setVisible(status);
        this.itemSelect.setEnabled(status);
        this.confirmItem.setVisible(status);
        this.confirmItem.setEnabled(status);
        this.moneyLabel.setVisible(status);

    }
    /**
     * sets the status for the display transaction list
     */

    public void transacDisplayState (boolean status){
        this.transacListArea.setVisible (status);
        this.transacListArea.setEnabled (status);
        this.endTransactionDisplay.setVisible(status);
        this.endTransactionDisplay.setEnabled(status);
    }
    /**
     * sets the status of the item list display
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void backButtonsState(boolean status){

        this.endChangeDisplay.setVisible(status);
        this.endChangeDisplay.setEnabled(status);
        this.endItemDisplay.setVisible(status);
        this.endItemDisplay.setEnabled(status);
        this.endTransactionDisplay.setVisible(status);
        this.endTransactionDisplay.setEnabled(status);

    }

    public void displaynewItemListState(boolean status){

        this.itemListScrollPane.setVisible(status);
        this.endItemDisplay.setVisible(status);
        this.endItemDisplay.setEnabled(status);

    }

    /**
     * sets the status of the new changelist display
     * @param status determines if they are visible/enabled or not (T/F) 
     */

    public void displaynewChangeListState(boolean status){

        this.changeListScrollPane.setVisible(status);
        this.endChangeDisplay.setVisible(status);
        this.endChangeDisplay.setEnabled(status);
        
    }

    public void specialVendItemSubmitState (boolean status){
        this.itemSelect.setVisible(status);
        this.itemSelect.setEnabled(status);
        this.itemListScrollPane.setVisible(status);
    }

    /**
     * sets the status of the buttons, drop down box, and display box for sinkers
     * @param status determines if they are visible/enabled or not (T/F) 
     */
    public void chooseSinkerState(boolean status){
        
        
        this.submitSinker.setVisible(status); 
        this.submitSinker.setEnabled(status); 
        

    }
    
    /**
     * sets the status of the buttons, drop down box, and display box for tea base
     * @param status determines if they are visible/enabled or not (T/F) 
     */
    public void chooseTeaBaseState(boolean status){
        
        this.submitTeaBase.setVisible(status); 
        this.submitTeaBase.setEnabled(status);
        this.itemSelect.setText(""); 

        // jtextfield
        
    
        
    }
    /**
     * sets the status of the buttons, drop down box, and display box for flavorings
     * @param status determines if they are visible/enabled or not (T/F) 
     */
    public void chooseFlavoringState(boolean status){


        this.submitFlavoring.setVisible(status); 
        this.submitFlavoring.setEnabled(status); 
        this.itemSelect.setText(""); 
         // jtextfield  
        this.itemListScrollPane.setVisible(status);

    }
    /**
     * sets the status of the buttons, drop down box, and display box for milk
     * @param status determines if they are visible/enabled or not (T/F) 
     */
    public void chooseMilkState(boolean status){

        this.submitMilk.setVisible(status); 
        this.submitMilk.setEnabled(status); 
        this.itemSelect.setText(""); 
        this.itemSelect.setVisible(status);
        this.itemSelect.setEnabled(status);
       // jtextfield
        this.itemListScrollPane.setVisible(status);

    }

    /**
     * sets the state for the customize product menu
     */
    public void customizeProductState(boolean status){
        
        
        this.custominsertcash.setEnabled(status); 
        this.custominsertcash.setVisible(status);
        this.cancelTransaction.setEnabled(status);
        this.cancelTransaction.setVisible(status);
        this.proceedTransaction.setEnabled(status);
        this.proceedTransaction.setVisible(status);
        this.customizedPrice.setVisible(status);
        this.customizedCalories.setVisible(status);
        
    }




    /**
     * gets the name written in the item submit textfield
     */
    public String getNameTF(){
        return this.iName.getText();
    }
    /**
     * gets the price written in the item submit textfield
     */
    public String getPriceTF(){
        return this.iPrice.getText();
    }
    /**
     * gets the quanitity written in the item submit textfield
     */
    public String getQuantityTF(){
        return this.iQuantity.getText();
    }
    /**
     * gets the calories written in the item submit textfield
     */
    public String getCaloriesTF(){
        return this.iCalories.getText();
    }
    
    /**
     * gets the amount to be replenished written in the textfield
     */
    public String getReplenishAmountTF(){ // unadded to UML

        return this.replenishAmount.getText();

    }


    /**
     * clears all the text fields in the submit item menus
     */
    public void clearItemTF (){
        
        this.iName.setText("");
        this.iPrice.setText("");
        this.iQuantity.setText("");
        this.iCalories.setText("");
        this.iCategory.setText("");
  

    }
    /**
     * sets the label for the amount of money inserted display
     */
    public void setMoneyLabel(String text){

        this.moneyLabel.setText(text);

    }
    /**
     * gets the written selected item name in the select item menu
     */

    public String getItemTF(){

        return this.itemSelect.getText();

    }

    public String getItemMaintenanceTF(){

        return this.itemMaintenance.getText();

    }
    
    public void updateItemsComboBox(String[] itemNames) {

        items.removeAllItems();

        for (String itemName : itemNames) {

            items.addItem(itemName);
        }

    }

    
    /**
     * gets the selected denomination value from the drop down menu
     */

    public String getDenominations(){
         
        String value = String.valueOf(this.denominations.getSelectedItem());
        
        return value;
        
    }
    /**
     * gets the selected category from the drop down menu
     */
    public String getCategoryDrop(){
         
        String value = String.valueOf(this.category.getSelectedItem());
        
        return value;
        
    }


    public String getItem(){
         
        String value = String.valueOf(this.items.getSelectedItem());
        
        return value;
        
    }

    /**
     * creates an option pane that says if an item has been dispensed or if transaction has failed
     * @param change is the amount of change returned
     * @param state determines if transaction was successful
     * @param itemName is the dispensed item
     */

    public void dispensePane(int change, boolean state, String itemName){
        if (state == true){
        JOptionPane.showMessageDialog(mainFrame, itemName +" Dispensed!\n Change: " + change);  
        }
        else if (state == false){
        JOptionPane.showMessageDialog(mainFrame,"There is not enough change inside the vending machine.\n Cancelling Transaction...\n Returned: " +change);
        }
    }
    /**
     * Shows a popup dialogue box when there is an error input
     */
    public void errorMessagePane(boolean result){
        if (result == false){
            JOptionPane.showMessageDialog(mainFrame, "Add Failed");
        }
    }
    /**
     * Shows a popup dialogue box when collecting payment from vending machine
     */
    public void collectPaymentPane (int total){
        if (total > 0){
            JOptionPane.showMessageDialog(mainFrame, "Collected P" +total);
        }
        else {
            JOptionPane.showMessageDialog(mainFrame, "There is no money in the vending machine yet.");
        }
    }
    public void cancelTransactionPane (int total){

        JOptionPane.showMessageDialog(mainFrame, "Transaction cancelled. \n" +total+ "Returned.");
        
    }
    /**
     * updates the display table that contains the item list
     * @param ItemList is an arraylist of Item
     */

    public void updateSpecialItemListTable(ArrayList <ArrayList<Item>> ItemList) {

        DefaultTableModel tableModel = (DefaultTableModel) itemListTable.getModel();

        
        Object[][] data = new Object[ItemList.size()][5];

        for (int i = 0; i < ItemList.size(); i++) {
        
        Item item = ItemList.get(i).get(0);
            

        int quantity = ItemList.get(i).size();
        data[i][0] = item.getName();
        data[i][1] = item.getPrice();
        data[i][2] = quantity;
        data[i][3] = item.getCalories();
        data[i][4] = item.getCategory();

        
    }


        tableModel.setDataVector(data, new String[]{"Item Name", "Price", "Quantity", "Calories", "Category"});

    }

        public void updateRegularItemListTable(ArrayList <ArrayList<Item>> ItemList) {

        DefaultTableModel tableModel = (DefaultTableModel) itemListTable.getModel();

        
        Object[][] data = new Object[ItemList.size()][4];

        for (int i = 0; i < ItemList.size(); i++) {
        
        Item item = ItemList.get(i).get(0);

        int quantity = ItemList.get(i).size();

        data[i][0] = item.getName();
        data[i][1] = item.getPrice();
        data[i][2] = quantity;
        data[i][3] = item.getCalories();

        
        
    }

    

        tableModel.setDataVector(data, new String[]{"Item Name", "Price", "Quantity", "Calories"});

    }


    /**
     * updates the display table holding the amount of change
     * @param changeList is an array of that has the amount of bills per given denomination
     * @param denomList is an array that states the denominations
     */
    

        public void updateChangeListTable(int [] changeList, int [] denomList) {

        DefaultTableModel tableModel = (DefaultTableModel) changeListTable.getModel();

    
        Object[][] data = new Object[changeList.length][2];

        for (int i = 0; i < changeList.length; i++) {

            data[i][0] = denomList[i];
            data[i][1] = changeList[i];


    }

        
        tableModel.setDataVector(data, new String[]{"Denomination", "Amount"});

    }


    /**
     * sets the text inside the transaction list display
     */
    public void setTransactionArea (String setText){
        this.transacListArea.setText(setText);
    }
    public void setCustomizedPrice (String text){
        this.customizedPrice.setText(text);
    }

    public void setCustomizedCalories (String text){

        this.customizedCalories.setText(text);

    }
    /**
     * dispenses for customized order
     */

    public void processDispensePane(String processes){
        
        
        System.out.println(processes);
        JOptionPane.showMessageDialog(mainFrame, processes);
        
    }

public static void main (String[] args) {   
    
    VendingMachineView newMachine = new VendingMachineView();
    VendingMachineModel newModel = new VendingMachineModel();

    VendingMachineController vController = new VendingMachineController(newMachine, newModel);
    
    
}

}
