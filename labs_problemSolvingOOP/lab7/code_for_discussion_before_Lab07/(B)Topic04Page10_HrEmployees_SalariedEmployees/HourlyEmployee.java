public class HourlyEmployee extends Employee {
    private double wageRate; 
    private double hours; //for the month

    public HourlyEmployee(String n, double w, double h) {
         super(n); wageRate = w; hours = h;
    }

    public double getRate( )    {return wageRate;}
    public double getHours( )    {return hours;}

    public double getPay( )  {
        return wageRate*hours;
    }
}