import java.util.Scanner;
import java.util.ArrayList;

/**
 * The class RegularVendingMachine is a blueprint for a Regular Vending Machine. 
 * 
 * It has a constructor, wherein it constructs the Regular Vending Machine by initializing the first 8 items.
 * The other attributes are initialized.
 * 
 */

public class RegularVendingMachine{

protected ArrayList <Item> ItemList = new ArrayList<>();

protected Transaction TransactionList = new Transaction(ItemList);
protected int[] denomList = {1000,500,200,100,50,20,10,5,1}; // standard denominations
protected int[] paymentList = {0,0,0,0,0,0,0,0,0}; // payment from customer
protected int[] ownerPaymentList = {0,0,0,0,0,0,0,0,0}; // total payment array
protected int[] changeList = {10,10,10,10,10,10,10,10,10}; // amount of change

public RegularVendingMachine(){



}

/**
 * Displays the denomination of change and the amount of bills left per denomination
 */

protected void initializeItems(){

  Scanner sc = new Scanner(System.in);

    int i;
    String item_name;
    int item_price = 0;
    int item_quantity = 0;
    float item_calories = 0;

    System.out.println("Please create at least 8 items for the vending machine");

    for(i = 0; i < 2; i++){ 
      
     System.out.println("Create name for no. " + (i+1) + " item: ");
     
     item_name = sc.nextLine(); 
     
     System.out.println("Price of " + item_name + ": ");

     item_price = sc.nextInt();

      do{

      System.out.println("Initial quantity of " + item_name + ": ");
    
      item_quantity = sc.nextInt();

      if(item_quantity < 10){

        System.out.println("Quantity of an item should at least be 10.");
        
      }

      }while(item_quantity < 10);

     System.out.println("Number of calories of " + item_name + ": ");

     item_calories = sc.nextFloat();

     
     sc.nextLine(); // gets enter character
     
     Item item = new Item(item_name, item_price, item_quantity, item_calories);
     
     ItemList.add(item);



    }

}

public void displayChangeList(){


  int i;

    System.out.println("\nAmount of Change Left:\n");
    System.out.println("+--------------+--------+");
    System.out.println("| Denomination | Amount |");
    System.out.println("+--------------+--------+");


  for(i = 0; i <= 8; i++){


    System.out.printf("| %12s | %6s |\n", denomList[i], changeList[i]);
    
    System.out.println("+--------------+--------+");

  }
  
    System.out.println("");

}


/**
 * Displays the list of items, their price, quantity, and calories
 */

public void displayItemList() {
    int i;

    System.out.println("Item List:\n");
    
    System.out.println("+------+-----------------------+--------+----------+---------+");
    System.out.println("| No.  |      Item Name        | Price  | Quantity | Calories|");
    System.out.println("+------+-----------------------+--------+----------+---------+");

    for (i = 0; i < ItemList.size(); i++) {
        System.out.printf("| %-4d | %-21s | P%-5d | %8d | %7.2f |\n", i + 1, ItemList.get(i).getName(), ItemList.get(i).getPrice(), ItemList.get(i).getQuantity(), ItemList.get(i).getCalories());
        System.out.println("+------+-----------------------+--------+----------+---------+");
    }

    System.out.println();
}
/**
 * Displays item list for the customer which indicates the item name, price, quantity, calories, and the inserted cash.
 */
public void displayItemListForCustomer() {

    int i;

    System.out.println();
    System.out.println("+------------------------------------------------------------+");
    System.out.println("|                      [VENDING MACHINE]                     |");
    System.out.println("+------+-----------------------+--------+----------+---------+");
    System.out.println("| No.  |      Item Name        | Price  | Quantity | Calories|");
    System.out.println("+------+-----------------------+--------+----------+---------+");

    for (i = 0; i < ItemList.size(); i++) {

        if(ItemList.get(i).getIndependence() == true){
        System.out.printf("| %-4d | %-21s | P%-5d | %8d | %7.2f |\n", i + 1, ItemList.get(i).getName(), ItemList.get(i).getPrice(), ItemList.get(i).getQuantity(), ItemList.get(i).getCalories());
        System.out.println("+------+-----------------------+--------+----------+---------+");
        }
        
    }

    System.out.println("\nInserted Cash: P" + totalAmount(paymentList) + "\n\n");

}

/**
 * Replenishes the an item's quantity
 * @param select is the index to use to search for the item
 * @param amount is the amount of items to replenish
 * 
 */
public void replenishQuantity(int select, int amount){

    int currentQuantity = ItemList.get(select).getQuantity();

    ItemList.get(select).setQuantity(currentQuantity + amount); 


}
/**
 * Adds a new item to the ItemList arrayList
 */
public void addItem(){

  Scanner sc = new Scanner(System.in);

  String item_name;
  int item_price = 0;
  int item_quantity = 0;
  float item_calories = 0;

     System.out.println("Create name for no. " + (ItemList.size() + 1) + " item: ");
     
      item_name = sc.nextLine(); 
     
     System.out.println("Price of " + item_name + ": ");

      item_price = sc.nextInt();

      do{

      System.out.println("Initial of quantity of " + item_name + ": ");
    
      item_quantity = sc.nextInt();
      
      if(item_quantity < 10){

        System.out.println("Quantity of an item should at least be 10.");
        
      }

      }while(item_quantity < 10);

     System.out.println("Number of calories of " + item_name + ": ");

     item_calories = sc.nextFloat();

     
     sc.nextLine(); // gets enter character
     
     Item item = new Item(item_name, item_price, item_quantity, item_calories);
     
     ItemList.add(item);

     



}

/**
 * Dispenses an item from the vending machine
 * @param select is the index used to search for the chosen item within the ItemList ArrayList
 */

public void dispenseItem(int select){

  int i;

  System.out.println(ItemList.get(select - 1).getName() + " dropped from the vending machine."); 

  ItemList.get(select - 1).setQuantity(ItemList.get(select - 1).getQuantity() - 1); // quantity - 1

  ItemList.get(select - 1).purchaseItem();
  
      for (i = 0; i < 8; i++){
          
      paymentList[i] = 0;

    }

}


  
  /**
     * increments to the paymentList at the index of the chosen bill type
     * @param payment is the bill the user has put into the vending machine 
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
     * returns the summation of an array
     * @param value[] is the array to be summationed
     */
  public int totalAmount (int[] value){

    int i, total = 0;

    for (i = 0; i < 9; i++){

      total = total + (value[i] * denomList[i]);

    }

    return total;

  }

