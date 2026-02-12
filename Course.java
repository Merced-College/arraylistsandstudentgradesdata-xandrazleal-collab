/*
Name: Xandra Leal
Date: 02/10/2026
Program: Course Grades Analyzer - Reads CSV grade totals and analyzes a percentages
 */

import java.util.ArrayList;
import java.util.Formatter;

public class Course {
    private String courseName;
    private ArrayList<Integer> courseGrades;
    //StringBuilder and Formatter for toString method
    private StringBuilder sb = new StringBuilder();
    private Formatter sf = new Formatter(sb);

    public Course(String courseName, ArrayList<Integer> courseGrades) {
        this.courseName = courseName;
        this.courseGrades = courseGrades;


    }

    //default constructor

    public Course() {
        this.courseName = "Unknown";
        this.courseGrades = new ArrayList<Integer>();
    }
        //all setters and getters
        

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName){
            this.courseName = courseName;
        }

        public ArrayList<Integer> getCourseGrades(){
            return courseGrades;
            
        }

        public void setCourseGrades(ArrayList<Integer> courseGrades){
            this.courseGrades = new ArrayList<Integer>(courseGrades);
        }
        
        //returns the total number of grades for the course
        public int getTotalGrades(){
            int total = 0;
            for (int value : courseGrades) {
                total += value;
            }

            return total;
        }
            //Returns a formatted String, that includes course name, grades, and A percentage. 
        public String toString(){
            
            sf.format("%30s %7d %7d %7d %7d %7d %7d %7.2f%%", courseName, courseGrades.get(0), courseGrades.get(1), courseGrades.get(2), courseGrades.get(3), courseGrades.get(courseGrades.size() - 1), getTotalGrades(), Apercentage());

            
            
            return sf.toString();

            
        }

        
        //returns the number of A grades for the course
        public int getAGrade(){
            return courseGrades.get(0);
        }
       //calculates and returns the percentage of A's for the course

        public double Apercentage(){

            int total = getTotalGrades();
            if (total == 0)
                return 0.0;

            return (double) courseGrades.get(0)/total * 100;    

            
        }

}