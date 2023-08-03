import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class contains the supporting methods that VendingMachineController uses
 */
public class VendingMachineModel{

// Regular Vending Machine Object

private RegularVendingMachine vendingMachine = null;

// Regular Vending Machine Attributes


private ArrayList <ArrayList<Item>> ItemList = new ArrayList <ArrayList<Item>>();
private Transaction TransactionList = new Transaction();
private int[] denomList = {1000,500,200,100,50,20,10,5,1}; // standard denominations
private int[] paymentList = {0,0,0,0,0,0,0,0,0}; // payment from customer
private int[] ownerPaymentList = {0,0,0,0,0,0,0,0,0}; // total payment array
private int[] changeList = {30,30,30,30,30,30,30,30,30}; // amount of change
private ArrayList <Integer> currentPurchase = new ArrayList<>();
private ArrayList <Integer> totalPurchase = new ArrayList<>();



// Special Vending Machine Attributes

private int nCategories = 4;  // Sinkers, Tea Base, Milk, Flavoring
private String[] CategoryList = {"Sinker", "Tea Base", "Milk", "Flavoring"};
private String[] ProcessList = {"Adding", "Brewing", "Pouring", "Mixing"};
private String Customizable_Item = "Milk Tea";
private ArrayList <Integer> ChosenItems = new ArrayList<>();

/**
 * A constructor to make an instance of VendingMachineModel
 */
public VendingMachineModel(){


/**
 * returns the array of bill denominations the owner would recieve from the machine
 * @return ownerPaymentList denonomination array
 */
}
public int[] getOwnerPaymentList(){
  return this.ownerPaymentList;
}
/**
 * gets and returns the itemlist
 * @return ItemList 2d array list of item
 */
public ArrayList <ArrayList<Item>> getItemList(){

  return ItemList;

}
/**
 * gets and returns the changelist
 * @return array of change denom
 */
public int[] getChangeList(){

  return changeList;

}
/**
 * gets and returns the paymentlist
 * @return array of payment denom
 */
public int[] getPaymentList(){

  return paymentList;

}
/**
 * gets and returns the denomination list
 * @return array of denominations
 */
public int[] getDenomList(){


  return denomList;

}
/**
 * gets the arraylist of chosen items for customized product
 * @return arraylist of chosen items
 */

public ArrayList <Integer> getChosenItems(){

  return ChosenItems;
  
}

/**
 * adds an item to the regular vending machine
 * @param item_name is the item's name
 * @param item_price is the price for it to be sold
 * @param item_quantity is how many instances of the item there would be
 * @param item_calories is its calorie value
 * @return true
 */
public boolean addRegItem(String item_name, int item_price, int item_quantity, float item_calories){
  
  ArrayList <Item> temp = new ArrayList<>();
  int i;  
  Item item = new Item(item_name, item_price, item_calories);
  
  for (i = 0; i < item_quantity; i++){
    temp.add(item);
   }

  this.currentPurchase.add(0);
  this.totalPurchase.add(0);
  ItemList.add(temp);
    return true;
  
  

 
//   The method add(String) in the type ArrayList<String> is not applicable for the arguments (Item)
// The method add(ArrayList<Item>) in the type ArrayList<ArrayList<Item>> is not applicable for the arguments (ArrayList<String>)
   

}
/**
 * adds an item to the special vending machine
 * @param item_name is the item's name
 * @param item_price is the price for it to be sold
 * @param item_quantity is how many instances of the item there would be
 * @param item_calories is its calorie value
 * @param item_category is the item's category
 * @param item_independence determines if the item is sellable in the regular vending machine
 */
public void addSpecItem(String item_name, int item_price, int item_quantity, float item_calories, String item_category){

    
  Item item = new Item(item_name, item_price, item_calories, item_category);
   
  ArrayList <Item> temp = new ArrayList<>();
  int i;  

   for (i = 0; i < item_quantity; i++){

    temp.add(item);

   }
  
  ItemList.add(temp);

  this.currentPurchase.add(0);
  this.totalPurchase.add(0);
   

}

/**
 * gets the array of currentPurchase, which holds the number of items purchased in a session
 * @return int arraylist of current purchases
 */
public ArrayList<Integer> getCurrentPurchases(){
  return this.currentPurchase;
}
/**
 * gets the array of totalPurchase, which holds the number of items purchased overall
 * @return arraylist of total purchase
 */
public ArrayList<Integer> getTotalPurchases(){
  return this.totalPurchase;
}
/**
 * sets an instance of Regular Vending Machine
 */

public void setRegularVendingMachine(){

  vendingMachine = new RegularVendingMachine();

}
/**
 * sets an instance of Special Vending Machine
 */
public void setSpecialVendingMachine(){

  vendingMachine = new SpecialVendingMachine();

}
/**
 * gets the RegularVendingMachine
 * @return instance of vending machine
 */
public RegularVendingMachine getVendingMachine(){


  return vendingMachine;

}
/**
 * sets the instance of a vending machine to null 
 */
public void setVendingMachineNull(){

  vendingMachine = null;

}


