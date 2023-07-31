import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JTextField;
import javax.swing.JButton;
//import javax.swing.JTextArea;
import javax.swing.JPanel;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendingMachineView{
    private JFrame mainFrame;
	private JLabel idLbl, nameLbl, feedbackLbl;
	//private JTextField idTf, nameTf;
	private JButton RegVend, SpecVend;
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
        this.mainFrame.pack();

    }
    public void setAddBtnListener(ActionListener actionListener) {
		this.RegVend.addActionListener(actionListener);
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



public static void main (String[] args) {
    VendingMachineView newMachine = new VendingMachineView();

    VendingMachineController vController = new VendingMachineController(newMachine);
}

}