public class SalariedEmployee extends Employee {
	private double salary; //annual

	public SalariedEmployee(String n, double s)	{
		super(n); salary = s;
	}

	public double getPay( ) {
		return salary/12;
	}
}