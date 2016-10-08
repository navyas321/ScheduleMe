package com.scheduler.android.scheduleme;


import android.annotation.TargetApi;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;

import java.sql.Array;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_SCHEDULE_START_TIME;

public class Course {


    public Course(String courseName, int creditHours, String lectureLocation, String discussionLocation, String labLocation, Schedule courseSchedule, ArrayList<Date> impDates, ArrayList<String> infoImpDates, ArrayList<Office_Hours> office_hours, boolean lectureComponent, boolean discussionComponent, boolean labComponent) {
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.lectureLocation = lectureLocation;
        this.discussionLocation = discussionLocation;
        this.labLocation = labLocation;
        this.courseSchedule = courseSchedule;
        this.impDates = impDates;
        this.infoImpDates = infoImpDates;
        this.office_hours = office_hours;
        this.lectureComponent = lectureComponent;
        this.discussionComponent = discussionComponent;
        this.labComponent = labComponent;
    }

    enum Day {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY, NONE}

    public Course(String courseName, int creditHours, String lectureLocation, String discussionLocation, String labLocation, boolean lectureComponent, boolean labComponent, boolean discussionComponent) {
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.lectureLocation = lectureLocation;
        this.discussionLocation = discussionLocation;
        this.labLocation = labLocation;
        this.lectureComponent = lectureComponent;
        this.labComponent = labComponent;
        this.discussionComponent = discussionComponent;
    }

    public Course() {

    }

