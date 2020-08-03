package util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import junit.framework.TestCase;
import model.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerUtilTest {

  protected List<Customer> customers;

  @Before
  public void setUp() {
    Customer newCustomer = new Customer();
    newCustomer.setUser_id((long) 1);
    newCustomer.setName("TestUser");
    newCustomer.setLatitude(52.986375);
    newCustomer.setLongitude(-6.043701);

    Customer newCustomer1 = new Customer();
    newCustomer1.setUser_id((long) 2);
    newCustomer1.setName("TestUser2");
    newCustomer1.setLatitude(51.92893);
    newCustomer1.setLongitude(-10.27699);

    Customer newCustomer2 = new Customer();
    newCustomer2.setUser_id((long) 12);
    newCustomer2.setName("TestUser3");
    newCustomer2.setLatitude(53.2451022);
    newCustomer2.setLongitude(-6.238335);

    customers = new LinkedList<>();
    customers.add(newCustomer);
    customers.add(newCustomer1);
    customers.add(newCustomer2);
  }

  @After
  public void tearDown() throws Exception {
    customers = null;
    assertNull(customers);
  }

  @Test
  public void getDistanceToDublinOfficeInKmTest() {
    assertEquals(41.76, CustomerUtil.getDistanceToDublinOfficeInKm(customers.get(0).getLatitude(),
        customers.get(0).getLongitude()), 2);
    assertEquals(313.25, CustomerUtil.getDistanceToDublinOfficeInKm(customers.get(1).getLatitude(),
        customers.get(1).getLongitude()), 2);
    assertEquals(10.56, CustomerUtil.getDistanceToDublinOfficeInKm(customers.get(2).getLatitude(),
        customers.get(2).getLongitude()), 2);
  }


  @Test
  public void findMatchingCustomers() {
    Map<Long, String> actual = CustomerUtil.findMatchingCustomers(customers, 100.0);
    assertTrue(actual instanceof TreeMap);
    assertTrue(actual.size() == 2);
  }
}