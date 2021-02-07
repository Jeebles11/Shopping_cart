import java.util.Scanner;
import java.util.ArrayList;

public class ShoppingCartManager {
   
   public static void printMenu(){
      String [] menu = {"MENU","a - Add item to cart","d - Remove item from cart","c - Change item quantity","i - Output items' descriptions","o - Output shopping cart","q - Quit","",};
      
      for (int i = 0; i <menu.length; i++){
         System.out.println(menu[i]);
      }
   }
   
   public static Scanner scnr = new Scanner(System.in);
   public static void main(String[] args) {
      
      System.out.println("Enter Customer's Name:");
      String toName = scnr.nextLine();
      System.out.println("Enter Today's Date:");
      String toDate = scnr.nextLine();
      
      ShoppingCart Cart1 = new ShoppingCart(toName, toDate);
      
      System.out.println();
      System.out.println("Customer Name: " + Cart1.getCustomerName());
      System.out.println("Today's Date: " + Cart1.getDate());
      System.out.println();
      
      String iName;
      String iDesc;
      int iPrice;
      int iQuant;
      char userChar;
      boolean valid = true;
      
      do {
         if (valid)        //needed because instructions state to not re-print entire menu, if an invalid char is chosen. 
            printMenu();
            
         valid = true;
         System.out.println("Choose an option:");
         userChar = scnr.nextLine().charAt(0);
         switch (userChar) {
            case 'q':
               break;
            
            case 'a':
               System.out.println("ADD ITEM TO CART");
               System.out.println("Enter the item name:");
               iName = scnr.nextLine();
               System.out.println("Enter the item description:");
               iDesc = scnr.nextLine();
               System.out.println("Enter the item price:");
               iPrice = scnr.nextInt();
               System.out.println("Enter the item quantity:");
               iQuant = scnr.nextInt();
               String blanky = scnr.nextLine();  //this is needed to reset the scanner to the right place. nextInt throws it off otherwise
               System.out.println();
               
               ItemToPurchase freshItem = new ItemToPurchase(iName, iDesc, iPrice, iQuant);
               Cart1.addItem(freshItem);
               break;
         
            case 'd':
               System.out.println("REMOVE ITEM FROM CART");
               System.out.println("Enter name of item to remove:");
               String toRemove = scnr.nextLine();
               Cart1.removeItem(toRemove);
               break;
         
            case 'c':
               System.out.println("CHANGE ITEM QUANTITY");
               System.out.println("Enter the item name:");
               String fName = scnr.nextLine();
               System.out.println("Enter the new quantity:");
               int fQuant = scnr.nextInt();
               String blanky2 = scnr.nextLine();  //this is needed to reset the scanner to the right place. nextInt throws it off otherwise
              
               ItemToPurchase findItem = new ItemToPurchase(fName, fQuant);
               Cart1.modifyItem(findItem);
               break;
               
            case 'i':
               System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
               Cart1.printDescriptions();
               break;
         
            case 'o':
               System.out.println("OUTPUT SHOPPING CART");
               Cart1.printTotal();
               break;
               
            default:
              // System.out.println("Invalid Char.");
              valid = false; //needed because instructions state to not re-print entire menu, if an invalid char is chosen. 
               break;         
         }
      } while (userChar != 'q');
   }
}