/* Trevor Holcomb
	Angle class
*/

package w16cs350.datatype;

import java.util.*;

public class Angle
{
   private double angle;
   
   public Angle(double angle)
   {
      if(angle < 0 || angle >= 360)
         throw new RuntimeException("Must be between 0 and 359");
      this.angle = angle;
   }
   
   public static final Angle ANGLE_000 = new Angle(0);
   public static final Angle ANGLE_045 = new Angle(45);
   public static final Angle ANGLE_090 = new Angle(90);
   public static final Angle ANGLE_135 = new Angle(135);
   public static final Angle ANGLE_180 = new Angle(180);
   public static final Angle ANGLE_225 = new Angle(225);
   public static final Angle ANGLE_270 = new Angle(270);
   public static final Angle ANGLE_315 = new Angle(315);
   
   public static double normalize(double angle)
   {
      double temp = (angle % 360);
      if(temp < 0)
         temp = 360 + temp;
      return temp;
   }
   
   public Angle add(Angle angle)
   {
      Angle temp = new Angle(normalize(this.angle + angle.getValue()));
      return temp;
   }
   
   public double getValue()
   {
      return this.angle;
   }
   
   public Angle reciprocate()
   {
      return new Angle(normalize(this.angle + 180));
   }
   
   public Angle subtract(Angle angle)
   {
      Angle temp = new Angle(normalize(this.angle - angle.getValue()));
      return temp;
   }
   
}