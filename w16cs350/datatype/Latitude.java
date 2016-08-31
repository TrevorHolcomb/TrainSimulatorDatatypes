/* Trevor Holcomb
	Latitude class
*/

package w16cs350.datatype;

import java.util.*;

public class Latitude extends A_LatitudeLongitude
{
   public Latitude(double nmea)
   {
        super(convertToDegrees(nmea), convertToMinutes(nmea), convertToSeconds(nmea));
   }

   public Latitude(int degrees, int minutes, double seconds)
   {
      super(degrees, minutes, seconds);
   }
   
   public Latitude add(Latitude latitude)
   {
      int deg = this.getDegrees() + latitude.getDegrees();
      int min = this.getMinutes() + latitude.getMinutes();
      double sec = this.getSeconds() + latitude.getSeconds();
      return new Latitude(deg, min, sec);
   }
   
   public Latitude subtract(Latitude latitude)
   {
      int deg = this.getDegrees() - latitude.getDegrees();
      int min = this.getMinutes() - latitude.getMinutes();
      double sec = this.getSeconds() - latitude.getSeconds();
      return new Latitude(deg, min, sec);
   }
}