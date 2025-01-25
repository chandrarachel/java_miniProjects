public class Main {
	public static void main(String[] args) {
		Employee x1 = new SalariedEmployee("Kit", 15000);
		Employee x2 = new HourlyEmployee("Jason", 100, 60);

		System.out.println(x1.getName() + " ($" + 
				x1.getPay() + ")");	

		System.out.println(x2.getName() + " ($" + 
				x2.getPay() + ")");	
	}
}

/*
Kit ($1250.0)
Jason ($6000.0)
*/

/*
Employee x = new Employee("Helena");
*/

/*
		Employee[] arr;
		arr = new Employee[3];
		arr[0] = new HourlyEmployee("Helena", 52.5, 30);
		arr[1] = new SalariedEmployee("Kit", 15000);
		arr[2] = new HourlyEmployee("Jason", 100, 60);

		for (Employee e: arr)
			System.out.println(    
				e.getName() + " ($" + 
				e.getPay() + ")");

*/

/*
Helena ($1575.0)
Kit ($1250.0)
Jason ($6000.0)
*/

/*		Employee x1 = new SalariedEmployee("Kit", 15000);
		Employee x2 = new HourlyEmployee("Jason", 100, 60);

		System.out.println(x1.getName() + " ($" + 
				x1.getPay() + ")");	

		System.out.println(x2.getName() + " ($" + 
				x2.getPay() + ")");	
*/

