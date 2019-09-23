// Author: Marina Moreno
// Class 463
// Date: September 16, 2019

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class EmployeeSet 
{
	// 1. Instance variables
    Employee[] AllEmployees;
    int TotalEmployees;

    // 2. Constructor
    // Functionality: Initialize Employee Set instance, sets capacity to 10 and creates an array to store 10 employee objects
    // Parameters: N/A
    // Return Values: N/A
    // Preconditions: N/A
    public EmployeeSet() 
    {
        AllEmployees = new Employee[10];
        TotalEmployees = 0;
    }

    // 3. Copy Constructor
    // Functionality: Create a new EmployeeSet instance and copies the content of the given object to the new instance
    // Parameters: An Object
    // Return Values: N/A
    // Preconditions: Object should not be null and should be an instance of EmployeeSet
    public EmployeeSet(Object obj) 
    {
        if (obj == null) 
            System.out.println("EmployeeSet Copy Constructor: Object is null");
        else
        {
	        if (obj instanceof EmployeeSet) 
	        {	            
	            EmployeeSet CopyEmployeeSet = (EmployeeSet)obj;
		        AllEmployees = CopyEmployeeSet.AllEmployees;
		        TotalEmployees = CopyEmployeeSet.TotalEmployees;
	        }
	        else
	        	System.out.println("EmployeeSet Copy Constructor: Object is not an instance of EmployeeSet");
        }
    }
    
    // 4. Size method
    // Functionality: Returns the actual number of elements in this collection
    // Parameters: N/A
    // Return Values: Integer of Total Employees
    // Preconditions: N/A
    public int size() {return TotalEmployees;}

    // 5. Capacity method
    // Functionality: Returns the capacity of this collections instance
    // Parameters: N/A
    // Return Values: Integer of EmployeeSet instance lenght
    // Preconditions: N/A
    public int capacity() {return AllEmployees.length;}
    
    // 6. Add method
    // Functionality: Adds one given Employee to the first available space of the employee array in this EmployeeSet instance.
    // Parameters: Employee object
    // Return Values: N/A
    // Preconditions: Employee object should not be null.
    public void add(Employee a) 
    {
        if (a == null) 
            System.out.println("Method 'add': Employee Object is NULL");
        else
        {
	        if (TotalEmployees >= AllEmployees.length) 
	            ensureCapacity(TotalEmployees * 2);
	        AllEmployees[TotalEmployees] = a;
	        TotalEmployees++;
        }
    }

    // 7. Contains method
    // Functionality: Check wether this collection contains the input parameter
    // Parameters: Employee object
    // Return values: Boolean. False if object is null or is not contained in the collection. True if the object is contained in the collection
    // Preconditions: N/A
    public boolean contains(Employee a) 
    {
        boolean result = false;
        
        if (a == null) 
            result = false;
        else 
        {
        	int i = 0;
        	
        	while(AllEmployees[i] != a && i < TotalEmployees)
        		i++;
            if (i == TotalEmployees) 
                result = false;       
            if (i < TotalEmployees) 
                result = true;            
        }
        return result;
    }

    // 8. Remove method
    // Functionality: Remove from the collection the employee with the given employee number
    // Parameters: Integer Employee Number
    // Return Values: Boolean. True if the employee was removed. False if the employee was not removed from collection
    // Preconditions: N/A
    public boolean remove(int eno) 
    {
        boolean result = false;
        int i = 0;
        
        while (AllEmployees[i].Employee_No != eno && i < TotalEmployees) 
            i++;        
        if (i == TotalEmployees) 
            result = false;     
        if (i < TotalEmployees) 
        {
            AllEmployees[i] = AllEmployees[TotalEmployees - 1];
            result = true;
            --TotalEmployees;
        }
        return result;
    }

    // 9. Ensure capacity
    // Functionality: Guarantees the capacity of the collection
    // Parameters: int minimum capacity
    // Return Values: N/A
    // Preconditions: Capacity should be positive
    public void ensureCapacity(int minimumCapacity) 
    {
        if (minimumCapacity > 0)
        {
        	if(AllEmployees.length < minimumCapacity)
        	{
	            Employee[] BiggerEmployeeArray = new Employee[minimumCapacity];
	            for (int i = 0; i < TotalEmployees; ++i) 
	            {
	                BiggerEmployeeArray[i] = AllEmployees[i];
	            }
	            AllEmployees = BiggerEmployeeArray;
        	}
        }
        else
        	System.out.println("minimumCapacity equals zero or is negative");
    };
    
    // 10. addOrdered method
    // Functionality: Adds one employee object to this EmployeeSet instance such that the object in the array are in ascending order of employee numbers.
    // Parameters: integer Employee Number
    // Return Values: N/A
    // Preconditions: Employee object should not be null and objects are already in ascending order
    public void addOrdered(Employee a)
    {
    	// First, order the current Employee Set
    	orderArray();
    	
    	// Second. Ensure capacity
    	if (TotalEmployees == AllEmployees.length) 
            ensureCapacity(TotalEmployees * 2);
    	
    	// Third. Add Employee to EmployeeSet
        AllEmployees[TotalEmployees] = a;
        TotalEmployees++;
        
        // Fourth. Order Array
        orderArray();
    }
    
    // (Extra) Order method
    // Functionality: Accomodate all elements from EmployeeSet in ascending order using the employee numbers
    // Parameters: N/A
    // Return Values: N/A
    // Preconditions: EmployeeSet should have at least two Employees
    public void orderArray()
    {
    	boolean flag = true;
    	Employee Temp;
    	
    	if (TotalEmployees >= 2)
    	{
	    	while(flag)
	    	{
	    		flag = false;
	    		for(int i = 0; i < (TotalEmployees-1);i++)
	    		{
	    			if(AllEmployees[i].Employee_No > AllEmployees[i+1].Employee_No)
	    			{
	    				Temp = AllEmployees[i];
	    				AllEmployees[i] = AllEmployees[i+1];
	    				AllEmployees[i+1] = Temp;
	    				flag = true;
	    			}
	    		}
	    	}
    	}
    }
    
    // (Extra) Read file
    // Functionality: Read a file
    // Parameters: String File name from the desired archive
    // Return Values: N/A
    // Preconditions: N/A
    public void read(String fname)
	{
		int row_number = 0;
		String row = "";
		
		try 
		{
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fname);

            // Always wrap FileReader in BufferedReader.
            BufferedReader csvReader = new BufferedReader(fileReader);

            while((row = csvReader.readLine()) != null) 
            {
            	String[] lineStr = row.split(",");
            	
            	if(row_number >= 1)
            	{
            		Employee EmployeeData = new Employee();
            		EmployeeData.setEmployee_Name(lineStr[0]+lineStr[1]);
            		EmployeeData.setEmployee_No(Integer.parseInt(lineStr[2]));
            		add(EmployeeData);
            	}
            	row_number++;            	
            }
            csvReader.close();
		}
		
        catch(FileNotFoundException ex)  
		{
            System.out.println("Unable to open file '" +  fname + "'");                
        }
		
		catch(IOException ex) 
		{
            System.out.println("Error reading file '" + fname + "'");                  
        }
		System.out.println("Finish file "+ fname);
	}

    public static void main(String[] arrstring) 
    {
        System.out.println("Create a Null EmployeeSet");
        EmployeeSet NullEmployeeSet = new EmployeeSet();
        NullEmployeeSet = null;
        
        System.out.println("Catch NullEmployeeSet is NULL using copy constructor");
        EmployeeSet CopyEmployeeSet = new EmployeeSet(NullEmployeeSet);
        
        System.out.println("\nCreate a Employee 'Random Employee'");
        Employee RandomEmployee = new Employee();
        System.out.println("Use EmployeeSet copy constructor with RandomEmployee and verify is not and instance from EmployeeSet");
        EmployeeSet employeeSet3 = new EmployeeSet(RandomEmployee);
        
        System.out.println("\nCreate an EmployeeSet 'FirstEmployeeSet'");
        EmployeeSet FirstEmployeeSet = new EmployeeSet();
        System.out.println("Create a copy of FirstEmployeeSet");
        EmployeeSet CopyFirstEmployeeSet = new EmployeeSet(FirstEmployeeSet);
        System.out.println("Verify CopyFirstEmployeeSet capacity equals 10");
        System.out.println("CopyFirstEmployeeSet Capacity = " + CopyFirstEmployeeSet.capacity());
        System.out.println("Verify AllEmployes[] from CopyFirstEmployeeSet is an array of 10 elements");
        System.out.println("Lenght of CopyFirstEmployee.AllEmployes[] = " + CopyFirstEmployeeSet.AllEmployees.length);
        
        System.out.println("\nCreate a Null Employee");
        Employee NullEmployee = new Employee();
        NullEmployee = null;
        System.out.println("Add NullEmployee to FirstEmployeeSet using add() method and verify it identifies the Employee object as NULL");
        FirstEmployeeSet.add(NullEmployee);
        
        System.out.println("\nGet the current capacity of FirstEmployeeSet");
        System.out.println("FirstEmployeeSet Capacity = " + FirstEmployeeSet.capacity());
        
        System.out.println("\nCreate 16 Employees with different Employee Numbers");
        Employee Employee_0 = new Employee();
        Employee_0.setEmployee_No(0);
        Employee_0.setEmployee_Name("Marina");
        Employee Employee_1 = new Employee();
        Employee_1.setEmployee_No(1);
        Employee_1.setEmployee_Name("Jaime");
        Employee Employee_2 = new Employee();
        Employee_2.setEmployee_No(2);
        Employee_2.setEmployee_Name("Tania");
        Employee Employee_3 = new Employee();
        Employee_3.setEmployee_No(3);
        Employee_3.setEmployee_Name("Manuel");
        Employee Employee_4 = new Employee();
        Employee_4.setEmployee_No(4);
        Employee_4.setEmployee_Name("Alejandro");
        Employee Employee_5 = new Employee();
        Employee_5.setEmployee_No(5);
        Employee_5.setEmployee_Name("Victor");
        Employee Employee_6 = new Employee();
        Employee_6.setEmployee_No(6);
        Employee_6.setEmployee_Name("Sam");
        Employee Employee_7 = new Employee();
        Employee_7.setEmployee_No(7);
        Employee_7.setEmployee_Name("Gordita");
        Employee Employee_8 = new Employee();
        Employee_8.setEmployee_No(8);
        Employee_8.setEmployee_Name("Carmen");
        Employee Employee_9 = new Employee();
        Employee_9.setEmployee_No(9);
        Employee_9.setEmployee_Name("Adriana");
        Employee Employee_10 = new Employee();
        Employee_10.setEmployee_No(10);
        Employee_10.setEmployee_Name("Mario");
        Employee Employee_11 = new Employee();
        Employee_11.setEmployee_No(11);
        Employee_11.setEmployee_Name("Sarellano");
        Employee Employee_12 = new Employee();
        Employee_12.setEmployee_No(12);
        Employee_12.setEmployee_Name("Ellian");
        Employee Employee_13 = new Employee();
        Employee_13.setEmployee_No(13);
        Employee_13.setEmployee_Name("Moran");
        Employee Employee_14 = new Employee();
        Employee_14.setEmployee_No(14);
        Employee_14.setEmployee_Name("Lidia");
        Employee Employee_15 = new Employee();
        Employee_15.setEmployee_No(15);
        Employee_15.setEmployee_Name("Cecilia");
        
        System.out.println("\nUse Contains method with a Null Employee and verify it returns false");
        System.out.println("Contains Method Result = " + FirstEmployeeSet.contains(NullEmployee));
        
        System.out.println("\nUse Contains method with any created valid employee and FirstEmployeeSet empty. Verify method returns false");
        System.out.println("Contains Method Result = " + FirstEmployeeSet.contains(Employee_2));
        System.out.println("Contains Method Result = " + FirstEmployeeSet.contains(Employee_15));
        
        System.out.println("\nAdd five employees to FirstEmployeeSet");
        FirstEmployeeSet.add(Employee_0);
        FirstEmployeeSet.add(Employee_15);
        FirstEmployeeSet.add(Employee_2);
        FirstEmployeeSet.add(Employee_9);
        FirstEmployeeSet.add(Employee_3);
        
        System.out.println("Use Contains method with Employee 0, 2 and 15. Verify method returns true");
        System.out.println("Contains Method Result = " + FirstEmployeeSet.contains(Employee_0));
        System.out.println("Contains Method Result = " + FirstEmployeeSet.contains(Employee_2));
        System.out.println("Contains Method Result = " + FirstEmployeeSet.contains(Employee_15));
        
        System.out.println("\nAdd five employees to FirstEmployeeSet and verify its capacity equals 10");
        FirstEmployeeSet.add(Employee_4);
        FirstEmployeeSet.add(Employee_14);
        FirstEmployeeSet.add(Employee_6);
        FirstEmployeeSet.add(Employee_1);
        FirstEmployeeSet.add(Employee_7);
        System.out.println("FirstEmployeeSet Capacity = " + FirstEmployeeSet.capacity());
        
        System.out.println("\nAdd another employee to FirstEmployeeSet and verify its capacity is incremented to 20");
        FirstEmployeeSet.add(Employee_5);
        System.out.println("FirstEmployeeSet Capacity = " + FirstEmployeeSet.capacity());
        
        System.out.println("\nAdd the rest of the five employees and verify the capacity of FirstEmployeeSet remains in 20 with 16 employees");        
        FirstEmployeeSet.add(Employee_8);
        FirstEmployeeSet.add(Employee_10);
        FirstEmployeeSet.add(Employee_11);
        FirstEmployeeSet.add(Employee_12);
        FirstEmployeeSet.add(Employee_13);
        System.out.println("FirstEmployeeSet Capacity = " + FirstEmployeeSet.capacity());
        System.out.println("Total Employees = " + FirstEmployeeSet.size());
        
        System.out.println("\nUse Containd method to look for Employee 13 (last element) and verify the method returns True");
        System.out.println("Contains Method Result = " + FirstEmployeeSet.contains(Employee_13));
        
        System.out.println("\nRemove Employee_15");
        System.out.println("Removed Employee_15 = " + FirstEmployeeSet.remove(15));
        for(int i=0;i<FirstEmployeeSet.TotalEmployees;i++)
        {
        	System.out.println("Employee["+i+"] Number = "+FirstEmployeeSet.AllEmployees[i].Employee_No);
        }
        
        System.out.println("\nTry to remove an employee which its employee number is not contained in collection FirstEmployeeSet");
        System.out.println("Employee 16 removed: " + FirstEmployeeSet.remove(16));
        
        System.out.println("\nAdd again to the collection the Employee_15 using the addOrdered method. Verify the collection is in ascending order");
        FirstEmployeeSet.addOrdered(Employee_15);
        for(int i=0;i<FirstEmployeeSet.TotalEmployees;i++)
        {
        	System.out.println("Employee["+i+"] Number = "+FirstEmployeeSet.AllEmployees[i].Employee_No);
        }
        
        System.out.println("\nRemove all employees from the collection. Verify Total Employees = 0 and Capacity = 20");
        FirstEmployeeSet.remove(0);
        FirstEmployeeSet.remove(1);
        FirstEmployeeSet.remove(2);
        FirstEmployeeSet.remove(3);
        FirstEmployeeSet.remove(4);
        FirstEmployeeSet.remove(5);
        FirstEmployeeSet.remove(6);
        FirstEmployeeSet.remove(7);
        FirstEmployeeSet.remove(8);
        FirstEmployeeSet.remove(9);
        FirstEmployeeSet.remove(10);
        FirstEmployeeSet.remove(11);
        FirstEmployeeSet.remove(12);
        FirstEmployeeSet.remove(13);
        FirstEmployeeSet.remove(14);
        FirstEmployeeSet.remove(15);
        FirstEmployeeSet.remove(16);
        System.out.println("FirstEmployeeSet Capacity = " + FirstEmployeeSet.capacity());
        System.out.println("Total Employees = " + FirstEmployeeSet.size());
        
        // 11. Test Case to read file core_dataset.csv and include information from employees to the collection
        System.out.println("\n1. Create a new EmployeeSet called 'EmployeesFile");
        EmployeeSet EmployeesFile = new EmployeeSet();
        
        System.out.println("Fill EmployeesFile with core_dataset.csv and display the employee names and numbers");
        EmployeesFile.read("core_dataset.csv");
     
        for(int i=0;i<EmployeesFile.TotalEmployees;i++)
        {
        	System.out.println("Employee["+i+"] Name = "+EmployeesFile.AllEmployees[i].Employee_Name+"\t"+
        "Number = "+EmployeesFile.AllEmployees[i].Employee_No+"\n");
        }
        
        System.out.println("How many employees exist in the collection?");
        System.out.println("Total Employees = " + EmployeesFile.size());
        
        System.out.println("Which is the collection capacity");
        System.out.println("Capacity = " + EmployeesFile.capacity());
    }
}
