/* Tester
*/

import java.util.*;
import w16cs350.datatype.*;

public class test
{
	public static void main(String[] args)
	{
	   Latitude lat1 = new Latitude(32, 18, 2.9);
      double nmea1 = lat1.convertToNMEA();
      System.out.println(nmea1);
      int deg1 = lat1.convertToDegrees(nmea1);
      System.out.println(deg1);
      Angle ang90 = new Angle(359);
      Angle ang45 = new Angle(225);   
      System.out.println(Angle.normalize(-45));
      Angle added = ang90.add(ang90);
      Angle subed = ang90.subtract(ang45);
      System.out.println(added.getValue());
      System.out.println(subed.getValue());
      CoordinatesDelta cd1 = new CoordinatesDelta(-30, 40);
      CoordinatesDelta cd2 = new CoordinatesDelta(-10, 20);
      Angle bear = cd1.calculateBearing(cd2);
      System.out.println(bear.getValue());
      CoordinatesDelta targ = new CoordinatesDelta(-30, 40);
      CoordinatesDelta newTarg = targ.calculateTarget(new Angle(135), 28.28427);
      System.out.println(newTarg.getX());
      System.out.println(newTarg.getY());
      CoordinatesScreen scr = new CoordinatesScreen(2, 3);
      CoordinatesScreen newScr = scr.getHalf();
      System.out.println("x " + newScr.getX() + " y " + newScr.getY());
      double distance = 28.284271247461902;
     // CoordinatesDelta calcTarDel = new CoordinatesDelta(30, 40);
      CoordinatesDelta calcTarDel2 = new CoordinatesDelta(0, 0);
      CoordinatesDelta calcTarDel = calcTarDel2.calculateTarget(Angle.ANGLE_000, 10);
      System.out.println("x: " + calcTarDel.getX());
      System.out.println("y: " + calcTarDel.getY());
      CoordinatesWorld KSFF = new CoordinatesWorld(new Latitude(47, 40, 58), new Longitude(117, 19, 21));
      CoordinatesWorld KGEG = new CoordinatesWorld(new Latitude(47, 37, 8), new Longitude(117, 32, 14));
      Angle newBear = KGEG.calculateBearing(KSFF);
      System.out.println(newBear.getValue());
      double m = KSFF.calculateDistanceNauticalMiles(KGEG);
      System.out.println(m);
      double newTar =  KSFF.calculateTarget(new Angle(253.43004531030988), 24893.713110921606).getLatitude().convertToNMEA();
      System.out.println(newTar);
      ShapeArc arc1 = new ShapeArc(KSFF, new CoordinatesDelta(100, 200), new CoordinatesDelta(300, 400), new CoordinatesDelta(100, 400));
      ShapeLine line1 = new ShapeLine(KSFF, new CoordinatesDelta(100, 200), new CoordinatesDelta(300, 400));
      double newSt = arc1.getWorldStart().getLongitude().convertToNMEA();
      System.out.println(newSt);
      arc1.setIndex(3);
      boolean has = arc1.hasIndex();
      System.out.println(has);
      int in = arc1.getIndex();
      System.out.println(in);
      double interpolateW =  line1.interpolateWorld(282, false).getLatitude().convertToNMEA();
      System.out.println(interpolateW);
      double newDel = arc1.interpolateWorld(0, true).getLatitude().convertToNMEA();
      System.out.println(newDel);
      line1.setIndex(1);
      line1.setIndex(2);
     
	}
	
	
}