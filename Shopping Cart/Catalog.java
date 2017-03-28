import java.util.ArrayList;

/**
 * A collection of Items available for a store.
 *
 * @author Lukas Strobel
 * @since 3/10/2017
 * AP CS with Mr. Bergquist
 * Shopping Cart Project
 */
public class Catalog {
   private String name;
   private ArrayList<Item> list;

   /**
    * Basic Constructor
    *
    * @param name The name of the Catalog.
    */
   public Catalog(String name) {
      this.name = name;
      this.list = new ArrayList<Item>();
   }

   //Methods

   /**
    * Appends an Item to the end of the list.
    *
    * @param item The Item you wish to append.
    */
   public void add(Item item) {
      list.add(item);
   }

   /**
    * @return The size of the Catalog.
    */
   public int size() {
      return list.size();
   }

   /**
    * @param index The index of the requested Item.
    * @return The Item at @param index.
    */
   public Item get(int index) {
      return list.get(index);
   }

   /**
    * Return the name of the Catalog without fancy toString formatting
    *
    * @return The name of the Catalog
    */
   public String getName() {
      return name;
   }

   // The toString
   @Override
   public String toString() {
      return "Catalog{" +
            "name='" + name + '\'' +
            ", list=" + list +
            '}';
   }
}
