import java.io.*;
import java.util.Arrays;

public class Employee 
{
	// Instance Variables
	String Employee_Name;
	int Employee_No;
	int Employee_Age;
	String Employee_State;
	int Employee_Zip;
	Integer[] Employee_Advisors = new Integer[3];
	
	// One no-argument constructor
	public Employee()
	{
		Employee_Name = null;
		Employee_State = null;
		Employee_Zip = 0;
		Employee_No = 0;
		Employee_Age = 0;
		Employee_Advisors[0] = null;
	    Employee_Advisors[1] = null;
	    Employee_Advisors[2] = null;	    
	}
	
	// Copy constructor
	public Employee (Object obj)
	{
		if (obj == null)
		{
			System.out.println("Object is null");
			return;
		}
		if (obj instanceof Employee)
		{
			System.out.println("Object is not null and is an instance of Employee Class");
			Employee E = (Employee)obj;
			Employee_Name = E.Employee_Name;
			Employee_No = E.Employee_No;
			Employee_Age = E.Employee_Age;
			Employee_State = E.Employee_State;
			Employee_Zip = E.Employee_Zip;
			Employee_Advisors = E.Employee_Advisors;
		}
	}
	
	// Get methods of all instance variables
	public String getEmployee_Name() {return Employee_Name;}
	public int getEmployee_No() {return Employee_No;}
	public int getEmployee_Age() {return Employee_Age;}
	public String getEmployee_State() {return Employee_State;}
	public int getEmployee_Zip() {return Employee_Zip;}
	public int getEmployee_Advisor(int Advisor_Number) {return Employee_Advisors[Advisor_Number];}
	
	// Set methods of all instance variables
	public void setEmployee_Name(String Name) {this.Employee_Name = Name;}
	public void setEmployee_No(int No) {this.Employee_No = No;}
	public void setEmployee_Age(int Age) {this.Employee_Age = Age;}
	public void setEmployee_State(String State) {this.Employee_State = State;}
	public void setEmployee_Zip(int Zip) {this.Employee_Zip = Zip;}
	public void setEmployee_Advisor(Integer Advisor_No, Integer Advisor_Cel) {this.Employee_Advisors[Advisor_No] = Advisor_Cel;}
	
	// Method to generate a string representation of an employee
	public String toString()
	{
		return("Employee Name = " + Employee_Name + "\n" + 
			   "Employee No = " + Employee_No + "\n" + 
			   "Employee_Age = " + Employee_Age + "\n" + 
			   "Employee_State = " + Employee_State + "\n" + 
			   "Employee_Zip = " + Employee_Zip + "\n" + 
			   "Employee_Advisors" + "\n" + 
			   "\t" + "Advisor 1 = " + Employee_Advisors[0] + "\n" + 
			   "\t" + "Advisor 2 = " + Employee_Advisors[1] + "\n" +
			   "\t" + "Advisor 3 = " + Employee_Advisors[2]);
	}
	
	// equals method 
	public boolean equals(Object obj)
	{
		if (obj instanceof Employee && obj != null) // Object is not null and is an instance of Employee class
		{
			Employee E_Number = (Employee)obj;
			return (E_Number.Employee_No == Employee_No);
		}
		else
			return false;
	}
	
