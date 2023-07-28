import java.util.ArrayList;
import java.util.Scanner;

public class SpecialVendingMachine extends RegularVendingMachine{

private int nCategories;
private String[] CategoryList;
private String[] ProcessList;
private int[] Max;
private String Customizable_Item;

public SpecialVendingMachine(){


}


@Override
protected void initializeItems(){

Scanner sc = new Scanner(System.in);

  int i;
  int j;
  int k;
  int input_category;
  int input_independence = 0;
  int nCategories;
  String item_name;
  int item_price;
  int item_quantity;
  float item_calories;
  String item_process;
  String item_category;
  boolean item_independence;

  System.out.println("\nWhat is the name of the customizable product?");

  Customizable_Item = sc.nextLine();

  System.out.println("\nHow many categories are there in the special vending machine?");

  nCategories = sc.nextInt();
  sc.nextLine();

  CategoryList = new String[nCategories];
  ProcessList = new String[nCategories];
  Max = new int[nCategories];

  System.out.println("Give the name and process message for each of the " + nCategories + " categories:\n");

  for(i = 0; i < nCategories; i++){

    System.out.println("\nCreate name for no. " + (i + 1) + " category: \n");
    CategoryList[i] = sc.nextLine();
    System.out.println("\nCreate process message for no. " + (i + 1) + " category: \n");
    ProcessList[i] = sc.nextLine();
    System.out.println("\nHow many of the category " + "can you put into a customizable " + Customizable_Item + "?");
    Max[i] = sc.nextInt();
    sc.nextLine();

  }

  System.out.println("\nCreate at least 8 items for your special vending machine:\n");

  for(j = 0; j < 2; j++){
  
  System.out.println("Create name for no. " + (ItemList.size() + 1) + " item: ");
     
     item_name = sc.nextLine(); 
     
     System.out.println("Price of " + item_name + ": ");

     item_price = sc.nextInt();
     sc.nextLine(); 

      do{

      System.out.println("Initial quantity of " + item_name + ": ");
    
      item_quantity = sc.nextInt();
      sc.nextLine(); 

      if(item_quantity < 10){

        System.out.println("Quantity of an item should at least be 10.");
        
      }

      }while(item_quantity < 10);

     System.out.println("Number of calories of " + item_name + ": ");

     item_calories = sc.nextFloat();
     sc.nextLine(); 

     System.out.println("What is the category for this item?");

     do{

     for(k = 0; k < nCategories; k++){

      System.out.println("[" + (k + 1) + "] " + CategoryList[k]);

     }

     input_category = sc.nextInt();
     sc.nextLine();

    }while(input_category < 1 || input_category > nCategories);
     
    item_category = CategoryList[input_category-1];
    item_process = ProcessList[input_category-1];

    do{

    System.out.println("Can this item be sold on its own?");
    System.out.println("[1] Yes");
    System.out.println("[2] No");

    input_independence = sc.nextInt();
    sc.nextLine();

    }while(input_independence != 1 && input_independence != 2);

    if(input_independence == 1){

      item_independence = true;

    }else{

      item_independence = false;

    }
     
     Item item = new Item(item_name, item_price, item_quantity, item_calories, item_category, item_process, item_independence);
     
     ItemList.add(item);
    
  }

 


}



public float computeCalories(ArrayList<Integer> ChosenItems){

 

  int i;
  float calories = 0;
  

  for(i = 0; i < ChosenItems.size(); i++){

   calories += ItemList.get(ChosenItems.get(i)).getCalories();

  }

  return calories;

}


public int computePrice(ArrayList<Integer> ChosenItems){

int i;
int price = 0;

for(i = 0; i < ChosenItems.size(); i++){

price += ItemList.get(ChosenItems.get(i)).getPrice();

}

return price;

}


public void dispenseCustomizedProduct(ArrayList <Integer> ChosenItems){

  int i;

  System.out.println(Customizable_Item + " dropped from the vending machine."); 

  for(i = 0; i < ChosenItems.size(); i++){

  ItemList.get(ChosenItems.get(i)).setQuantity(ItemList.get(ChosenItems.get(i)).getQuantity() - 1);

  ItemList.get(ChosenItems.get(i)).purchaseItem();

  }
  
    for (i = 0; i < 9; i++){
          
      paymentList[i] = 0;

    }

}


public ArrayList<Integer> customizeProduct(){

Scanner sc = new Scanner(System.in);
int i;
int j;
int input;
int ctr;
ArrayList <Integer> ChosenItems = new ArrayList<>();

System.out.println("Customize your own " + Customizable_Item);

for(i = 0; i < CategoryList.length; i++){

System.out.println("Choose your " + CategoryList[i]);

if(Max[i] > 1){

  System.out.println("You may choose up to " + Max[i] + " " + CategoryList[i] + "s\n\n");

}

    System.out.println();
    System.out.println("+------------------------------------------------------------+");
    System.out.println("|                      [VENDING MACHINE]                     |");
    System.out.println("+------+-----------------------+--------+----------+---------+");
    System.out.println("| No.  |      Item Name        | Price  | Quantity | Calories|");
    System.out.println("+------+-----------------------+--------+----------+---------+");

for(j = 0; j < ItemList.size(); j++){

if(ItemList.get(j).getCategory().equals(CategoryList[i])){

    System.out.printf("| %-4d | %-21s | P%-5d | %8d | %7.2f |\n", j + 1, ItemList.get(j).getName(), ItemList.get(j).getPrice(), ItemList.get(j).getQuantity(), ItemList.get(j).getCalories());
    System.out.println("+------+-----------------------+--------+----------+---------+");

    }

  }

    ctr = 0;

    do{

    System.out.println("Enter your choice:");

    input = sc.nextInt();
   

    ChosenItems.add(input - 1);
    
    ctr += 1;

    if(ctr < Max[i]){

      do{
        
      System.out.println("Do you still want to add more " + CategoryList[i] + "s?");
      System.out.println("You may still add " + (Max[i]-ctr) + " " + CategoryList[i] + "s");
      System.out.println("[1] Yes");
      System.out.println("[2] No");

      input = sc.nextInt();
     

      }while(input != 1 && input != 2);

      if(input == 1){

            System.out.println();
            System.out.println("+------------------------------------------------------------+");
            System.out.println("|                      [VENDING MACHINE]                     |");
            System.out.println("+------+-----------------------+--------+----------+---------+");
            System.out.println("| No.  |      Item Name        | Price  | Quantity | Calories|");
            System.out.println("+------+-----------------------+--------+----------+---------+");

        for(j = 0; j < ItemList.size(); j++){

        if(ItemList.get(j).getCategory().equals(CategoryList[i])){

            System.out.printf("| %-4d | %-21s | P%-5d | %8d | %7.2f |\n", j + 1, ItemList.get(j).getName(), ItemList.get(j).getPrice(), ItemList.get(j).getQuantity(), ItemList.get(j).getCalories());
            System.out.println("+------+-----------------------+--------+----------+---------+");

    }

  

  }

      }else if(input == 2){

        ctr = Max[i];

      }


    }


    

    }while(Max[i] > 1 && ctr < Max[i]);


}

return ChosenItems;

}


public String[] getCategoryList(){

  return CategoryList;

}

public String[] getProcessList(){

  return ProcessList;
  
}

public int[] getMax(){

  return Max;
  
}

public String getCustomizableItem(){

  return Customizable_Item;
  
}

public int getnCategories(){


  return nCategories;

}
public void setCategory(int index, String category) {

  CategoryList[index] = category;

}

public void setProcess(int index, String process) {

  ProcessList[index] = process;

}

public void setMax(int index, int max) {

  Max[index] = max;

}

public void setCategoryList(int length) {

  CategoryList = new String[length];

}

public void setProcessList(int length) {

  ProcessList = new String[length];

}

public void setMaxList(int length) {

  Max = new int[length];

}



public void setCustomizableItem(String item){
  
  Customizable_Item = item;

}

}





