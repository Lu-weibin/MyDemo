/**
 * Created by luwb on 2020/05/20.
 */
public class CompositePatternDemo {

    public static void main(String[] args) {
        Employee ceo = new Employee("John","CEO", 30000);
        Employee headSales = new Employee("Robert","Head Sales", 20000);
        Employee headMarketing = new Employee("Michel","Head Marketing", 20000);
        Employee clerk1 = new Employee("Laura","Marketing", 10000);
        Employee clerk2 = new Employee("Bob","Marketing", 10000);
        Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob","Sales", 10000);

        ceo.add(headSales);
        ceo.add(headMarketing);
        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);
        headMarketing.add(clerk1);
        headMarketing.add(clerk2);
        //打印该组织的所有员工
        System.out.println(ceo);
        for (Employee ceoSubordinate : ceo.getSubordinates()) {
            System.out.println(ceoSubordinate);
            for (Employee employee : ceoSubordinate.getSubordinates()) {
                System.out.println(employee);
            }
        }
    }

}
