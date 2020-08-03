package util;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import model.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FileUtilTest {

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  protected List<Customer> customers;
  public static String TEST_FILE_LOCATION = "/Users/meng/Documents/intercomTests/src/test/";

  @Before
  public void setUp() {
    Customer newCustomer = new Customer();
    newCustomer.setUser_id((long) 12);
    newCustomer.setName("TestUser");
    newCustomer.setLatitude(52.986375);
    newCustomer.setLongitude(-6.043701);

    Customer newCustomer1 = new Customer();
    newCustomer1.setUser_id((long) 1);
    newCustomer1.setName("TestUser2");
    newCustomer1.setLatitude(51.92893);
    newCustomer1.setLongitude(-10.27699);

    Customer newCustomer2 = new Customer();
    newCustomer2.setUser_id((long) 4);
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
  public void getCustomersFromJsonFormatTxtFile_InvalidFileLocation() throws IOException {
    expectedException.expect(IOException.class);
    FileUtil.getCustomersFromJsonFormatTxtFile("InvalidFileLocation");
  }

  @Test
  public void getCustomersFromJsonFormatTxtFile() throws IOException {
    List<Customer> result = FileUtil
        .getCustomersFromJsonFormatTxtFile(TEST_FILE_LOCATION + "testCustomers.txt");
    assertEquals(3, result.size());
    assertEquals(customers.get(0).getUser_id(), result.get(0).getUser_id());
    assertEquals(customers.get(2).getUser_id(), result.get(1).getUser_id());
    assertEquals(customers.get(1).getUser_id(), result.get(2).getUser_id());
  }

  @Test
  public void outputMatchingCusomters_InvalidOutFileLocation() throws IOException {
    expectedException.expect(IOException.class);
    FileUtil.getCustomersFromJsonFormatTxtFile("InvalidFileLocation");
  }

  @Test
  public void outputMatchingCusomters() throws IOException {
    String testCustomers = "{"
        + "  \"4\" : \"Ian Kehoe\","
        + "  \"5\" : \"Nora Dempsey\","
        + "  \"6\" : \"Theresa Enright\","
        + "  \"8\" : \"Eoin Ahearn\","
        + "}";
    FileUtil.outputMatchingCusomters(testCustomers, TEST_FILE_LOCATION + "testOutcom.txt");

    BufferedReader reader = new BufferedReader(
        new FileReader(TEST_FILE_LOCATION + "testOutcom.txt"));
    String line = reader.readLine();
    assertEquals(line, testCustomers);
  }
}