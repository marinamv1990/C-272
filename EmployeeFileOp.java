/*import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;*/

import java.io.*;

class Employee_Attributes
{
	int No_Employees;
	String E_Name;
	String E_Number;
	String E_State;
	String E_Zip;
	String E_Age;
	String E_Sex;
}

public class EmployeeFileOp 
{
	private static Employee_Attributes[] E_Data = null;
	public static void read(String fname)
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
            	E_Data[row_number] = new Employee_Attributes();
            	if(row_number == 0)
            	{
            		E_Data[row_number].E_Name = lineStr[0];
            		E_Data[row_number].E_Number = lineStr[1];
	            	E_Data[row_number].E_State = lineStr[2];
	            	E_Data[row_number].E_Zip = lineStr[3];
	            	E_Data[row_number].E_Age = lineStr[5];
	            	E_Data[row_number].E_Sex = lineStr[6];
            	}
            	else
            	{
	            	E_Data[row_number].E_Name = lineStr[0]+lineStr[1];
	            	E_Data[row_number].E_Number = lineStr[2];
	            	E_Data[row_number].E_State = lineStr[3];
	            	E_Data[row_number].E_Zip = lineStr[4];
	            	E_Data[row_number].E_Age = lineStr[6];
	            	E_Data[row_number].E_Sex = lineStr[7];
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
	
	public static void write(String fname)
	{
		int Employee_Age;
		try 
		{
			File file = new File(fname);
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(E_Data[0].E_Name+","+E_Data[0].E_Number+","+E_Data[0].E_State+","+E_Data[0].E_Zip+","+E_Data[0].E_Age+","+E_Data[0].E_Sex+"\n");
			
			for(int i=1;i<E_Data.length;i++)
			{
				Employee_Age = Integer.parseInt(E_Data[i].E_Age);
				if(Employee_Age <= 30)
					bw.write(E_Data[i].E_Name+","+E_Data[i].E_Number+","+E_Data[i].E_State+","+E_Data[i].E_Zip+","+E_Data[i].E_Age+","+E_Data[i].E_Sex+"\n");
			}

			bw.close();
			fw.close();
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println("Finish file "+ fname);
	}
	
	public static void number_employees(String fname)
	{
		int no_lines=0;
		String lines = "";
		try 
		{
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fname);

            // Always wrap FileReader in BufferedReader.
            BufferedReader csvReader = new BufferedReader(fileReader);

            while((lines = csvReader.readLine()) != null) 
            {
            	no_lines++;
            }
            E_Data = new Employee_Attributes[no_lines];
            System.out.println("Number of employees:"+no_lines);
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
	
	public static void main(String[] args) 
	{
		number_employees("core_dataset.csv");
		read("core_dataset.csv");
		write("young_employee.csv");
	}

}
