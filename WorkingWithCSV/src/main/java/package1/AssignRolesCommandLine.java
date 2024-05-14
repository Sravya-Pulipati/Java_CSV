package package1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class AssignRolesCommandLine {

    public static void main(String[] args) throws CsvValidationException, IOException {

    	//D:\\All_Tasks\\Employee_Details.csv D:\\All_Tasks\\New_Employee_Details.csv 5 "Engineer" "R&D" "MATLAB" "Developer" "IT" "Java"
    	String inputFilePath;
        String outputFilePath;
        String Employee_ID;
        String Designation;
        String Department;
        String Technology;
        String New_Designation;
        String New_Department;
        String New_Technology;
        
        if (args.length != 9) {
            System.out.println("Usage: <inputFilePath> <outputFilePath> <Employee_ID> <Designation> <Department> <Technology> <New_Designation> <New_Department> <New_Technology>");
            return;
        } else {
            inputFilePath = args[0];
            outputFilePath = args[1];
            Employee_ID = args[2].trim();
            Designation = args[3].trim();
            Department = args[4].trim();
            Technology = args[5].trim();
            New_Designation = args[6].trim();
            New_Department = args[7].trim();
            New_Technology = args[8].trim();
        }
	
        try {
			CSVReader csvReader = new CSVReader(new FileReader(inputFilePath));
			CSVWriter csvWriter = new CSVWriter(new FileWriter(outputFilePath));
			String[] lines;
			String[] header = csvReader.readNext();
			int rowCount=0;	
			
			for (int i = 0; i < header.length; i++) 
			{
	            System.out.println("Column " + i + ": " + header[i]);
	        }
			csvWriter.writeNext(header);
			
			System.out.println("The details in the excel are: ");
			while((lines=csvReader.readNext())!=null) 
			{
				rowCount++;
				
				for(int i=0;i<lines.length;i++)  
				{
					System.out.print(lines[i] + " ");
				}
				System.out.println();
								 
				if(Employee_ID.equals(lines[0]) && Designation.equals(lines[2]) && Department.equals(lines[3]) && Technology.equals(lines[4]))
				{
					System.out.println("Found - " + lines[0] + " " + lines[2] + " " + lines[3] + " " + lines[4]);
					lines[0]=Employee_ID;
					lines[2]=New_Designation;
					lines[3]=New_Department;
					lines[4]=New_Technology;
				}
				 csvWriter.writeNext(lines);					 				
			}
			System.out.println("Number of rows " + rowCount);
			System.out.println("Output file created successfully.");
			csvWriter.close(); 
            csvReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
}
}