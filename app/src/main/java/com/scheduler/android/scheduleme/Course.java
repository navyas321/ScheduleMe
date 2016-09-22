package com.scheduler.android.scheduleme;


import java.sql.Time;

public class Course {

    enum Day {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

    private String courseName;
    private int creditHours;
    private String lectureLocation;
    private String discussionLocation;
    private String labLocation;
    private Schedule courseSchedule;

    private boolean lectureComponent; //To validate if a lecture component exists
    private boolean discussionComponent; //To validate if a discussion component exists
    private boolean labComponent; //To validate if a lab component exists to the course



    private class Schedule{


        Day[] daysOfTheWeekLecture;
        Day[] daysOfTheWeekDiscussion;
        Day[] daysOfTheWeekLab;

        String lectureStartTime; //FORMAT: "HH:MM"
        String lectureEndTime;

        String discussionStartTime;
        String discussionEndTime;

        String labStartTime;
        String labEndTIme;






    }
}
