package util;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ArgsValidatorTest {

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void test_NullArgs() throws Exception {
    expectedException.expect(Exception.class);
    ArgsValidator.validate(null);
  }

  @Test
  public void test_InvalidArgs() throws Exception {
    String[] args = {"", ""};
    expectedException.expect(Exception.class);
    ArgsValidator.validate(args);
  }

  @Test
  public void test_MissingArgs0() throws Exception {
    String[] args = {"location1", ""};
    expectedException.expect(Exception.class);
    ArgsValidator.validate(args);
  }

  @Test
  public void test_MissingArgs1() throws Exception {
    String[] args = {"", "location2"};
    expectedException.expect(Exception.class);
    ArgsValidator.validate(args);
  }

  @Test
  public void test_ValidArgs() throws Exception {
    String[] args = {"location1", "location2"};
    ArgsValidator.validate(args);
  }
}
