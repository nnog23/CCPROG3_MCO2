import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendingMachineView{
    private JFrame mainFrame;
	private JLabel nameLbl, Items, ilName, ilPrice, ilQuantity, ilCalories, ilCategory;
	private JTextField iName, iPrice, iQuantity, iCalories, iCategory;
	private JButton RegVend, SpecVend, itemSubmit;
	//private JTextArea employeeListTextArea;

    public VendingMachineView(){
        this.mainFrame = new JFrame ("Vending Display");
		this.mainFrame.setSize(500,500);
        this.mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        mainFrame.setVisible(true);

        this.nameLbl = new JLabel("Choose a Vending Machine: ");
        nameLbl.setPreferredSize(new Dimension(100,100));
        panel.add(this.nameLbl);
        RegVend = new JButton ("Create a Regular Vending Machine");
        SpecVend = new JButton ("Create a Special Vending Machine");
        RegVend.setBounds(10, 10, 75, 75);
        SpecVend.setBounds(10, 10, 75, 75);
        
        this.mainFrame.add(panel);
        this.mainFrame.add(RegVend);
        this.mainFrame.add(SpecVend);
        

        //CREATE ITEMS PART
        this.Items = new JLabel("Create Items");
        this.ilName = new JLabel("Name: ");
        this.ilPrice = new JLabel("Price: ");
        this.ilQuantity = new JLabel("Quantity: ");
        this.ilCalories = new JLabel("Calories: ");
        this.ilCategory = new JLabel("Category: ");
        this.mainFrame.add(Items);
        this.mainFrame.add(ilName);
        
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

        this.mainFrame.add(iName);
        this.mainFrame.add(ilPrice);
        this.mainFrame.add(iPrice);
        this.mainFrame.add(ilQuantity);
        this.mainFrame.add(iQuantity);
        this.mainFrame.add(ilCalories);
        this.mainFrame.add(iCalories);
        this.mainFrame.add(ilCategory);
        this.mainFrame.add(iCategory);

        this.iName.setVisible(false);
        this.iName.setEnabled(false);
        this.iPrice.setVisible(false);
        this.iPrice.setEnabled(false);
        this.iQuantity.setVisible(false);
        this.iQuantity.setEnabled(false);
        this.iCalories.setVisible(false);
        this.iCalories.setEnabled(false);
        this.iCategory.setVisible(false);
        this.iCategory.setEnabled(false);

        itemSubmit = new JButton("Submit");
        itemSubmit.setBounds(10, 10, 60, 60);
        this.itemSubmit.setEnabled(false);
        this.itemSubmit.setVisible(false);
        this.mainFrame.add(itemSubmit);
        //create "Add Item" button
        // VENDING MENUS
    
        this.mainFrame.pack();
        
    }
    public void setAddBtnListener(ActionListener actionListener) {
		this.RegVend.addActionListener(actionListener);
        this.SpecVend.addActionListener(actionListener);
        
	}
    public void itemSubmitListener(ActionListener actionListener) {
		this.itemSubmit.addActionListener(actionListener);//change itemSubmit to AddItem button
        
        
	}
    //create actionlistener for submitting items; only available if >=8 items

    public void FirstMenuStatus (boolean status){
        this.RegVend.setEnabled(status);
        this.RegVend.setVisible(status);
        this.SpecVend.setEnabled(status);
        this.SpecVend.setVisible(status);
        this.nameLbl.setVisible(status);
    }

    public void ItemCreate(boolean status){
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
        this.iCategory.setVisible(status);
        this.iCategory.setEnabled(status);
        this.itemSubmit.setEnabled(status);
        this.itemSubmit.setVisible(status);
    }
    public String getLabel(){
        return this.nameLbl;
    }
    public void setLabel (String text){
        this.nameLbl.setText(text);
    }

	public void setViewBtnListener(ActionListener actionListener) {
		this.viewBtn.addActionListener(actionListener);
	}
    public String getNameTF(){
        return this.ilName.getText();
    }
    public int getPriceTF(){
        return this.ilPrice.getText();
    }
    public int getQuantityTF(){
        return this.ilQuantity.getText();
    }
    public float getCaloriesTF(){
        return this.ilCalories.getText();
    }
    public String getCategoryTF(){
        return this.ilCategory.getText();
    }
    public void clearItemTF (){
        this.ilName.setText("");
        this.ilPrice.setText("");
        this.ilQuantity.setText("");
        this.ilCalories.setText("");
        this.ilCategory.setText("");
    }

    

public static void main (String[] args) {
    
    VendingMachineView newMachine = new VendingMachineView();

    VendingMachineController vController = new VendingMachineController(newMachine);

}

}