  /**
     * allows the admin to refill the amount of change inside the vending machine
     * @param denom is the denomination of the bill to be refilled
     * @param nAmount is the amount of bills
     * 
     */

public void replenishChange (int denom, int nAmount){

  int i = 0;

  while (i <= 8){

    if (denom == denomList[i]){

      changeList[i] += nAmount;

    }

    i++;

  }


}

/**
 * Replenishes the an item's quantity
 * @param select is the index to use to search for the item
 * @param amount is the amount of items to replenish
 * 
 */
public void replenishQuantity(String name, int amount){

  int i = 0;
  int j;

  while(i < ItemList.size()){
    
    if(name.equals(ItemList.get(i).get(0).getName())){

      Item item = ItemList.get(i).get(0);

      for(j = 0; j < amount; j++)
      ItemList.get(i).add(item);


    }

    i++;

  }


}
/**
 * sets the price for the items
 */
public void setItemPrice(String name, int price){ // unadded to UML

  int i = 0;
  int j = 0;

while(i < ItemList.size()){

if(name.equals(ItemList.get(i).get(0).getName())){
    for (j = 0; j < ItemList.get(i).size(); j++){
      ItemList.get(i).get(j).setPrice(price);
    }
  }

  i++;

}

}

/**
     * returns the summation of an array
     * @param value[] is the array to be summationed
     * @return total value inside int array
     */

    public int totalAmount (int[] value){

      int i, total = 0;
  
      for (i = 0; i < 9; i++){
  
        total = total + (value[i] * denomList[i]);
  
      }

      return total;
  
    }
    /**
     * verifies if the vending machine has enough change for the transaction
     * @param amount is the amount of money paid
     * @return t/f if enough change
     */


    public boolean verifyChange (int amount){
   
   
      int [] tempChange = new int[changeList.length];
   
      int tempAmount = amount;
      int i;
   
      for(i = 0; i <= 8; i++){
   
   
       tempChange[i] = changeList[i];
   
      }
   
      for (i = 0; i <=8; i++){
      while (tempAmount >= denomList[i] && tempChange[i] > 0){
         tempAmount -= denomList[i];
         tempChange[i] --;
         }
      }
       if (tempAmount == 0){
         return true;
       }
       else 
   
         return false; 
         
     }

     /**
     * returns the payment the user has inputted if the transaction is cancelled
     * @param paymentList[] is the array of the payment from the customer
     * @return original amount inserted
     */

  public int cancelTransaction (int [] paymentList){

    int nTotal = 0;
    int i;

    nTotal = totalAmount (paymentList);

    for (i = 0; i < 9; i++){
          
      this.paymentList[i] = 0;

    }

    return nTotal;
    
  }


  
/**
 * Dispenses an item from the vending machine, removes the last instance of the ItemList 
 * @param select is the index used to search for the chosen item within the ItemList ArrayList
 */

public void dispenseItem(int select){

  // remove the last instance of the itemlist array of a certain item
  
  int i;

  
  ItemList.get(select).remove(ItemList.size() - 1);
  
  Integer value = this.currentPurchase.get(select);
  Integer value2 = this.totalPurchase.get(select);
  value = value + 1;
  value2 = value2 + 1;
  
  this.currentPurchase.set(select, value);
  this.totalPurchase.set(select, value2);

  System.out.println(currentPurchase.get(select));

  for (i = 0; i <= 8; i++){
      
      ownerPaymentList[i] = paymentList[i];

    }
  for (i = 0; i <= 8; i++){
      
      paymentList[i] = 0;

    }
    
  
}

/**
 * takes a bill and puts it in the current payment array corresponding to its denomination
 * @param payment is the inserted bill
 */
public void insertCash(int payment){

  int i = 0;
  
  while (i <= 8){

    if (payment == denomList[i]){
      
      paymentList[i] += 1;

  }

  i++;

}

}


  /**
     * returns the denomination array of change that the user will get after buying
     * @param amount is the change amount
     * @return an array of denom for change
     */

