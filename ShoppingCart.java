import java.util.ArrayList;

public class ShoppingCart {
  private String customerName; 
  private String currentDate;
  private ArrayList<ItemToPurchase> cartItems = new ArrayList<ItemToPurchase>();
  
   /* Constructorz */
   
   public ShoppingCart() {
      setCustomerName("");   
      setCurrentDate("");   
   }
  
   public ShoppingCart(String custName, String currDate) {
      setCustomerName(custName);
      setCurrentDate(currDate);
   }
   
   /* Instance Methods *
      /* Setters */
       
   public void setCustomerName(String custName){
      if (custName.equals(""))
         custName = "none";
        
      customerName = custName;    
   }
  
  public void setCurrentDate(String currDate){
      if (currDate.equals(""))
          currDate = "January 1, 2016";
        
      currentDate = currDate;   
   }
  
  /* Getters */
  
  public String getCustomerName(){
      return customerName;  
   }
  
  public String getDate(){
      return currentDate;  
   }
   
   /* ITEM methods */
   
   public void addItem(ItemToPurchase Item){
      cartItems.add(Item);
   }
   
   public void removeItem(String itemName){
      ItemToPurchase currItem;
      boolean gotRemoved = false;
      
      for (int i = 0; i < cartItems.size(); i++){
         currItem = cartItems.get(i);
         if (itemName.equals(currItem.getName())){
            cartItems.remove(i);
            gotRemoved = true; 
            //System.out.println("Item GOT REMOVED.");
         }
      }
      if(!gotRemoved)
         System.out.println("Item not found in cart. Nothing removed.");
         
      System.out.println();
   }
   
   public void modifyItem(ItemToPurchase toFind){
      ItemToPurchase currItem;
      String findName = toFind.getName();
      int findQuant = toFind.getQuantity();
      boolean itemFound = false;
      
      for (int i = 0; i < cartItems.size(); i++){  //this loop searches ArrayList for matching name. If found, 
         currItem = cartItems.get(i);                 // item in ArrayList is updated with the new Quantity entered by user.
         if (findName.equals(currItem.getName())){
            currItem.setQuantity(findQuant);
            itemFound = true; 
            //System.out.println("Item GOT FOUND!");
         }
      }
      if(!itemFound)
         System.out.println("Item not found in cart. Nothing modified."); 
         
      System.out.println();
       
   }
   
   public int getNumItemsInCart(){
      int cartTotal = 0;
      ItemToPurchase currItem;
      
      for (int i = 0; i < cartItems.size(); i++){
         currItem = cartItems.get(i);
         cartTotal += currItem.getQuantity();
        // System.out.println(cartTotal);
      }
      return cartTotal;
   }
   
   public int getCostOfCart(){
      int cartTotal = 0;
      int quant= 0;
      int price = 0;
      ItemToPurchase currItem;
      
      for (int i = 0; i < cartItems.size(); i++){
         currItem = cartItems.get(i);
         quant = currItem.getQuantity();
         price = currItem.getPrice();
         cartTotal += (quant * price);
         //System.out.println(cartTotal);
      }
      return cartTotal;
   }
   
   /* PRINT methods */
   
   public void printNameDate(){
      System.out.println(getCustomerName() + "'s Shopping Cart - " + getDate());
   }
   
   public void printTotal(){
      ItemToPurchase currItem;
      printNameDate();
      System.out.println("Number of Items: " + getNumItemsInCart());
      System.out.println();
      
      if (cartItems.size() > 0){
         for (int i = 0; i < cartItems.size(); i++){
            currItem = cartItems.get(i);
            currItem.printItemCost();
         }
         System.out.println();
         System.out.println("Total: $" + getCostOfCart());
         System.out.println();
      }
      else {
      System.out.println("SHOPPING CART IS EMPTY");
      System.out.println();
      System.out.println("Total: $0");
      System.out.println();
      }
   }
   
   public void printDescriptions(){
      ItemToPurchase currItem;
      printNameDate();
      System.out.println();
      System.out.println("Item Descriptions");
      
      if (cartItems.size() > 0){
         for (int i = 0; i < cartItems.size(); i++){
            currItem = cartItems.get(i);
            currItem.printItemDescription();
         }
         System.out.println();
      }
      else {
      System.out.println("SHOPPING CART IS EMPTY");
      System.out.println();
      }
   }
}