import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import model.Customer;
import org.junit.Test;

public class InvitationServiceTest {

  public static String TEST_FILE_LOCATION = "/Users/meng/Documents/intercomTests/src/test/";

  @Test
  public void invitationServiceTest() throws Exception {
    String args[] = {TEST_FILE_LOCATION + "testCustomers.txt",
        TEST_FILE_LOCATION + "testOutcom.txt"};
    InvitationService.main(args);

    String testCustomers = "{  \"4\" : \"Ian Kehoe\",  \"12\" : \"Christina McArdle\"}";

    BufferedReader reader = new BufferedReader(
        new FileReader(TEST_FILE_LOCATION + "testOutcom.txt"));

    String line = null;
    StringBuilder actual = new StringBuilder();

    while ((line = reader.readLine()) != null) {
      actual.append(line);
    }
    assertEquals(testCustomers, actual.toString());
  }

}