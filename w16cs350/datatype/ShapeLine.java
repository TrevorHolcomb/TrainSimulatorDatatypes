/* Trevor Holcomb
	ShapeLine class
*/

package w16cs350.datatype;

import java.util.*;

public class ShapeLine extends A_Shape
{
   public ShapeLine(CoordinatesWorld reference, CoordinatesDelta deltaStart, CoordinatesDelta deltaEnd)
   {
      super(reference, deltaStart, deltaEnd);
   }
   
   // returns the length;
   public double getLength()  
   {
      return (this.getDeltaStart().calculateDistance(this.getDeltaEnd()));
   }
   
   public CoordinatesDelta interpolateDelta(double distance, boolean isFromAOrB)
   {
      if(distance < 0)
         throw new RuntimeException("Distance cannot be less then 0");
      double newX, newY;
      Angle deg;
      CoordinatesDelta newDelta;
      if(isFromAOrB)
      {
         deg = this.getDeltaStart().calculateBearing(this.getDeltaEnd());
         newX = this.getDeltaStart().getX() + (distance * Math.cos(Math.toRadians(deg.getValue())));
         newY = this.getDeltaStart().getY() + (distance * Math.sin(Math.toRadians(deg.getValue())));
         newDelta = new CoordinatesDelta(newX, newY);
      }
      else
      {
         deg = this.getDeltaEnd().calculateBearing(this.getDeltaStart());
         newX = this.getDeltaEnd().getX() + (distance * Math.cos(Math.toRadians(deg.getValue())));
         newY = this.getDeltaEnd().getY() + (distance * Math.sin(Math.toRadians(deg.getValue())));  
         newDelta = new CoordinatesDelta(newX, newY);
      }
      return newDelta;
   }
   
   // returns whether the distance is on the path or not
   public boolean isOnPath(double distance)
   {
      return (this.getLength() >= distance);
   }
   
   
   
   
}