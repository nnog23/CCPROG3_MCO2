import java.util.ArrayList;

public class VendingMachineModel{

// Regular Vending Machine Attributes


private ArrayList <Item> ItemList = new ArrayList<>();
private Transaction TransactionList = new Transaction(ItemList);
private int[] denomList = {1000,500,200,100,50,20,10,5,1}; // standard denominations
private int[] paymentList = {0,0,0,0,0,0,0,0,0}; // payment from customer
private int[] ownerPaymentList = {0,0,0,0,0,0,0,0,0}; // total payment array
private int[] changeList = {10,10,10,10,10,10,10,10,10}; // amount of change


// Special Vending Machine Attributes

private int nCategories = 4;  // Sinkers, Tea Base, Milk, Flavoring
private String[] CategoryList = {"Sinkers", "Tea Base", "Milk", "Flavoring"};
private String[] ProcessList = {"Adding", "Brewing", "Pouring", "Mixing"};
private int[] Max = {3, 1, 1, 1};
private String Customizable_Item = "Milk Tea";

public VendingMachineModel(){



}


public ArrayList<Item> getItemList(){

  return ItemList;

}

public void addRegItem(String item_name, int item_price, int item_quantity, float item_calories){

     
  Item item = new Item(item_name, item_price, item_quantity, item_calories);
   
  ItemList.add(item);

   

}

public void addSpecItem(String item_name, int item_price, int item_quantity, float item_calories, String item_category, String item_process, boolean item_independence){

    
  Item item = new Item(item_name, item_price, item_quantity, item_calories, item_category, item_process, item_independence);
   
  ItemList.add(item);

   

}

public boolean getIsVendingMachineCreated(){


  return isVendingMachineCreated;

}

}
