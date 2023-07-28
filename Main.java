
import java.util.ArrayList;
import java.util.Scanner;

public class Main{


  public static void main (String[] args){

  Scanner sc = new Scanner(System.in);

  int mainOption = 0, subOption = 0, vendingOption = 0, maintenanceOption = 0, chosenItem = 0;
  int amount;
  int createAgain;
  int input;
  int chosenDenom = 0;
  
  RegularVendingMachine vendingMachine = null;
  

  Display displayUI = new Display();

  while(mainOption != 3 ){             // while not exiting the main menu
    
    displayUI.displayMainMenu();          // display the main menu

    mainOption = sc.nextInt();          // get choice for main menu

    subOption = 0;           // initialize other choice values for other menus to 0
    vendingOption = 0;
    maintenanceOption = 0;
    
    if (mainOption == 1){

       if(vendingMachine == null){
        
       do{

        System.out.println("Choose the type of vending machine you want to create\n");
        System.out.println("[1] Regular Vending Machine");
        System.out.println("[2] Special Vending Machine");
        
        input = sc.nextInt();
        sc.nextLine();

        }while(input != 1 && input != 2);

        if(input == 1){
        
        vendingMachine = new RegularVendingMachine();

        }else if(input == 2){

        vendingMachine = new SpecialVendingMachine();
        
        }

       

       }else{

        do{

        System.out.println("A vending machine already exists, do you want to create a new one?");
        System.out.println("[1] Yes");
        System.out.println("[2] No");
        
        createAgain = sc.nextInt();
        sc.nextLine();

        }while(createAgain != 1 && createAgain != 2);

        if(createAgain == 1){

        vendingMachine = null;
        
        do{

        System.out.println("Choose the type of vending machine you want to create\n");
        System.out.println("[1] Regular Vending Machine");
        System.out.println("[2] Special Vending Machine");
        
        input = sc.nextInt();
        
        if(input == 1){
        
        vendingMachine = new RegularVendingMachine();

        }else if(input == 2){
          
        vendingMachine = new SpecialVendingMachine();
        
        }

        }while(input != 1 && input != 2);

        }

       }



    } else if (mainOption == 2){

      displayUI.displaySubMenu();
      subOption = sc.nextInt();

      if (subOption == 1 && vendingMachine != null){

        while (vendingOption != 4){ 

        vendingMachine.displayItemListForCustomer();
        displayUI.displayVendingMenu();
        vendingOption = sc.nextInt();

        if (vendingOption == 1){

          System.out.println ("\nPlease choose a denomination from: 1, 5, 10, 20, 50, 100, 200, 500, and 1000. ");

          chosenDenom = sc.nextInt();

          vendingMachine.insertCash(chosenDenom);
         
          
        }

        else if (vendingOption == 2){

          if(vendingMachine.totalAmount(vendingMachine.getPaymentList()) != 0){
          
          vendingMachine.displayItemListForCustomer();
          
          do{
            
          System.out.println("\nEnter item number: ");


          chosenItem = sc.nextInt();

          }while(chosenItem > vendingMachine.getItemList().size() + 1 || chosenItem < 0);
          
          if(vendingMachine.totalAmount(vendingMachine.getPaymentList()) > vendingMachine.getItemList().get(chosenItem-1).getPrice()){ // if amount inserted is greater than price of item selected

  
          if (vendingMachine.verifyChange(vendingMachine.totalAmount(vendingMachine.getPaymentList()))){ // verify if there is change

            
            System.out.println ("\nDispensing item...\n");    // if yes, dispense

            int change = vendingMachine.totalAmount(vendingMachine.produceChange((vendingMachine.totalAmount(vendingMachine.getPaymentList()) - vendingMachine.getItemList().get(chosenItem-1).getPrice())));      
            
            vendingMachine.storePayment(vendingMachine.getPaymentList());

            vendingMachine.dispenseItem(chosenItem);

            System.out.println("Here is your change: " + change);

             // give out the change, update change list
            
            

          }else{

            
            System.out.println ("There is not enough change inside the vending machine.");

            System.out.println ("Cancelling transaction...");

            System.out.println("Returning P" + vendingMachine.cancelTransaction(vendingMachine.getPaymentList()));

          }
          
          }else if(vendingMachine.totalAmount(vendingMachine.getPaymentList()) == vendingMachine.getItemList().get(chosenItem-1).getPrice()){

              System.out.println ("\nDispensing item...\n");

               vendingMachine.dispenseItem(chosenItem);

          } else{

          System.out.println("Inserted cash is not sufficient.");

        }
        
      }else{

      System.out.println("\nYou have not inserted any cash.\n");

    }

    }else if(vendingOption == 3){

      if(vendingMachine.totalAmount(vendingMachine.getPaymentList()) != 0){

         System.out.println ("Cancelling transaction...");

         System.out.println("Returning P" + vendingMachine.cancelTransaction(vendingMachine.getPaymentList()));

      }else{

        System.out.println("\nYou have not inserted any cash.\n");

      }

    }
    else if (vendingOption == 4){

      
      if(vendingMachine instanceof SpecialVendingMachine){

      ArrayList <Integer> ChosenItems = ((SpecialVendingMachine)vendingMachine).customizeProduct();
       
      System.out.println("\nTotal Calories = \n" + ((SpecialVendingMachine)vendingMachine).computeCalories(ChosenItems));
      System.out.println("Total Price = \n" + ((SpecialVendingMachine)vendingMachine).computePrice(ChosenItems));
      
      do{

      System.out.println("[1] Insert Cash");
      System.out.println("[2] Cancel Transaction");
      System.out.println("[3] Print Receipt and Exit Vending Menu");                                                        // continue working on this part
      
      System.out.println("Enter your choice: ");
      input = sc.nextInt();

      }while(input != 1 && input != 2 && input != 3);

      if(input == 1){

      chosenDenom = sc.nextInt();
      sc.nextLine();
      vendingMachine.insertCash(chosenDenom);

      }else if(input == 2){



      }else if(input == 3){



      }

      }else{

        System.out.println("The vending machine is not a special vending machine");
        
      }

  }else if(vendingOption == 5){

    
      int i, ifPurchase = 0;
      for (i = 0; i < vendingMachine.getItemList().size(); i++){
        if (vendingMachine.getItemList().get(i).getCurrentPurchases() > 0){
          ifPurchase++;
        }
      }
      
      if (ifPurchase > 0){
      vendingMachine.getTransactionList().Receipt(vendingMachine.getItemList());
    }


  }
      


      }

      }
      
      else if (subOption == 2 && vendingMachine != null){


        while(maintenanceOption != 9){
        
        displayUI.displayMaintenanceMenu();
        maintenanceOption = sc.nextInt();

        if(maintenanceOption == 1){

          vendingMachine.displayItemList();

        }else if(maintenanceOption == 2){

          vendingMachine.displayChangeList();

        }else if(maintenanceOption == 3){
          
          vendingMachine.displayItemList();

          do{

          System.out.println("\nEnter item number: ");

          chosenItem = sc.nextInt();
            
          }while(chosenItem > vendingMachine.getItemList().size() + 1 || chosenItem < 0);
          
          System.out.println("\nEnter amount: ");

          amount = sc.nextInt(); 

          vendingMachine.replenishQuantity(chosenItem - 1, amount);

          System.out.println("\n Updated: \n\n");

          vendingMachine.displayItemList();

        }else if(maintenanceOption == 4){
          
          vendingMachine.displayChangeList();

          System.out.println ("\nPlease choose a denomination from: 1, 5, 10, 20, 50, 100, 200, 500, and 1000. ");

          chosenDenom = sc.nextInt();

          vendingMachine.replenishChange(chosenDenom);

          System.out.println("\n Updated: \n\n");

          vendingMachine.displayChangeList();
          

        }else if(maintenanceOption == 5){
          
          vendingMachine.addItem();

          System.out.println("\n Updated: \n\n");

          vendingMachine.displayItemList();
          
        }else if(maintenanceOption == 6){
          
           vendingMachine.displayItemList();

          do{

          System.out.println("\nEnter item number: ");

          chosenItem = sc.nextInt();

          }while(chosenItem > vendingMachine.getItemList().size() + 1 || chosenItem < 0);
          
          System.out.println("\nEnter Amount: ");
          amount = sc.nextInt(); 

          vendingMachine.getItemList().get(chosenItem - 1).setPrice(amount);

          System.out.println("\n Updated: \n\n");

          vendingMachine.displayItemList();

        }else if(maintenanceOption == 7){

          
          System.out.println("\nTotal Payment Collected: P" + vendingMachine.collectPayment(vendingMachine.getOwnerPaymentList()) + "\n");
          
          
        
        }else if(maintenanceOption == 8){
          

          vendingMachine.getTransactionList().TransactionList(vendingMachine.getItemList());


          
        }

        }

      }

      else {

        System.out.println ("There is no current existing vending machine");
        
      }
    }
  }

  sc.close();
  
  }


  
}