/**
 * Created by sulu on 1/25/17.
 */
public class Salary extends Employee {
    private double salary;

    Salary(String name, String address, int number, double salary) {
        super(name, address, number);
        setSalary(salary);
    }

    public void mailCheck() {
        System.out.println("Within mailCheck of Salary class ");
        System.out.println("Mailing check to " + getName() + " with salary " + salary);
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double newSalary) {
        if(newSalary >= 0.0) {
            this.salary = newSalary;
        }
    }

    public double computePay() {
        System.out.println("Computing salary pay for " + getName());
        return this.salary/52;
    }
}

