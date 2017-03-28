/**
 * The order of an item, for the Shopping Cart Project
 *
 * @author Lukas Strobel
 * @since 3/10/2017
 * AP CS with Mr. Bergquist
 * Shopping Cart Project
 */
public class ItemOrder {
   private Item item;
   private int quantity;

   /**
    * Basic Constructor
    *
    * @param item     The Item in which this order consists of.
    * @param quantity The amount of the Item in the order.
    * @throws IllegalArgumentException On having a negative quantity.
    */
   public ItemOrder(Item item, int quantity) {
      if (quantity < 0) throw new IllegalArgumentException("Cannot have negative quantity.");
      this.item = item;
      this.quantity = quantity;
   }

   /**
    * @return The price of the order.
    */
   public double getPrice() {
      return item.priceFor(quantity);
   }

   /**
    * @return The Item of the order.
    */
   public Item getItem() {
      return item;
   }

   // the toString
   @Override
   public String toString() {
      return "ItemOrder{" +
            "item=" + item +
            ", quantity=" + quantity +
            '}';
   }
}
