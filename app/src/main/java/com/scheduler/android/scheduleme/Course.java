package com.scheduler.android.scheduleme;


import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Course {

    enum Day {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

    private String courseName; //FORMAT: "<dept acronym>-<course number>" eg. "CS-296"

    private int creditHours;

    private String lectureLocation;
    private String discussionLocation;
    private String labLocation;

    private Schedule courseSchedule;

    private ArrayList<Date> impDates;
    private ArrayList<String> infoImpDates;

    //need to figure a way to store office hours, important dates and syllabus.


    private boolean lectureComponent; //To validate if a lecture component exists
    private boolean discussionComponent; //To validate if a discussion component exists
    private boolean labComponent; //To validate if a lab component exists to the course



    private class Schedule{

        private class Lecture{
            Day day;
            Time StartTime;
            Time EndTime; // Saul
        }

        private class Discuss{
            Day day;
            Time StartTime;
            Time EndTime;
        }

        private class Lab{
            Day day;
            Time StartTime;
            Time EndTime;
        }

        /*Day[] daysOfTheWeekLecture;
        Day[] daysOfTheWeekDiscussion;
        Day[] daysOfTheWeekLab;

        String lectureStartTime; //FORMAT: "HH:MM"
        String lectureEndTime;

        String discussionStartTime;
        String discussionEndTime;

        String labStartTime;
        String labEndTIme;

        public String getLectureStartTIme() {
            return lectureStartTime;
        }
        public String getLectureEndTime() {
            return lectureEndTime;
        }
        public String getDiscussionStartTime() {
            return discussionStartTime;
        }
        public String getDiscussionEndTime() {
            return discussionEndTime;
        }
        public String getLabStartTime() {
            return labStartTime;
        }
        public String getLabEndTIme() {
            return labEndTIme;
        }
        public Day[] getDaysOfTheWeekLecture() {
            return daysOfTheWeekLecture;
        }
        public Day[] getDaysOfTheWeekDiscussion() {
            return daysOfTheWeekDiscussion;
        }
        public Day[] getDaysOfTheWeekLab() {
            return daysOfTheWeekLab;
        }*/



    }


}
