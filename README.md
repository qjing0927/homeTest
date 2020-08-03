# README
This JAVA application is to read the full list of customers from a file and output the names and user ids of matching customers (within 100km) into an output file, sorted by User ID (ascending)

**It requires 2 input parameters:**
1. Customers.txt file location, for example "~/dir/src/main/resources/customers.txt"
2. Output file location, for example "~/dir/matchedCustomers.txt"

**Outout of this app will be in the configured output file location. Sample output is in this repo with name "matchedCustomers.txt"**


**To run the application, you can eiter**

1. Download the source code, run  run `mvn install` under the root project directory in a command line window, which will also run tests for this application
then run 
`mvn exec:java -Dexec.mainClass="InvitationService" -Dexec.args="~/Documents/intercomTests/src/main/resources/customers.txt ~/intercomTests/matchedCustomers.txt"`

2. Download the source code, and import to Intellij as Maven project, 
- navigate to src/main/java/InvitationService.class, 
- Right click this class -> select "Eidt InvitationService.main()". 
- In the pop up window, input below in Program Arguments
`/Users/meng/Documents/intercomTests/src/main/resources/customers.txt /Users/meng/Documents/intercomTests/matchedCustomers.txt`


**To run test**
1. under the root project directory in a command line window, then run
`mvn test`
2. in Intellij, right click /src/test/java, then select "run all tests"

**Notes:**
  This application uses log4j2 for log configurations. Logs are under he root project directory `/logs` and can be configured uder directory `/src/main/resources/log4j2.xml`
