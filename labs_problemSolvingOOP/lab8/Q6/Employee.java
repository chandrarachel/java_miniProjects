public class Employee{
    private String name;
    private int salary;
    private int annualLeaves;

    public Employee(String n, int s, int al) {
        name=n; salary=s; annualLeaves=al;
    }

    public String getName() {return name;}
    public int getLeaves() {return annualLeaves;}
    public int getSalary() {return salary;}

    public void addSalary(int inc) {salary+=inc;}

    public void changeLeaves(int newLeaves) { annualLeaves = newLeaves; }
    public void changeSalaries(int newSalary) { salary = newSalary; }
    public void exchangeSalaries(Employee e2) {
        int salaryE1 = salary;
        int salaryE2 = e2.getSalary();
        int temp;

        temp = salaryE1;
        salaryE1 = salaryE2;
        salaryE2 = temp;


        changeSalaries(salaryE1);
        e2.changeSalaries(salaryE2);
    }

    @Override
    public String toString() {
        return name + " ($"+salary+", "+annualLeaves+" days)";
    }
}