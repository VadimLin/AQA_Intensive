package eu.senla.suite;

import eu.senla.LoginTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({LoginTest.class})
public class RegressionTests {

}
