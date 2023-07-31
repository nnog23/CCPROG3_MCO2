import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendingMachineController {

    private VendingMachineView VendingView;
    private int x = 0;
    public VendingMachineController (VendingMachineView VendingView){
        this.VendingView = VendingView;
    

    this.VendingView.setAddBtnListener(new ActionListener(){
        @Override
        public void actionPerformed (ActionEvent e){
           VendingView.FirstMenuStatus(false);
           VendingView.ItemCreate(true);
        }


    });

    this.VendingView.itemSubmitListener(new ActionListener() {
        @Override
        public void actionPerformed (ActionEvent a){
            String name = VendingView.getNameTF();
            int price = VendingView.getPriceTF();
            int quantity = VendingView.getQuantityTF();
            float calories = VendingView.getCaloriesTF();
            String category = VendingView.getCategoryTF();

            
            //make temporary class with Jlabels and pass parameters to test if data stores
            // call vending model for addItems(paramters) called by Add Item button
            VendingView.clearItemTF();
            
            VendingView.ItemCreate(false); // only available if >= 8  items
        }
    });
    }
}

