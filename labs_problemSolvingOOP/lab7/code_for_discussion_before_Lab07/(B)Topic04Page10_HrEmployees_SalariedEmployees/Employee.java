public abstract class Employee {
    private String name;
    public Employee(String n) { name = n; }
    public String getName( ) { return name; }

    public abstract double getPay( );
}
