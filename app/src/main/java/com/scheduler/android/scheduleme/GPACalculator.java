package com.scheduler.android.scheduleme;

import

public class GPACalculator{
    int length; // entered by user
    String[] grade = new String[length];
    int[] hours = new int[length];
    int oldtotalhours, semtotalhours;
    double oldgpa ;

    System.out.println("Enter GPA hours");
    oldtotalhours = userinput;
    semtotalhours = userinput;
    oldgpa = userinput;

    // until calculate GPA button is pressed
    grade[i] = userinput;
    hours[i] = userinput;
    double points = new double[length];

    switch(grade[i]){
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
    double qualpoints = new double[length];
    double sumqualpoints = 0.0;
    // till all elements are accessed
    qualpoints[i] = points[i] * hours[i];
    sumqualpoints += qualpoints[i];

    double gpa = sumqualpoints / semtotalhours;
    double cumgpa = (oldgpa * oldtotalhours + gpa * semtotalhours) / (oldtotalhours + semtotalhours)
}
