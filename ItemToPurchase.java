public class ItemToPurchase {
   
   /* Attributes */
   
   private String itemName;
   private int itemPrice;
   private int itemQuantity;
   private String itemDescription;
   
   /* Constructorz */
   
   public ItemToPurchase () {
      setName("");
      setPrice(0);
      setQuantity(0); 
      setDescription("");
   }
   
   public ItemToPurchase(String name, int quant){
      setName(name);
      setPrice(0);
      setQuantity(quant);
      setDescription("");
   }
   
   public ItemToPurchase(String name, int price, int quant){
      setName(name);
      setPrice(price);
      setQuantity(quant);
      setDescription("");
   }
   
   public ItemToPurchase(String name, String itemDesc, int price, int quant){
      setName(name);
      setPrice(price);
      setQuantity(quant);
      setDescription(itemDesc);
   }
    
   /* Instance Methods *
      /* Setters */
   
   public void setName(String itemName){
      if (itemName.equals(""))
         itemName = "none";
      
      else 
         this.itemName = itemName;
   }
   
   public void setPrice(int price){
      itemPrice = price;
   }
      
   public void setQuantity(int quant){
      itemQuantity = quant;
   } 
   
   public void setDescription(String itemDesc){
     if (itemDesc.equals(""))
         itemDesc = "none";
     
     else
         itemDescription = itemDesc;
   }
   
    /* Getters */
   
   public String getName(){
      return itemName;
   }
   
   public int getPrice(){
      return itemPrice;  
   }
   
   public int getQuantity(){
      return itemQuantity;  
   }
   
   public String getDescription(){
      return itemDescription;
   }
   
   /* Print Stuff */
   
   public void printItemCost(){
      String s = "";
      
      s += itemName;
      s += " " + itemQuantity + " @ ";
      s += "$" + itemPrice;
      s += " = $" + (itemQuantity * itemPrice);
      
      System.out.println(s);
   }
   
   public void printItemDescription(){
      String s = "";
      s += itemName + ": ";
      s += itemDescription;
      
      System.out.println(s);
   }
}