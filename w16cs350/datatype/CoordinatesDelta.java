/* Trevor Holcomb
	CoordinatesDelta class
*/

package w16cs350.datatype;

import java.util.*;

public class CoordinatesDelta
{
   private double x, y;
   
   public CoordinatesDelta(double x, double y)
   {
      this.x = x;
      this.y = y;
   }
   
   public CoordinatesDelta add(CoordinatesDelta coordinates)
   {
      double newX = this.x + coordinates.getX();
      double newY = this.y + coordinates.getY();
      return new CoordinatesDelta(newX, newY);
   }

   public Angle calculateBearing(CoordinatesDelta target)
   {
      double newX = target.getX() - this.getX();
      double newY = target.getY() - this.getY();
      double bearing = 90 - (180/Math.PI)*Math.atan2(newY, newX);
      return new Angle(Angle.normalize(bearing));
   }
   
   public double calculateDistance(CoordinatesDelta target)
   {
      double dist = Math.sqrt(Math.pow(target.getX() - this.getX(), 2) + Math.pow(target.getY() - this.getY(), 2));
      return dist;
   }  
   
   public CoordinatesDelta calculateTarget(Angle bearing, double distance)
   {
      if(distance < 0)
         throw new RuntimeException("distance cannot be less then 0");
      double myRad = Math.toRadians(90.0 - bearing.getValue());
      double newX = (this.getX() + (distance * Math.cos(myRad)));
      double newY = (this.getY() + (distance * Math.sin(myRad))); 
      return new CoordinatesDelta(newX, newY);
   }
   
   public CoordinatesDelta subtract(CoordinatesDelta coordinates)
   {  
      double newX = this.x - coordinates.getX();
      double newY = this.y - coordinates.getY();
      return new CoordinatesDelta(newX, newY);
   }
   
   public double getX()
   {
      return this.x;
   }
   
   public double getY()
   {
      return this.y;
   }

}