package com.scheduler.android.scheduleme;



public class GPACalculator {
    public static double calculateGPA(int numberOfCourses, int oldTotalHours, int semTotalHours, double oldGPA, int[]hours, String[]grades, boolean overall){
        double points[]=new double[grades.length];
         for(int i=0; i < points.length; i++) {
             switch (grades[i]) {
                 case "A+":
                    points[i] = 4.0; 
                    break;
                 case "A":
                    points[i] = 4.0; 
                    break; 
                case "A-": 
                    points[i] = 3.67;
                     break;
                 case "B+": 
                    points[i] = 3.33;
                     break;
                 case "B": 
                    points[i] = 3.0;
                     break; 
                case "B-":
                     points[i] = 2.67;
                     break; 
                case "C+": 
                    points[i] = 2.33; 
                    break; 
                case "C": 
                    points[i] = 2.0; 
                    break; 
                case "C-":
                     points[i] = 1.67;
                     break; 
                case "D+":
                     points[i] = 1.33; 
                    break; 
                case "D":
                     points[i] = 1.0; 
                    break; 
                case "D-":
                     points[i] = 0.67; 
                    break;
                case "F":
                     points[i] = 0.0;
                     break; 
                case "ABS":
                     points[i] = 0.0;
                     break; 
            }
        }

        double[] qualPoints = new double[points.length];
         double totalQualPoints = 0.0; 
        // till all elements are accessed qualpoints[i]=points[i]*hours[i]; sumqualpoints+=qualpoints[i];  double gpa=sumqualpoints/semtotalhours; double cumgpa=(oldgpa*oldtotalhours+gpa*semtotalhours)/(oldtotalhours+semtotalhours)
        for (int i = 0; i < points.length; i++) {
            qualPoints[i] = points[i] * hours[i];
            totalQualPoints += qualPoints[i];
        }
        double gpa = ((totalQualPoints * (1.0))/(semTotalHours));
        double cumulativeGPA = (((oldGPA * oldTotalHours) + (gpa * semTotalHours))/(oldTotalHours + semTotalHours));

        return overall? cumulativeGPA : gpa;

    }

}


