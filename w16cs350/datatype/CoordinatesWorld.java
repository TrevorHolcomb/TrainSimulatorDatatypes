/* Trevor Holcomb
	CoordinatesWorld class
*/

package w16cs350.datatype;

import java.util.*;

public class CoordinatesWorld
{
   public static final double METERS_PER_NAUTICAL_MILE = 1852.00;
   public Latitude latitude;
   public Longitude longitude;
   
   public CoordinatesWorld(Latitude latitude, Longitude longitude)
   {
      this.latitude = latitude;
      this.longitude = longitude;
   }
   
   public static CoordinatesWorld build(int latitudeDegrees, int latitudeMinutes, double latitudeSeconds,
                     int longitudeDegrees, int longitudeMinutes, double longitudeSeconds)
   {
      Latitude newLat = new Latitude(latitudeDegrees, latitudeMinutes, latitudeSeconds);
      Longitude newLong = new Longitude(longitudeDegrees, longitudeMinutes, longitudeSeconds);
      CoordinatesWorld newWorld = new CoordinatesWorld(newLat, newLong);
      return newWorld;
   }
   
   public static double convertMetersToNauticalMiles(double meters)
   {
      return (meters / METERS_PER_NAUTICAL_MILE);
   }

   public CoordinatesWorld add(CoordinatesWorld coordinates)
   {
      Longitude newLong = this.getLongitude().add(coordinates.getLongitude());
      Latitude newLat = this.getLatitude().add(coordinates.getLatitude());
      return new CoordinatesWorld(newLat, newLong);
   }
   
   public Latitude getLatitude()
   {
      return this.latitude;
   }
   
   public Longitude getLongitude()
   {
      return this.longitude;
   }
   
   public Angle calculateBearing(CoordinatesWorld target)
   {
      double x1 = this.getLatitude().convertToNMEA();
      double x2 = target.getLatitude().convertToNMEA();
      double y1 = this.getLongitude().convertToNMEA();
      double y2 = target.getLongitude().convertToNMEA();
      double newX = x1 - x2;
      double newY = y1 - y2;
      // got from Dan in class, works but not exactly sure why
      double bearing = 1.5707963267948966 + Math.atan2(newX, newY);
      return new Angle(Angle.normalize(Math.toDegrees(bearing)));
      
   }
   
   public double calculateDistanceMeters(CoordinatesWorld target)
   {
      return (this.calculateDistanceNauticalMiles(target) * METERS_PER_NAUTICAL_MILE);
   }
   
   public double calculateDistanceNauticalMiles(CoordinatesWorld target)
   {
      double x1 = this.getLatitude().convertToNMEA();
      double x2 = target.getLatitude().convertToNMEA();
      double y1 = this.getLongitude().convertToNMEA();
      double y2 = target.getLongitude().convertToNMEA();
      double newLat = x1 - x2;
      double newLon = y1 - y2;
      double distanceNMEA = Math.sqrt(Math.pow(newLat, 2) + Math.pow(newLon, 2));
      Latitude dist = new Latitude(distanceNMEA);
      double distance = dist.getDegrees() * (METERS_PER_NAUTICAL_MILE * 60);
      distance += dist.getMinutes() * METERS_PER_NAUTICAL_MILE;
      distance += dist.getSeconds() * (METERS_PER_NAUTICAL_MILE / 60);
      
      return convertMetersToNauticalMiles(distance);
   }
   
   public CoordinatesWorld calculateTarget(Angle bearing, double distance)
   {
      double x = this.latitude.convertToNMEA();      
      double y = this.longitude.convertToNMEA();
      double bearingRad = Math.toRadians(bearing.getValue());
      double dist = convertMetersToNauticalMiles(distance);
      double newX = ((Math.cos(bearingRad) * dist) + x);
      double newY = ((Math.sin(bearingRad) * dist) + y);
      Latitude lat = new Latitude(newX);
      Longitude lon = new Longitude(newY);
      return new CoordinatesWorld(lat, lon);
   }
   
   public CoordinatesWorld calculateTarget(CoordinatesDelta delta)
   {
      double x = this.getLatitude().convertToNMEA();
      double y = this.getLongitude().convertToNMEA();
      double lat = x + convertMetersToNauticalMiles(delta.getY());
      double lon =  y - convertMetersToNauticalMiles(delta.getX());
      Latitude newLat = new Latitude(lat);
      Longitude newLon = new Longitude(lon);
      return new CoordinatesWorld(newLat, newLon);
   }
   
   
   public CoordinatesWorld subtract(CoordinatesWorld coordinates)
   {
      Longitude newLong = this.getLongitude().subtract(coordinates.getLongitude());
      Latitude newLat = this.getLatitude().subtract(coordinates.getLatitude());
      return new CoordinatesWorld(newLat, newLong);
   }
   
   
   
}