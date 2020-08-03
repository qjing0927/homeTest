import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import model.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.ArgsValidator;
import util.CustomerUtil;
import util.FileUtil;

public class InvitationService {

  private static final Logger logger = LogManager.getLogger(InvitationService.class);
  private static final Double DISTANCE = 100.0;

  public static void main(String[] args) throws Exception {

    ArgsValidator.validate(args);

    String customerInfoLocation = args[0];

    logger.info("Transform customers.txt to Java Ojbect");
    List<Customer> customers = FileUtil.getCustomersFromJsonFormatTxtFile(customerInfoLocation);

    Map<Long, String> matchingCustomers = CustomerUtil.findMatchingCustomers(customers, DISTANCE);
    logger.info("Matched Customers are found");

    //Output matching customers in Json format
    ObjectMapper objectMapper = new ObjectMapper();
    String customersResult = objectMapper.writerWithDefaultPrettyPrinter()
        .writeValueAsString(matchingCustomers);
    FileUtil.outputMatchingCusomters(customersResult, args[1]);

  }
}
