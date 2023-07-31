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
           VendingView.setLabel("Changed");
        }


    });
    }
}
