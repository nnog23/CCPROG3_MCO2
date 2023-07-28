import java.util.ArrayList;

    /**
    * The class transaction is a template for a transaction for all the purchases.
    * 
    * It has a constructor wherein it constructs the transaction based on the ArrayList, ItemList.
    * 
    * 
    */

public class Transaction {

    private ArrayList <Item> ItemList = new ArrayList <Item>();


    public Transaction (ArrayList <Item> ItemList){
        this.ItemList = ItemList;
    }
    /**
     * Displays all the items bought, the quantity in which they were purchased, and the total earnings
     * @param ItemList is the arraylist of Items
     */
    public void TransactionList(ArrayList <Item> ItemList){
        int i, totalValue = 0;
        int nItem = ItemList.size();
        int nPurchase = 0;
        System.out.println ("List of Transactions");
        
        for (i = 0; i < nItem; i++){

            if (ItemList.get(i).getTotalPurchases() > 0){
                System.out.println(ItemList.get(i).getName() + ": " + ItemList.get(i).getTotalPurchases());
                totalValue += ItemList.get(i).getTotalPurchases() * ItemList.get(i).getPrice();
                nPurchase ++;
            }
            
        }

        if (nPurchase > 0){
            System.out.println ("Total : P" + totalValue);
        }
        else {
            System.out.println("There have been no purchases yet.");
        }
    }
    /**
     * Displays the items the customer purchased, the quantity purchased, and their added totals
     * @param ItemList is the arraylist of Items
     */
     public void Receipt(ArrayList <Item> ItemList){
        int i, totalSpent = 0, nPurchase = 0;
        int nItem = ItemList.size();
    
        System.out.println ("RECEIPT:");
        for (i = 0; i < nItem; i++){
            if (ItemList.get(i).getCurrentPurchases() > 0){
                System.out.println(ItemList.get(i).getName() + ": " + ItemList.get(i).getCurrentPurchases());
                totalSpent += ItemList.get(i).getCurrentPurchases() * ItemList.get(i).getPrice();
                nPurchase++;
                ItemList.get(i).setCurrentPurchases(0);
            }
            
        }
        if (nPurchase > 0){
            System.out.println ("Total : P" + totalSpent);
        }
        else {
            System.out.println("There have been no purchases yet.");
        }
         
    }
    public void specialReceipt (ArrayList <Item> ItemList, String[] CategoryList){
        int i;
        while (ItemList.get(i).getCurrentPurchases() > 0 && ItemList.get(i).getCategory() == CategoryList[0]){
        }
        
    }
    




}
