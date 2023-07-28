/**
 * The class Item is a template for an item for the vending machine.
 * 
 * It has a constructor wherein it constructs the item based on its name, price, initial quantity, and calories.
 * 
 * 
 */

public class Item {
  
  private String name;
  private int price;
  private int quantity;
  private float calories;
  private int current_purchases = 0;
  private int total_purchases = 0;
  private String category;
  private String process;
  private boolean independence = true;
  
public Item(String name, int price, int quantity, float calories){

this.name = name;
this.price = price;
this.quantity = quantity;
this.calories = calories;

}

public Item(String name, int price, int quantity, float calories, String category, String process, boolean independence){

  this.name = name;
  this.price = price;
  this.quantity = quantity;
  this.calories = calories;
  this.category = category;
  this.process = process;
  this.independence = independence;
  
  }

/**
 * Gets the item's quantity
 * @return item quantity of int type
 */
public int getQuantity(){


  return quantity;
}

/**
 * Gets the item's name
 * @return name of String type
 */
public String getName(){

  return name;

}
/**
 * Gets the item's price
 * @return price of int type
 */
public int getPrice(){


  return price;

}
/**
 * Gets the item's calorie value
 * @return calories of float type
 */
public float getCalories(){


  return calories;

}
/**
 * increments the current and total purchases of an item whenever an item is bought
 * @param current_purchases is the amount of times an item is purchased in a session
 * @param total_purchases is the amount of times an item is purchased overall
 */
public void purchaseItem(){
  this.total_purchases++;       
  this.current_purchases++;
}
/**
 * sets a new value for current_purchases
 * @param newVal the new value that current_purchases will take
 */
public void setCurrentPurchases (int newVal){
  this.current_purchases = newVal;
}

/**
 * gets the current purchases of an item
 * @return current_purchases of int type
 */
public int getCurrentPurchases(){
  return current_purchases;
}

/**
 * gets the total purchases of an item
 * @return total_purchases of int type
 */
public int getTotalPurchases(){

  return total_purchases;

}

public String getCategory(){

  return category;

}


public String getProcess(){

  return process;
  
}

public boolean getIndependence(){

  return independence;
  
}

/**
 * sets a new value for quantity
 * @param quantity the new value quantity will take
 */

public void setQuantity(int quantity){

  this.quantity = quantity;

}
/**
 * sets a new value for price
 * @param price the new value price will take
 */

public void setPrice(int price){


  this.price = price;
  
}

}