     public int[] produceChange (int amount){

      int[] changeDenom = {0, 0, 0, 0, 0, 0, 0, 0, 0};
   
      int i;
     //amount = 20
      for (i = 0; i < 9; i++){
      // 20 >= 20 && num 20 > 0
      while (amount >= denomList[i] && changeList[i] > 0){
   
         System.out.println("Amount: " + amount);
         
         amount -= denomList[i];
   
         changeList[i]--;
         changeDenom[i]++;

   
         }
   
         
   
      }
   
       return changeDenom;
   
   
   }

   
/**
 * stores the paymentList array to the ownerPaymentList array
 * @param paymentList is an array of bills that the customer inserted in the vending machine.
 */

public void storePayment(int[] paymentList){

  int i;
  
  for(i = 0; i < 9; i++){
  
    ownerPaymentList[i] += paymentList[i];
  
    paymentList[i] = 0;
  
  }

  }
  
  /**
   * gets the list of item names
   * @param ItemList is the adjacency list of items
   * @return an array of items
   */
  public String[] getItemNames(ArrayList <ArrayList<Item>> ItemList){

    int i;

    String[] items = new String[ItemList.size()];

    for(i = 0; i < ItemList.size(); i++){

      items[i] = ItemList.get(i).get(0).getName();

    }

    return items;

  }

 /**
  * gets the transaction list
  * @return an instance of transaction
  */
  public Transaction getTransactionList(){
    
    return this.TransactionList;

  }

/**
 * dispenses the Customized product
 * @return an array of strings with the processing commands
 */
  public String dispenseCustomizedProduct(){

    //String[] processes = new String[ChosenItems.size()];

    int i;
    int j;
    String processes = "";
    
    for(i = 0; i < ChosenItems.size(); i++){ // arraylist of chosen item integers

          System.out.println("ChosenItems: " + ChosenItems);
          System.out.println("ItemList: " + ItemList);

          if(ItemList.get(ChosenItems.get(i)).get(0).getCategory().equals("Sinker")){

            processes += "Adding " + ItemList.get(ChosenItems.get(i)).get(0).getName() + "...\n";
           
            Integer value = this.totalPurchase.get(ChosenItems.get(i)); 
            value = value + 1;
            this.totalPurchase.set(ChosenItems.get(i), value);

          }else if(ItemList.get(ChosenItems.get(i)).get(0).getCategory().equals("Tea Base")){

            processes += "Brewing " + ItemList.get(ChosenItems.get(i)).get(0).getName() + "...\n";
          
            Integer value = this.totalPurchase.get(ChosenItems.get(i)); 
            value = value + 1;
            this.totalPurchase.set(ChosenItems.get(i), value);
            
          }else if(ItemList.get(ChosenItems.get(i)).get(0).getCategory().equals("Flavoring")){
            processes += "Mixing " + ItemList.get(ChosenItems.get(i)).get(0).getName() + "...\n";
            //processes[i] += "Mixing... " + ChosenItems.get(i);
            
            Integer value = this.totalPurchase.get(ChosenItems.get(i)); 
            value = value + 1;
            this.totalPurchase.set(ChosenItems.get(i), value);

          }else if((ItemList.get(ChosenItems.get(i)).get(0).getCategory().equals("Milk"))){
            processes += "Pouring " + ItemList.get(ChosenItems.get(i)).get(0).getName() + "...\n";
            //processes[i] += "Pouring... " + ChosenItems.get(i);
     
            Integer value = this.totalPurchase.get(ChosenItems.get(i)); 
            value = value + 1;
            this.totalPurchase.set(ChosenItems.get(i), value);


          }

          System.out.println(this.totalPurchase);

          ItemList.get(ChosenItems.get(i)).remove(ItemList.get(ChosenItems.get(i)).size() - 1);

          // j = ItemList.size() - 1

    }

    return processes;

  }

  /**
   * computes and returns the total calories of the customized product
   * @param ChosenItems is an arraylist of the chosen items for customization
   * @return total calories
   */
  public float computeCalories(ArrayList<Integer> ChosenItems){

 

    int i;
    float calories = 0;
    
    for(i = 0; i < ChosenItems.size(); i++){
      
         calories += ItemList.get(ChosenItems.get(i)).get(0).getCalories();

    }
  
    return calories;
  
  }
  
  /**
   * computes and returns the total price of the customized item
   * @param ChosenItems is the arraylist of items chosen during customization
   * @return total price
   */
    public int computePrice(ArrayList<Integer> ChosenItems){

    int i;
    int price = 0;
    
    for(i = 0; i < ChosenItems.size(); i++){
      
         price += ItemList.get(ChosenItems.get(i)).get(0).getPrice();

    }
  
    return price;
  
  
  }

/**
 * collects and totals the money stored in the vending machine and returns a whole value
 * @param ownerpaymentlist is the array of denominations
 * @return an array for total denom amount
 */
  public int collectPayment(int [] ownerpaymentList){
  
    int i;
  
    int total_payment = totalAmount(ownerpaymentList);
  
    for (i = 0; i <= 8; i++){
  
      ownerpaymentList[i] = 0;
  
    }
  
    return total_payment;
  
  }



  

}
