import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendingMachineController {

    private VendingMachineView VendingView;
    private VendingMachineModel VendingModel;
    private boolean isVendingMachineCreated = false;

    private int x = 0;
    public VendingMachineController (VendingMachineView VendingView, VendingMachineModel VendingModel){

        this.VendingView = VendingView;
        this.VendingModel = VendingModel;

    this.VendingView.setRegVendBtnListener(new ActionListener(){
        @Override
        public void actionPerformed (ActionEvent e){

          
        if(!isVendingMachineCreated){

           VendingView.FirstMenuStatus(false);
           VendingView.RegularItemCreate(true);
           
        }else{



        }
           

        }


    });

    this.VendingView.setSpecVendBtnListener(new ActionListener(){
        @Override
        public void actionPerformed (ActionEvent e){


        if(!isVendingMachineCreated){
           
           VendingView.FirstMenuStatus(false);
           VendingView.SpecialItemCreate(true);

        }else{

            
        }

        }


    });

     this.VendingView.setRegSubmitListener(new ActionListener() {
        @Override
        public void actionPerformed (ActionEvent a){

            // do while VendingMachineModel.getItemList().size() < 8

            VendingView.Done(false);

            String name = VendingView.getNameTF();
            int price = VendingView.getPriceTF();
            int quantity = VendingView.getQuantityTF();
            float calories = VendingView.getCaloriesTF();


            
            //make temporary class with Jlabels and pass parameters to test if data stores
            // call vending model for addItems(paramters) called by Add Item button

            VendingView.clearItemTF();

            VendingModel.addRegItem(name, price, quantity, calories);
           
            if(VendingModel.getItemList().size() >= 8){

            VendingView.Done(true); // only available if >= 8  items

            }

        }
    });
    

    this.VendingView.setSpecSubmitListener(new ActionListener() {
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
            
            VendingView.SpecSubmit(false); // only available if >= 8  items

        }
    });



    }
}

