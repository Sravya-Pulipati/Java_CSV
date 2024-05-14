**#About Project**
1. This Java program, AssignRolesCommandLine, serves the purpose of processing a CSV file containing employee details. 
2. It accepts command-line arguments specifying the input CSV file path, output CSV file path, as well as criteria for identifying and updating specific employee records within the file. 
3.Upon execution, it reads the input CSV file, searches for employee records matching the specified criteria (employee ID, designation, department, and technology), and updates those records with new designation, department, and technology information.
4.The updated records are then written to the output CSV file, effectively allowing batch modification of employee roles based on specified criteria.

**#Process to execute in command prompt**
* I attatched the required jar file of this project which you can execute using command prompt. Save the jar file in any folder on your pc. From there go to command prompt.
* The provided example is for the data in Example CSV files.

**#Example**

C:\Users\user_name\git\repository\WorkingWithCSV\target>java -jar WorkingWithCSV-0.0.1-SNAPSHOT.jar D:\\All_Tasks\\Employee_Details.csv D:\\All_Tasks\\New_Employee_Details.csv 5 "Engineer" "R&D" "MATLAB" "Developer" "IT" "Java"
