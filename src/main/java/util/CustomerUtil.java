package util;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import model.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerUtil {

  /**
   * Equatorial earth radius in Kilometers (KM).
   */
  private static final int EARTH_RADIUS_IN_KM = 6371;
  private static final double DUBLIN_OFFICE_LATITUDE = 53.339428;
  private static final double DUBLIN_OFFICE_LONGITUDE = -6.257664;

  private static final Logger logger = LogManager.getLogger(CustomerUtil.class);

  /**
   * <p>
   * Method using the Haversine formula to calculate the great-circle distance between customer
   * location do Dublin office by the latitude and longitude coordinates.</p>
   *
   * @param endLati Final latitude
   * @param endLong Final longitude
   * @return The distance in Kilometers (Km)
   */
  public static double getDistanceToDublinOfficeInKm(double endLati, double endLong) {

    logger.debug("Calculating customer distance to Dublin office..");
    double diffLati = Math.toRadians(endLati - DUBLIN_OFFICE_LATITUDE);
    double diffLong = Math.toRadians(endLong - DUBLIN_OFFICE_LONGITUDE);
    double radiusStartLati = Math.toRadians(DUBLIN_OFFICE_LATITUDE);
    double radiusEndLati = Math.toRadians(endLati);

    // A and C are the 'sides' from the spherical triangle.
    double a = Math.pow(Math.sin(diffLati / 2), 2) + Math.pow(Math.sin(diffLong / 2), 2) * Math
        .cos(radiusStartLati) * Math.cos(radiusEndLati);
    double c = 2 * Math.asin(Math.sqrt(a));

    return EARTH_RADIUS_IN_KM * c;
  }

  /**
   * Find customers within given distance to Dublin office
   *
   * @return a map of matched customers
   */
  public static Map<Long, String> findMatchingCustomers(List<Customer> customers, Double distance) {

    TreeMap<Long, String> matchingCustomersMap = new TreeMap<>();

    for (Customer customer : customers) {
      if (getDistanceToDublinOfficeInKm(customer.getLatitude(), customer.getLongitude())
          <= distance) {
        matchingCustomersMap.put(customer.getUser_id(), customer.getName());
      }
    }

    logger.info("Matched customers without sorting yet are found");
    return matchingCustomersMap;

  }
}
