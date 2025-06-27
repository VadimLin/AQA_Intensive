package eu.senla;

import com.github.javafaker.Faker;
import eu.senla.Leave.LeavePage;
import eu.senla.PimPage.PimPage;
import org.junit.jupiter.api.Test;

public class LeaveTest extends BaseTest {
    @Test
    public void addAssignLeaveTest() throws InterruptedException {

        PimPage pimPage = new PimPage(driver);
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String middleName = faker.funnyName().name();
        String fullName = firstName + " " + middleName + " " + lastName;

        loginAsUser();
        pimPage
                .navigateToPimModule()
                .clickAddEmployee()
                .fillEmployeeDetails(firstName, middleName, lastName)
                .saveEmployee();

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
    }
}
