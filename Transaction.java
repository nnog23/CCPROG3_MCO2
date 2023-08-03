import java.util.ArrayList;

    /**
    * The class transaction is a template for a transaction for all the purchases.
    * 
    * It has a constructor wherein it constructs the transaction based on the ArrayList, ItemList.
    * 
    * 
    */

public class Transaction {
    
    public Transaction (){
        
    }

    /**
     * Displays all the items bought, the quantity in which they were purchased, and the total earnings
     * @param ItemList is the arraylist of Items
     * @return string of transactions
     */
    public String TransactionList(ArrayList <ArrayList<Item>> ItemList, ArrayList<Integer> totalPurchases){
        int i, totalValue = 0;
        int nItem = ItemList.size();
        int nPurchase = 0;
        String totalDisplay = "";
        
        for (i = 0; i < nItem; i++){

            if (totalPurchases.get(i) > 0){
                totalDisplay += ItemList.get(i).get(0).getName() + ": " + totalPurchases.get(i) + "\n";
                totalValue += totalPurchases.get(i) * ItemList.get(i).get(0).getPrice();
                nPurchase++;
                
            }
            
        }

        if (nPurchase > 0){
            totalDisplay += "\nTotal: P" +totalValue;  
            return totalDisplay;
        }
        else {
            return "There have been no purchases yet";
        }
    }
    




}
