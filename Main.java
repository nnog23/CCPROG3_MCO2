
import java.util.ArrayList;
import java.util.Scanner;

public class Main{

  public static void main (String[] args) {   
    
    VendingMachineView newMachine = new VendingMachineView();
    VendingMachineModel newModel = new VendingMachineModel();

    VendingMachineController vController = new VendingMachineController(newMachine, newModel);
    

    
}


}