    public String getCourseName() {
        return courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public String getLectureLocation() {
        return lectureLocation;
    }

    public String getDiscussionLocation() {
        return discussionLocation;
    }

    public String getLabLocation() {
        return labLocation;
    }

    public Schedule getCourseSchedule() {
        return courseSchedule;
    }

    public ArrayList<Date> getImpDates() {
        return impDates;
    }

    public ArrayList<String> getInfoImpDates() {
        return infoImpDates;
    }

    public boolean hasLectureComponent() {
        return lectureComponent;
    }

    public boolean hasDiscussionComponent() {
        return discussionComponent;
    }

    public boolean hasLabComponent() {
        return labComponent;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public void setLectureLocation(String lectureLocation) {
        this.lectureLocation = lectureLocation;
    }

    public void setDiscussionLocation(String discussionLocation) {
        this.discussionLocation = discussionLocation;
    }

    public void setLabLocation(String labLocation) {
        this.labLocation = labLocation;
    }

    public void setCourseSchedule(Schedule courseSchedule) {
        this.courseSchedule = courseSchedule;
    }

    public void setImpDates(ArrayList<Date> impDates) {
        this.impDates = impDates;
    }

    public void setInfoImpDates(ArrayList<String> infoImpDates) {
        this.infoImpDates = infoImpDates;
    }

    public void setLectureComponent(boolean lectureComponent) {
        this.lectureComponent = lectureComponent;
    }

    public void setDiscussionComponent(boolean discussionComponent) {
        this.discussionComponent = discussionComponent;
    }

    public void setLabComponent(boolean labComponent) {
        this.labComponent = labComponent;
    }

    private String courseName; //FORMAT: "<dept acronym>-<course number>" eg. "CS-296"

    private int creditHours;

    private String lectureLocation;
    private String discussionLocation;
    private String labLocation;

    private Schedule courseSchedule;

    private ArrayList<Date> impDates;
    private ArrayList<String> infoImpDates; //these two should be the same size.

    public ArrayList<Office_Hours> getOffice_hours() {
        return office_hours;
    }

    public void setOffice_hours(ArrayList<Office_Hours> office_hours) {
        this.office_hours = office_hours;
    }

    private ArrayList<Office_Hours> office_hours;

    //need to figure a way to store office hours, important dates and syllabus.


    private boolean lectureComponent; //To validate if a lecture component exists
    private boolean discussionComponent; //To validate if a discussion component exists
    private boolean labComponent; //To validate if a lab component exists to the course

    public class Office_Hours{
        public Day getDay() {
            return day;
        }

        public void setDay(Day day) {
            this.day = day;
        }

        public Time getStartTime() {
            return startTime;
        }

        public void setStartTime(Time startTime) {
            this.startTime = startTime;
        }

        public Time getEndTime() {
            return endTime;
        }

        public void setEndTime(Time endTime) {
            this.endTime = endTime;
        }

        public String getInstructor_name() {
            return instructor_name;
        }

        public void setInstructor_name(String instructor_name) {
            this.instructor_name = instructor_name;
        }

        private Day day;
        private Time startTime;
        private Time endTime;
        private String instructor_name;

        public Office_Hours() {

        }

        public Office_Hours(Day day, Time startTime, Time endTime, String instructor_name) {
            this.day = day;
            this.startTime = startTime;
            this.endTime = endTime;
            this.instructor_name = instructor_name;
        }
    }

    public class Schedule{

        public Schedule(ArrayList<Lecture> lectures, ArrayList<Discussion> discussions, ArrayList<Lab> labs) {
            this.lectures = lectures;
            this.discussions = discussions;
            this.labs = labs;
        }

        public class Lecture{
            public Day getDay() {
                return day;
            }

            public void setDay(Day day) {
                this.day = day;
            }

            public Time getStartTime() {
                return StartTime;
            }

            public void setStartTime(Time startTime) {
                StartTime = startTime;
            }

            public Time getEndTime() {
                return EndTime;
            }

            public void setEndTime(Time endTime) {
                EndTime = endTime;
            }

            private Day day;
            private Time StartTime;
            private Time EndTime;

            public Lecture() {

            }

            public Lecture(Day day, Time startTime, Time endTime) {
                this.day = day;
                this.StartTime = startTime;
                this.EndTime = endTime;
            }

            @TargetApi(Build.VERSION_CODES.N)
            public Lecture(String day, String startTime, String endTime) throws Exception{
                this.day = dayParser(day);
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
                this.StartTime = new java.sql.Time(formatter.parse(startTime).getTime());
                this.EndTime = new java.sql.Time(formatter.parse(endTime).getTime());
            }
        }

        public class Discussion{
            public Day getDay() {
                return day;
            }

            public void setDay(Day day) {
                this.day = day;
            }

            public Time getStartTime() {
                return StartTime;
            }

            public void setStartTime(Time startTime) {
                StartTime = startTime;
            }

            public Time getEndTime() {
                return EndTime;
            }

            public void setEndTime(Time endTime) {
                EndTime = endTime;
            }

            private Day day;
            private Time StartTime;
            private Time EndTime;

            public Discussion() {

            }

            public Discussion(Day day, Time startTime, Time endTime) {
                this.day = day;
                this.StartTime = startTime;
                this.EndTime = endTime;
            }
        }

        public class Lab {
            public Day getDay() {
                return day;
            }

            public void setDay(Day day) {
                this.day = day;
            }

            public Time getStartTime() {
                return StartTime;
            }

            public void setStartTime(Time startTime) {
                StartTime = startTime;
            }

            public Time getEndTime() {
                return EndTime;
            }

            public void setEndTime(Time endTime) {
                EndTime = endTime;
            }

            private Day day;
            private Time StartTime;
            private Time EndTime;
            public Lab() {

            }

            public Lab(Day day, Time startTime, Time endTime) {
                this.day = day;
                this.StartTime = startTime;
                this.EndTime = endTime;
            }
        }

        ArrayList<Lecture> lectures;
        ArrayList<Discussion> discussions;
        ArrayList<Lab> labs;

        public ArrayList<Lecture> getLectures() {
            return lectures;
        }

        public void setLectures(ArrayList<Lecture> lectures) {
            this.lectures = lectures;
        }

        public ArrayList<Discussion> getDiscussions() {
            return discussions;
        }

        public void setDiscussions(ArrayList<Discussion> discussions) {
            this.discussions = discussions;
        }

        public ArrayList<Lab> getLabs() {
            return labs;
        }

        public void setLabs(ArrayList<Lab> labs) {
            this.labs = labs;
        }






    }

    public static Day dayParser(String day) {
        if (day.equalsIgnoreCase("M") || day.equalsIgnoreCase("MONDAY") || day.equalsIgnoreCase("MON")) {
            return Day.MONDAY;
        }
        else if (day.equalsIgnoreCase("T") || day.equalsIgnoreCase("TUESDAY") || day.equalsIgnoreCase("TUE")) {
            return Day.TUESDAY;
        }
        else if (day.equalsIgnoreCase("W") || day.equalsIgnoreCase("WEDNESDAY") || day.equalsIgnoreCase("WED")) {
            return Day.WEDNESDAY;
        }
        else if (day.equalsIgnoreCase("R") || day.equalsIgnoreCase("THURSDAY") || day.equalsIgnoreCase("THUR")) {
            return Day.THURSDAY;
        }
        else if (day.equalsIgnoreCase("F") || day.equalsIgnoreCase("FRIDAY") || day.equalsIgnoreCase("FRI")) {
            return Day.FRIDAY;
        }
        else if (day.equalsIgnoreCase("SA") || day.equalsIgnoreCase("SATURDAY") || day.equalsIgnoreCase("SAT")) {
            return Day.SATURDAY;
        }
        else if (day.equalsIgnoreCase("SU") || day.equalsIgnoreCase("SUNDAY") || day.equalsIgnoreCase("SUN")) {
            return Day.SUNDAY;
        }
        else return Day.NONE;
    }


}
