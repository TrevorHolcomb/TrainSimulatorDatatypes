/* Trevor Holcomb
	A_Shape class
*/

package w16cs350.datatype;

import java.util.*;

public abstract class A_Shape
{
   // class level variables
   private CoordinatesWorld reference;
   private CoordinatesDelta deltaStart, deltaEnd;
   private Integer index = null;
      
   public A_Shape(CoordinatesWorld reference, CoordinatesDelta deltaStart, CoordinatesDelta deltaEnd)
   {
      if(reference == null || deltaStart == null || deltaEnd == null)
         throw new NullPointerException("Input cannot be null");
      this.reference = reference;
      this.deltaStart = deltaStart;
      this.deltaEnd = deltaEnd;
   }
   
   public A_Shape(CoordinatesWorld reference, CoordinatesDelta deltaStart, CoordinatesDelta deltaEnd, int index)
   {
      if(reference == null || deltaStart == null || deltaEnd == null)
         throw new NullPointerException("Input cannot be null");
      this.reference = reference;
      this.deltaStart = deltaStart;
      this.deltaEnd = deltaEnd;
      this.index = index;
   }
   
   // getter for deltaEnd
   public CoordinatesDelta getDeltaEnd()
   {
      return this.deltaEnd;
   }
   
   // getter for deltaStart
   public CoordinatesDelta getDeltaStart()
   {
      return this.deltaStart;
   }
   
   // getter for index
   public int getIndex()
   {
      return this.index;
   }
   
   // getter for reference
   public CoordinatesWorld getReference()
   {
      return this.reference;
   }
   
   public CoordinatesWorld getWorldEnd()
   {
      return this.reference.calculateTarget(this.deltaEnd);
      
   }
   
   public CoordinatesWorld getWorldStart()
   {
      return this.reference.calculateTarget(this.deltaStart);
   }
   
   // returns whether or not there is an index
   public boolean hasIndex()
   {
      return (this.index != null);
   }
   
   public CoordinatesWorld interpolateWorld(double distance, boolean isFromAOrB)
   {
      CoordinatesDelta newDelta = this.interpolateDelta(distance, isFromAOrB);
      CoordinatesWorld newWorld = this.getReference().calculateTarget(newDelta);
      return newWorld;
   }
   
   // setter for index
   public void setIndex(int index)
   {
      if(this.hasIndex())
         throw new RuntimeException("Index already set");
      this.index = index;
   }
   
   // abstract methods
   public abstract double getLength();
   public abstract CoordinatesDelta interpolateDelta(double distance, boolean isFromAOrB);
   public abstract boolean isOnPath(double distance);
   
}