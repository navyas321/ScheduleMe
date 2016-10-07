package com.scheduler.android.scheduleme;


import java.sql.Array;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Course {

    enum Day {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

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
    }

    public class Schedule{

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


}
