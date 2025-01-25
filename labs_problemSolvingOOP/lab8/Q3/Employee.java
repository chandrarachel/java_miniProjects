public class Employee{
    private String name;
    private int salary;
    private int annualLeaves;

    public Employee(String n, int s, int al) {
        name=n; salary=s; annualLeaves=al;
    }

    public String getName() {return name;}
    public int getLeaves() {return annualLeaves;}

    public void addSalary(int inc) {salary+=inc;}

    public void changeLeaves(int newLeaves) { annualLeaves = newLeaves; }

    @Override
    public String toString() {
        return name + " ($"+salary+", "+annualLeaves+" days)";
    }
}