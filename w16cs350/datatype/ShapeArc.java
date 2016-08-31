/* Trevor Holcomb
	ShapeArc class
*/

package w16cs350.datatype;

import java.util.*;


public class ShapeArc extends A_Shape
{
   private CoordinatesDelta deltaOrigin;
   private double radius, length, circ, theta;
   
   public ShapeArc(CoordinatesWorld reference, CoordinatesDelta deltaStart, CoordinatesDelta deltaEnd, CoordinatesDelta deltaOrigin)
   {
      super(reference, deltaStart, deltaEnd);
      if(deltaOrigin == null)
         throw new RuntimeException("Input cannot be null");
      this.deltaOrigin = deltaOrigin;
      this.radius = deltaOrigin.calculateDistance(deltaStart); 
      this.circ = (2 * Math.PI * this.radius);
      this.theta = this.getAngleEnd().getValue() + this.getAngleStart().getValue();
      this.length = ((this.theta/360)*this.circ);
      
   }
   
   public Angle getAngleEnd()
   {
      return this.deltaOrigin.calculateBearing(this.getDeltaEnd());
   }
   
   public Angle getAngleStart()
   {
      return this.deltaOrigin.calculateBearing(this.getDeltaStart());
   }
   
   public CoordinatesDelta getDeltaOrigin()
   {
      return this.deltaOrigin;
   }
   
   public double getLength()
   {
      return this.length;
   }
   
   public double getRadius()
   {
      return this.radius;
   }
   
   public CoordinatesDelta interpolateDelta(double distance, boolean isFromAOrB)
   {  
      if(distance < 0)
         throw new RuntimeException("Distance cannot be less then 0");
      Angle newBear;  
      Angle deltAng = new Angle(distance / this.circ * 360);
      if(isFromAOrB)
      {
         newBear = this.getAngleStart().add(deltAng);
      }
      else
      {
         newBear = this.getAngleEnd().subtract(deltAng);
      }
      return this.deltaOrigin.calculateTarget(newBear, this.radius);
   }
   
   public boolean isOnPath(double distance)
   {
      return (this.getLength() >= distance);
   }
}