	// method getAllAdvisors
	public static int[] getAllAdvisors(Employee e1, Employee e2)
	{
		int[] DifferentAdvisors = new int[6]; // Create a new array to hold all different advisors from Employee 1 and Employee 2	
		if(e1 != null || e2 != null)
		{
			Integer Value = 0;
			int CounterValue = 0;
			int k = 0;
			Integer[] AllAdvisors = new Integer[6]; // Create a new array to hold all advisors from Employee 1 and Employee 2
			
			// Initialize array AllAdvisors with the current Advisor No's from Employee 1 and Employee 2
			AllAdvisors[0]=e1.Employee_Advisors[0];
			AllAdvisors[1]=e1.Employee_Advisors[1];
			AllAdvisors[2]=e1.Employee_Advisors[2];
			AllAdvisors[3]=e2.Employee_Advisors[0];
			AllAdvisors[4]=e2.Employee_Advisors[1];
			AllAdvisors[5]=e2.Employee_Advisors[2];
			
			for(int i=0;i<6;i++)
			{
				CounterValue = 0;
				Value = AllAdvisors[i];
				for(int j=0;j<6;j++)
				{
					if(Value == AllAdvisors[j] && AllAdvisors[j] != null) // Increment the counter every time Value is found in the array AllAdvisors
						CounterValue++;
				}
				if(CounterValue == 1) // If Value from AllAdvisors is present only once (hence, only present for one Employee), add it to the list of DifferentAdvisors
				{
					DifferentAdvisors[k] = Value;
					k++;
				}
			}
			// Copy DifferentAdvisors array to another Array with length according to the number of different Advisors No's
			int[] DifferentAdvisors_CorrectLenght = new int[k];
			for(int i=0;i<k;i++)
			{
				DifferentAdvisors_CorrectLenght[i] = DifferentAdvisors[i];
			}
			return DifferentAdvisors_CorrectLenght;
		}
		else
		{	
			System.out.println("One or both of the Employees are Null");
			DifferentAdvisors = null;
			return DifferentAdvisors;
		}
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Test Case 1 \nObjective: Verify all Instance Variables are set to null or 0 by using the No-Argument Constructor\n");
		Employee Marina_Moreno = new Employee(); // Create an object of type Employee named Marina_Moreno
		System.out.println(Marina_Moreno.toString() + "\n");
		
		System.out.println("Test Case 2\nObjective: Verify attributes from object Marina_Moreno are copied using Copy Constructor\n");
		Employee Copy_Marina_Moreno= new Employee(Marina_Moreno);
		System.out.println(Copy_Marina_Moreno.toString() + "\n");
		
		System.out.println("Test Case 3\nObjective: Verify all attributes from object Marina_Moreno can be modified and read using methods get and set\n");
		Marina_Moreno.setEmployee_Name("Marina Moreno");
		System.out.println(Marina_Moreno.getEmployee_Name());
		Marina_Moreno.setEmployee_No(92889);
		System.out.println(Marina_Moreno.getEmployee_No());
		Marina_Moreno.setEmployee_Age(29);
		System.out.println(Marina_Moreno.getEmployee_Age());
		Marina_Moreno.setEmployee_State("Chihuahua");
		System.out.println(Marina_Moreno.getEmployee_State());
		Marina_Moreno.setEmployee_Zip(32674);
		System.out.println(Marina_Moreno.getEmployee_Zip());
		Marina_Moreno.setEmployee_Advisor(0,70);
		Marina_Moreno.setEmployee_Advisor(1,115);
		Marina_Moreno.setEmployee_Advisor(2,80);
		System.out.println(Marina_Moreno.getEmployee_Advisor(0));
		System.out.println(Marina_Moreno.getEmployee_Advisor(1));
		System.out.println(Marina_Moreno.getEmployee_Advisor(2));
		
		System.out.println("\nTest Case 4\nObjective: Test again method toString() for Employee object Marina_Moreno\n");
		System.out.println(Marina_Moreno.toString() + "\n");
		
		System.out.println("Create new employee Jaime Candelaria");
		Employee Jaime_Candelaria = new Employee(); // new object Jaime_Candelaria of type Employee
		Jaime_Candelaria.setEmployee_Name("Jaime Candelaria");
		Jaime_Candelaria.setEmployee_No(89456); // Different Employee Number as Marina Moreno
		Jaime_Candelaria.setEmployee_Age(30);
		Jaime_Candelaria.setEmployee_State("Chihuahua");
		Jaime_Candelaria.setEmployee_Zip(33145);
		Jaime_Candelaria.setEmployee_Advisor(0,100);
		Jaime_Candelaria.setEmployee_Advisor(1,115);
		Jaime_Candelaria.setEmployee_Advisor(2,70);
		System.out.println(Jaime_Candelaria.toString()+"\n");
		
		System.out.println("Create new employee Tania Moreno");
		Employee Tania_Moreno = new Employee();
		Tania_Moreno.setEmployee_Name("Tania Moreno");
		Tania_Moreno.setEmployee_No(92889); // Same Employee Number as Marina Moreno
		Tania_Moreno.setEmployee_Age(25);
		Tania_Moreno.setEmployee_State("Chihuahua");
		Tania_Moreno.setEmployee_Zip(32674);
		Tania_Moreno.setEmployee_Advisor(0, 70);
		Tania_Moreno.setEmployee_Advisor(1, 123); // Employee Tania_Moreno only has two advisors, hence Advisor[2] = null
		System.out.println(Tania_Moreno.toString()+"\n");
		
		System.out.println("Test Case 5\nObjective: Using the equals method, compare two Employees Number to verify if they are the same\n"
				+ "Compare Employee No. Marina Moreno with Employee No. Jaime Candelaria");
		System.out.println(Marina_Moreno.equals(Jaime_Candelaria)+"\n");
		
		System.out.println("Test Case 6\nObjective: Using the equals method, compare two Employees Number to verify if they are the same\n"
				+ "Compare Employee No. Marina Moreno with Employee No. Tania Moreno");
		System.out.println(Marina_Moreno.equals(Tania_Moreno)+"\n");
		
		int[] NotCommonAdvisors;
		System.out.println("Test Case 7\nObjective: Using method getAllAdvisors(), obtain in an array all non-common advisors no's between two employees"
				+ "\nCompare Advisors No's from Tania_Moreno and Marina_Moreno Employees");
		NotCommonAdvisors = getAllAdvisors(Tania_Moreno,Marina_Moreno);
		System.out.println(Arrays.toString(NotCommonAdvisors)+"\n");
		
		System.out.println("Test Case 8\nObjective: Using method getAllAdvisors(), obtain in an array all non-common advisors no's between two employees"
				+ "\nCompare Advisors No's from Tania_Moreno and Jaime_Candelaria Employees");
		NotCommonAdvisors = getAllAdvisors(Tania_Moreno,Jaime_Candelaria);
		System.out.println(Arrays.toString(NotCommonAdvisors)+"\n");
		
		System.out.println("Test Case 9\nObjective: Using method getAllAdvisors(), obtain in an array all non-common advisors no's between two employees"
				+ "\nCompare Advisors No's from Marina_Moreno and Jaime_Candelaria Employees");
		NotCommonAdvisors = getAllAdvisors(Marina_Moreno,Jaime_Candelaria);
		System.out.println(Arrays.toString(NotCommonAdvisors)+"\n");
	}

}
