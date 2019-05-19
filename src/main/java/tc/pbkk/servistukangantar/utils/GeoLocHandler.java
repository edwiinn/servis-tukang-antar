package tc.pbkk.servistukangantar.utils;

public class GeoLocHandler {
    public Double getCostByDistance(String startPosition, String endPosition) {
        String[] startGeoLoc = startPosition.split(",");
        String[] endGeoLoc = endPosition.split(",");
        Double latStart = Double.parseDouble(startGeoLoc[1]);
        Double latEnd = Double.parseDouble(endGeoLoc[1]);
        Double longStart = Double.parseDouble(startGeoLoc[0]);
        Double longEnd = Double.parseDouble(endGeoLoc[0]);

        double theta = longStart - longEnd;
        double dist = Math.sin(deg2rad(latStart)) * Math.sin(deg2rad(latEnd)) + Math.cos(deg2rad(latStart)) * Math.cos(deg2rad(latEnd)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;
        
        return dist;
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
      }

      private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
      }
}