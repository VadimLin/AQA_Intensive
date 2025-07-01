package eu.senla;

import com.github.javafaker.Faker;
import eu.senla.Endpoints.Endpoints;
import eu.senla.Leave.LeavePage;
import eu.senla.PimPage.PimPage;
import eu.senla.PropertyFile.ReadPropertyFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LeaveTest extends BaseTest {
    private Faker faker = new Faker();
    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String middleName = faker.funnyName().name();
    private String fullName = firstName + " " + middleName + " " + lastName;
    @BeforeEach
    public void addEmployee() {
        PimPage pimPage = new PimPage(driver);

        loginAsUser();
        pimPage
                .navigateToPimModule()
                .clickAddEmployee()
                .fillEmployeeDetails(firstName, middleName, lastName)
                .saveEmployee();
    }
    @Test
    public void addAssignLeaveTest() {


        LeavePage leavePage = new LeavePage();
        final int defaultEntitlementDays = 123;
        leavePage
                .navigateToLeavePage()
                .openEntitlementsMenu()
                .clickAddEntitlements()
                .fillEmployeeName(fullName)
                .clickListbox()
                .openLeaveTypeDropDown("CAN - FMLA")
                .fillEntitlementField(defaultEntitlementDays)
                .clickSaveButton()
                .clickConfirmButton()
                .openAssignLeaveMenu()
                .fillEmployeeName(fullName)
                .clickListbox()
                .openLeaveTypeDropDown("CAN - FMLA")
                .inputDateFrom("2025-01-06")
                .inputDateTo("2025-07-06")
                .clickAssignButton()
                .isConfirmed();

        assertAll(
                () -> assertTrue(
                        driver.getCurrentUrl().contains(ReadPropertyFile.getProperty("BASEURL")
                                + Endpoints.LEAVE_ENDPOINT),
                        "Incorrect Url"),
                () ->    assertEquals(leavePage.getLeaveTitle(), "Assign Leave"));
    }

    @Test
    public void assignLeaveWithEmptyEmployeeTest() {
        LeavePage leavePage = new LeavePage();
        final int defaultEntitlementDays = 123;
        leavePage
                .navigateToLeavePage()
                .openEntitlementsMenu()
                .clickAddEntitlements()
                .fillEmployeeName(fullName)
                .clickListbox()
                .openLeaveTypeDropDown("CAN - FMLA")
                .fillEntitlementField(defaultEntitlementDays)
                .clickSaveButton()
                .clickConfirmButton()
                .openAssignLeaveMenu()
                .fillEmployeeName(fullName)
                .clearEmployeeName()
                .openLeaveTypeDropDown("CAN - FMLA")
                .inputDateFrom("2025-01-06")
                .inputDateTo("2025-07-06")
                .clickAssignButton();

        assertAll(
                () -> assertTrue(
                        driver.getCurrentUrl().contains(ReadPropertyFile.getProperty("BASEURL")
                                + Endpoints.LEAVE_ENDPOINT),
                        "Incorrect Url"),
                () -> assertEquals(ReadPropertyFile.getProperty("REQUIRED_ALERT"), leavePage.getRequiredAlert()),
                () ->    assertEquals(leavePage.getLeaveTitle(), "Assign Leave"));
    }
    @Test
    public void assignLeaveWithEmptyLeaveTypeTest() {
        LeavePage leavePage = new LeavePage();
        final int defaultEntitlementDays = 123;
        leavePage
                .navigateToLeavePage()
                .openEntitlementsMenu()
                .clickAddEntitlements()
                .fillEmployeeName(fullName)
                .clickListbox()
                .openLeaveTypeDropDown("CAN - FMLA")
                .fillEntitlementField(defaultEntitlementDays)
                .clickSaveButton()
                .clickConfirmButton()
                .openAssignLeaveMenu()
                .fillEmployeeName(fullName)
                .clickListbox()
                .inputDateFrom("2025-01-06")
                .inputDateTo("2025-07-06")
                .clickAssignButton();

        assertAll(
                () -> assertTrue(
                        driver.getCurrentUrl().contains(ReadPropertyFile.getProperty("BASEURL")
                                + Endpoints.LEAVE_ENDPOINT),
                        "Incorrect Url"),
                () -> assertEquals(ReadPropertyFile.getProperty("REQUIRED_ALERT"), leavePage.getRequiredAlert()),
                () ->    assertEquals(leavePage.getLeaveTitle(), "Assign Leave"));
    }
    @Test
    public void assignLeaveWithEmptyDatesTest() {
        LeavePage leavePage = new LeavePage();
        final int defaultEntitlementDays = 123;
        leavePage
                .navigateToLeavePage()
                .openEntitlementsMenu()
                .clickAddEntitlements()
                .fillEmployeeName(fullName)
                .clickListbox()
                .openLeaveTypeDropDown("CAN - FMLA")
                .fillEntitlementField(defaultEntitlementDays)
                .clickSaveButton()
                .clickConfirmButton()
                .openAssignLeaveMenu()
                .fillEmployeeName(fullName)
                .clickListbox()
                .openLeaveTypeDropDown("CAN - FMLA")
                .clickAssignButton();

        assertAll(
                () -> assertTrue(
                        driver.getCurrentUrl().contains(ReadPropertyFile.getProperty("BASEURL")
                                + Endpoints.LEAVE_ENDPOINT),
                        "Incorrect Url"),
                () -> assertEquals(ReadPropertyFile.getProperty("REQUIRED_ALERT"), leavePage.getRequiredAlert()),
                () ->    assertEquals(leavePage.getLeaveTitle(), "Assign Leave"));
    }
}
