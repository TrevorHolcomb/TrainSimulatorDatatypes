/* Trevor Holcomb
	Longitude class
*/

package w16cs350.datatype;

import java.util.*;

public class Longitude extends A_LatitudeLongitude
{
   public Longitude(double nmea)
   {
        super(convertToDegrees(nmea), convertToMinutes(nmea), convertToSeconds(nmea));
   }

   public Longitude(int degrees, int minutes, double seconds)
   {
      super(degrees, minutes, seconds);
   }
   
   public Longitude add(Longitude longitude)
   {
      int deg = this.getDegrees() + longitude.getDegrees();
      int min = this.getMinutes() + longitude.getMinutes();
      double sec = this.getSeconds() + longitude.getSeconds();
      return new Longitude(deg, min, sec);
   }
   
   public Longitude subtract(Longitude longitude)
   {
      int deg = this.getDegrees() - longitude.getDegrees();
      int min = this.getMinutes() - longitude.getMinutes();
      double sec = this.getSeconds() - longitude.getSeconds();
      return new Longitude(deg, min, sec);
   }
   
  
}