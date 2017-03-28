import java.text.NumberFormat;

/**
 * An Item with a name and a price for using the Shopping Cart Project.
 *
 * @author Lukas Strobel
 * @since 3/10/2017
 * AP CS with Mr. Bergquist
 * Shopping Cart Project
 */
public class Item {
   private String name;
   private double price; // In USD
   private int bulkQuantity; // How much needs to be bought for the bulkPrice to apply
   private double bulkPrice;

   /**
    * Basic Constructor
    *
    * @param name  The name of the Item.
    * @param price The price for a non-bulk order of the Item, in USD.
    * @throws IllegalArgumentException On negative price value.
    */
   public Item(String name, double price) {
      if (price < 0) throw new IllegalArgumentException("Price cannot be negative.");
      this.name = name;
      this.price = price;
   }

   /**
    * Extended Constructor
    *
    * @param name         The name of the Item.
    * @param price        The price for a non-bulk order of the Item, in USD.
    * @param bulkQuantity How many of this Item need to be bought to apply bulkPrice.
    * @param bulkPrice    The price for bulk orders of the Item, in USD.
    * @throws IllegalArgumentException On negative values for all params.
    */
   public Item(String name, double price, int bulkQuantity, double bulkPrice) {
      this(name, price);
      if (bulkQuantity < 0 || bulkPrice < 0) throw new IllegalArgumentException("Negative value.");
      this.bulkQuantity = bulkQuantity;
      this.bulkPrice = bulkPrice;
   }

   // Getters to allow for quick changes in case price calculation is changed (e.g. switch to Euro)
   // get the name
   private String getName() {
      return name;
   }

   // get the price
   private double getPrice() {
      return price;
   }

   // get the bulk quantity
   private int getBulkQuantity() {
      return bulkQuantity;
   }

   // get the bulk price
   private double getBulkPrice() {
      return bulkPrice;
   }

   // Methods

   /**
    * This method is used to get the price for a given quantity of this Item.
    *
    * @param quantity The amount of the item.
    * @return The price for the given quantity, taking into account bulk discounts.
    * @throws IllegalArgumentException On a negative quantity.
    */
   public double priceFor(int quantity) {
      if (quantity < 0) throw new IllegalArgumentException("Cannot have a negative quantity.");
      if (getBulkQuantity() > 0) {
         // Calculate discount based on bulkQuantity
         return ((quantity % getBulkQuantity()) * getPrice())
               + ((quantity / getBulkQuantity()) * getBulkPrice());
      } else {
         return quantity * getPrice();
      }
   }

   /**
    * The toString
    *
    * @return The listing formatted for the GUI
    */
   @Override
   public String toString() {
      NumberFormat nf = NumberFormat.getCurrencyInstance();
      String out = getName() + ", " + nf.format(getPrice());
      if (getBulkPrice() > 0) {
         out += " (" + getBulkQuantity() + " for " + nf.format(getBulkPrice()) + ")";
      }
      return out;
   }
}
