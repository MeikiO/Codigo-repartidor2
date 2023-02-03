
import org.fluttercode.datafactory.impl.DataFactory;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDataAccess {

    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        String[] depts = {"IT", "Account", "Admin", "Sales"};
        DataFactory df = new DataFactory();
        for (int i = 1; i <= 30; i++) {
            Employee e = new Employee();
            e.setName(df.getName());
            e.setAddress(df.getAddress() + ", " + df.getCity());
            e.setDept(df.getItem(depts));
            e.setPhone(df.getNumberText(3) + "-" + df.getNumberText(3) +
                    "-" + df.getNumberText(4));
            list.add(e);
        }
        return list;
    }
}