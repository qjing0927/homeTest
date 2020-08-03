package util;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArgsValidator {

  private static final Logger logger = LogManager.getLogger(ArgsValidator.class);

  public static void validate(String[] args) throws Exception {
    if (args == null || args.length != 2 || StringUtils.isEmpty(args[0]) || StringUtils
        .isEmpty(args[1])) {
      logger.error("invalid input or output file arguments");
      throw new Exception("invalid arguments supplied");
    }
  }
}