  /**
     * returns the payment the user has inputted if the transaction is cancelled
     * @param paymentList[] is the array of the payment from the customer
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
     * verifies if the vending machine has the appropriate amount of change
     * returns true if yes, false if not
     * @param amount is the change amount
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
     * retuns the denomination array of change that the user will get after buying
     * @param amount is the change amount
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
      System.out.println("\n\nAmount of change left array:");
      System.out.println("Denomination: " + denomList[i] + "Amount:" + changeList[i]);

      changeDenom[i]++;
      System.out.println("\n\nAmount of change produced array:");
      System.out.println("Denomination: " + denomList[i] + "Amount:" + changeDenom[i]);

      }

      

   }

    return changeDenom;


}
  /**
     * allows the admin to refill the amount of change inside the vending machine
     * @param denom is the denomination of the bill to be refilled
     */

public void replenishChange (int denom){

  int i = 0, nAmount;

  Scanner sc = new Scanner (System.in);

  while (i <= 8){

    if (denom == denomList[i]){

      System.out.println ("Please input the amount of bills");

      nAmount = sc.nextInt();

      changeList[i] += nAmount;

    }

    i++;

  }


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

public int collectPayment(int [] ownerpaymentList){
  
  int i;

  int total_payment = totalAmount(ownerpaymentList);

  for (i = 0; i < 8; i++){

    ownerpaymentList[i] = 0;

  }

  return total_payment;

}

/**
 * Gets the ItemList array
 * @return ItemList of Item ArrayList type
 */

public ArrayList<Item> getItemList(){

  return ItemList;

}

  /**
     * gets the paymentAmount array
     */

  public int[] getPaymentList(){

    return paymentList;

  }

  /**
     * gets the changeAmount array
     */

  public int[] getChangeList(){

    return changeList;

  }

  /**
     * gets the denomination array
     */
  public int[] getDenomList(){


    return denomList;

  }

  /**
   *  gets the owner payment array
   */
  public int[] getOwnerPaymentList(){
    

    return ownerPaymentList;
    
  }

  /**
   *  gets the transaction
   */

  public Transaction getTransactionList(){


        return TransactionList;
        
   } 
  
}
