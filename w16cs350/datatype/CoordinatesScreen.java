/* Trevor Holcomb
	CoordinatesScreen class
*/

package w16cs350.datatype;

import java.util.*;

public class CoordinatesScreen
{
   private int x, y;
   private boolean isVisible;
   
   public CoordinatesScreen(int x, int y)
   {
      this.x = x; 
      this.y = y;
   }
   
   public CoordinatesScreen add(CoordinatesScreen coordinates)
   {
      int newX = this.getX() + coordinates.getX();
      int newY = this.getY() + coordinates.getY();
      return new CoordinatesScreen(newX, newY);
   }
   
   public CoordinatesScreen getHalf()
   {
      int newX = Math.round((float)x/2);
      int newY = Math.round((float)y/2);
      return new CoordinatesScreen(newX, newY);
   }
   
   public int getX()
   {
      return this.x;
   }
   
   public int getY()
   {
      return this.y;
   }
   
   public boolean isVisible()
   {
      return this.isVisible;
   }
   
   public void isVisible(boolean isVisible)
   {
      this.isVisible = isVisible;
   }
   
   public CoordinatesScreen subtract(CoordinatesScreen coordinates)
   {
      int newX = this.getX() - coordinates.getX();
      int newY = this.getY() - coordinates.getY();
      return new CoordinatesScreen(newX, newY);
   }
}