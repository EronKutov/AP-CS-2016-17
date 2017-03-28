/**
 * @author Lukas Strobel
 * @since 2/13/2017
 */

public class Point {

   private int x;
   private int y;

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Point point = (Point) o;

      if (x != point.x) return false;
      return y == point.y;
   }

   public Point() {
      this.x = 0;
      this.y = 0;
   }

   public Point(int x, int y) {
      this.x = x;
      this.y = y;
   }

   public int getX() {
      return x;
   }

   public void setX(int x) {
      this.x = x;
   }

   public int getY() {
      return y;
   }

   public void setY(int y) {
      this.y = y;
   }

   public double getDistance(Point p) {
      return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
   }

   @Override
   public String toString() {
      return "Point{" +
            "x=" + x +
            ", y=" + y +
            '}';
   }
}
