/* Trevor Holcomb
	A_LatitudeLongitude
*/

package w16cs350.datatype;

import java.util.*;




public abstract class A_LatitudeLongitude
{ 

   private int degrees, minutes;
   private double seconds;
   
   public A_LatitudeLongitude(int degrees, int minutes, double seconds)
   {
      this.degrees = degrees;
      this.minutes = minutes; 
      this.seconds = seconds;
   }
   
   // static variables
   public static final double	METERS_PER_NAUTICAL_MILE = 1852.00;
   public static final int	MINUTES_PER_DEGREE = 60;
   public static final int	SECONDS_PER_MINUTE = 60;
   
   public static int convertToDegrees(double nmea)
   {
      int deg = (int)(nmea / 100);
      return deg;
   }
   
   public static int convertToMinutes(double nmea)
   {
      int deg = (int)(nmea / 100);
      int min = (int)(nmea - ( deg * 100));
      return min;
   }
   
   public static double convertToNauticalMiles(int degrees, int minutes, double seconds)
   {
      double naut = (degrees * 60);
      naut += minutes;
      naut += (seconds / 60);
      return naut;
      
   }
    
   public static double convertToNMEA(int degrees, int minutes, double seconds)
   {
      return ((degrees * 100) + minutes + (seconds / 60));
   }
   
   public static double convertToSeconds(double nmea)
   { 
      int degMin = (int)(nmea);
      double sec = ((nmea - (degMin)) * 60);
      return sec;
   }
   
   public double calculateDistanceMeters(A_LatitudeLongitude target)
   {
      
      return this.calculateDistanceNauticalMiles(target) * METERS_PER_NAUTICAL_MILE;
      
   }
   
   public double calculateDistanceNauticalMiles(A_LatitudeLongitude target)
   {
      double thisNaut = convertToNauticalMiles(this.getDegrees(), this.getMinutes(), this.getSeconds());
      double tarNaut = convertToNauticalMiles(target.getDegrees(), target.getMinutes(), target.getSeconds());
      return Math.abs(tarNaut - thisNaut);
   }
   
   public double convertToNMEA()
   {
      return ((this.degrees * 100) + this.minutes + (this.seconds / 60));
   }
   
   public int getDegrees()
   {
      return this.degrees;
   }
   
   public int getMinutes()
   {
      return this.minutes;
   }
   
   public double getSeconds()
   {
      return this.seconds;
   }
   
   
}