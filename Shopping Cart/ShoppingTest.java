/**
 * Test file to test out the Objects I created
 *
 * @author Lukas Strobel
 * @since 3/10/2017
 * AP CS with Mr. Bergquist
 * Shopping Cart Project
 */
public class ShoppingTest {
   public static void main(String[] args) {

      // catalog constructor
      Catalog costco = new Catalog("Costco");

      // single item
      Item banana = new Item("Banana", 0.99);
      costco.add(banana);

      // bulk item
      Item button = new Item("Button", 0.99, 10, 5);
      costco.add(button);

      // Bad item, throws error (yay!)
      //Item fail = new Item("Fail", -99);

      //ItemOrder order = new ItemOrder(button, -12);
      ItemOrder order = new ItemOrder(banana, 12);
      ItemOrder buttons = new ItemOrder(button, 12);
      ShoppingCart cart = new ShoppingCart();

      // add Itemorder(s)
      cart.add(order);
      cart.add(buttons);
      // replace previous order
      cart.add(new ItemOrder(button, 50));

      // THE WALL OF PRINTLNS
      System.out.println(banana);
      System.out.println(button);
      System.out.println(costco.get(1));
      System.out.println(costco.getName());
      System.out.println(costco);
      System.out.println(banana.priceFor(12));
      //System.out.println(banana.priceFor(-12));
      System.out.println(button.priceFor(12));
      System.out.println(order.getPrice());
      System.out.println(cart);
      // Verified price using my calculator: its correct, plus ShoppingMain matches images
      // in project spec
      System.out.println(cart.getTotal());
      cart.setDiscount(true);
      System.out.println(cart.getTotal());

   }
}
