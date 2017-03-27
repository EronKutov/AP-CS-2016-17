import java.util.ArrayList;

/**
 * A shopping cart that hold the ItemOrders for a person.
 *
 * @author Lukas Strobel
 * @since 3/10/2017
 * AP CS with Mr. Bergquist
 * Shopping Cart Project
 */
public class ShoppingCart {

   private static final double DISCOUNT = 0.9;
   private ArrayList<ItemOrder> orders;
   private boolean discount;

   /**
    * Basic Constructor
    */
   public ShoppingCart() {
      orders = new ArrayList<ItemOrder>();
      discount = false;
   }

   /**
    * @param order The order you wish to append.
    */
   public void add(ItemOrder order) {
      // Make sure that an order of the same Item doesn't already exist
      int exists = -1;
      for (int i = 0; i < orders.size(); i++) {
         if (orders.get(i).getItem() == order.getItem()) {
            exists = i;
         }
      }
      // If it does, replace it
      if (exists > -1) {
         orders.set(exists, order);
      } else {
         // Otherwise, just add to the cart
         orders.add(order);
      }
   }

   /**
    * @param val Set to true to apply discount, false to not.
    */
   public void setDiscount(boolean val) {
      discount = val;
   }

   /**
    * @return The total price of the cart, discount inclusive.
    */
   public double getTotal() {
      double total = 0.0;
      for (int i = 0; i < orders.size(); i++) {
         total += orders.get(i).getPrice();
      }
      if (discount) {
         total *= DISCOUNT;
      }
      return total;
   }

   // the toString
   @Override
   public String toString() {
      return "ShoppingCart{" +
            "orders=" + orders +
            ", discount=" + discount +
            '}';
   }
}