/*
 
Features:

Create categories for items:

Ex:

Sinkers: 

1. Tapioca [cannot be sold on its own]

2. Boba  [cannot be sold on its own]

3. Red Bean  [cannot be sold on its own]
 
4. Pudding  [cannot be sold on its own]

5. Nata de coco  [cannot be sold on its own]

6. Grass Jelly  [cannot be sold on its own]

Tea:

1. Black tea  [items that can be sold individually] (may be hot or cold)

2. Loose leaf black tea [items that can be sold individually] (may be hot or cold)

3. Wintermelon tea [items that can be sold individually] (may be hot or cold)

4. Green tea [items that can be sold individually] (may be hot or cold)


Flavorings:

Okinawa [cannot be sold on its own]

Wintermelon [cannot be sold on its own]

Matcha [cannot be sold on its own]

Thai [cannot be sold on its own]

Milk:

1. Whole Milk

2. Oat milk

3. Almond milk

4. Skim milk

5. Hokkaido milk

6. Soy milk

7. Organic milk

8. Coconut milk

Customizable Product:

CUSTOMIZE YOUR OWN MILK TEA:

Choose flavor for your milk tea:

Choose tea for your milk tea:

Choose milk for your milk tea:

Choose sinker/s for your milk tea:




The machine can prepare a selected product based on (a) the items that are stored in the machine and (b) the choices of the items for the product that the user wants.


Creation of Special Vending Machine:

What is the customizable product for the vending machine?

How many categories are there for the "customizable product" vending machine? (Array of categories (item categories))



Items:

What is the name of the item?

what is the price of this item?

How many calories are there in this item?

What is the category of this item?

What is the process of this item?

Can this item be sold on its own?




 */