package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import model.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileUtil {

  private static final Logger logger = LogManager.getLogger(FileUtil.class);

  /**
   * Transform Json format customers into a list of Java object
   *
   * @return list of customers
   */
  public static List<Customer> getCustomersFromJsonFormatTxtFile(String customerFilelocation)
      throws IOException {

    LinkedList<Customer> customers = new LinkedList<Customer>();
    ObjectMapper objectMapper = new ObjectMapper();

    BufferedReader reader = new BufferedReader(new FileReader(customerFilelocation));
    String line = null;

    while ((line = reader.readLine()) != null) {
      Customer customer = objectMapper.readValue(line, Customer.class);
      customers.add(customer);
    }
    logger.info("Txt File is successfully transformed to list of Java objects");
    reader.close();

    return customers;
  }

  /**
   * output matched customers to a file if provided or output to log
   */
  public static void outputMatchingCusomters(String matchedCustomers, String fileLocation)
      throws IOException {

    logger.debug("Matched Customers are" + matchedCustomers);
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation));
    writer.write(matchedCustomers);
    logger.info("Matched customers information is output to " + fileLocation);
    writer.close();
  }
}

