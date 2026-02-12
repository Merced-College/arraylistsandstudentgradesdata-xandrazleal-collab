import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        //loads CSV file into string
            String listCSV = "courseAndGradesData.csv";

        //Creates two arrays, one for courses, and the other for integer grades 
            ArrayList<Course> courses = new ArrayList<>();
            ArrayList<Integer> grades = new ArrayList<>();

        //Scanner inputs, one for reading the csv file, the other for user input
            Scanner readList = null;
            try {
                readList = new Scanner(new File(listCSV));
            } catch (FileNotFoundException e) {
                System.out.println("Error opening file");
                System.exit(0);
            }

            Scanner userInput = new Scanner(System.in);

            // Skip header lines
            if(readList.hasNextLine()) readList.nextLine();
            if(readList.hasNextLine()) readList.nextLine();
        
            // Process data lines without pre-counting
            while(readList.hasNextLine()){
                courses.add(new Course());
                String[] parts = readList.nextLine().split(",");
                String courseName = parts[0];
                courses.get(courses.size() - 1).setCourseName(courseName);
                
                // Parse grades from columns 1 onwards
                for(int j = 1; j < parts.length; j++){
                    int count = Integer.parseInt(parts[j].trim());
                    grades.add(count);
                    
                    
                }

            

                courses.get(courses.size() - 1).setCourseGrades(grades);
                grades.clear(); // Clear grades for the next course
           
            }
            
           
            //Prints out a new header for the table and calls toString to print the table
            System.out.printf("%30s %7s %7s %7s %7s %7s %7s %7s\n", "Course Name", "A", "B", "C", "D", "F", "Total", "A%");
            for(int i = 0; i < courses.size(); i++){
                System.out.println(courses.get(i).toString());
                System.out.println();
            }


            //finds the top course with the highest percentage of A's, and prints it out.
             Course maxCourse = new Course("None", new ArrayList<Integer>(){{add(0); add(0); add(0); add(0); add(0);}});
            for(int i = 0; i < courses.size()-1; i++){
               if(courses.get(i).getAGrade() > maxCourse.getAGrade() && courses.get(i).Apercentage() >= 100.00){
                    maxCourse = courses.get(i);
                }
            }
            System.out.println("The Top Class is: ");
            System.out.println(maxCourse.toString());

        //Prints out a prompt for the user to find a specific course in the list
        System.out.println("Enter a course name to view details: ");
       String uiClass = userInput.nextLine();
       boolean found = false;

        for  (int j = 0; j < courses.size(); j++){
            if(courses.get(j).getCourseName().equals(uiClass)){
                System.out.println(courses.get(j).toString());
                found = true;
                break;
            }

           
            }
            //Catch all for any unspecified user inputs
        if(!found){
            System.out.println("Course not found.");

            
     }

     //closes scanners
     readList.close();
     userInput.close();
    

        
                
    }

}



