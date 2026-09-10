class Employee {
    double basic;

    Employee(double basic) {
        this.basic = basic;
    }

    double getSalary() {
        return basic;
    }

    void display() {
        System.out.println("Basic Salary: Rs. " + basic);
        System.out.println("Total Salary: Rs. " + getSalary());
    }
}

class Driver extends Employee {

    Driver(double basic) {
        super(basic);
    }

    @Override
    double getSalary() {
        return basic + 3000;
    }
}

class Main {
    public static void main(String[] args) {
        Employee employee = new Driver(15000);
        employee.display();
    }
}
