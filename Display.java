import java.util.Scanner;

    /**
    * 
    * The class Display is a template for the display of all menus.
    * 
    */

public class Display {

    public Display() {

    }


    /**
     * Displays the main menu
     */
    public void displayMainMenu() {

        System.out.println("[1] Create a Vending Machine");
        System.out.println("[2] Test a Vending Machine");
        System.out.println("[3] Exit");
        System.out.println();
        System.out.println("Enter your choice: ");

    }
    /**
     * Displays the sub menu
     */
    public void displaySubMenu() {
        System.out.println("[1] Test Vending Features");
        System.out.println("[2] Test Maintenance Features");
        System.out.println();
        System.out.println("Enter your choice: ");
    }
    /**
     * Displays the vending menu
     */
    public void displayVendingMenu() {

        System.out.println("[1] Insert Payment");
        System.out.println("[2] Select Item");
        System.out.println("[3] Cancel Transaction");
        System.out.println("[4] Customize Product");
        System.out.println("[5] Print Receipt and Exit Vending Menu");
        System.out.println("Enter your choice: ");

    }


    /**
     * Displays the maintenance menu
     */
    public void displayMaintenanceMenu() {

        System.out.println("[1] Display Item List");
        System.out.println("[2] Display Change List");
        System.out.println("[3] Replenish Item");
        System.out.println("[4] Replenish Change");
        System.out.println("[5] Add A New Item");
        System.out.println("[6] Set Price For Item");
        System.out.println("[7] Collect Payment");
        System.out.println("[8] Print Summary of Transactions");
        System.out.println("[9] End Maintenance Features Test");
        System.out.println("Enter your choice: ");

    }

}

