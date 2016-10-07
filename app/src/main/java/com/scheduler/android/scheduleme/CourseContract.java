package com.scheduler.android.scheduleme;

import android.provider.BaseColumns;

/**
 * Created by Navid on 9/30/2016.
 */
public class CourseContract {
    public CourseContract(){}

    public static abstract class DataEntry implements BaseColumns {
        public static String DATABASE_NAME = "scheduleMe";
        public static String TABLE_NAME_COURSES = "courses";
        public static String COLUMN_COURSE_NO = "courseNo";
        public static String COLUMN_CREDIT_HRS = "creditHrs";
        public static String COLUMN_COURSE_NAME = "courseName";
        //public static String COLUMN_SCHEDULE_ID = "scheduleID";
        //public static String COLUMN_IMP_DATES_ID = "impDatesID";
        //public static String COLUMN_OFFICE_HOURS_ID = "officeHoursID";
        public static String TABLE_NAME_IMP_DATES = "impDates";
        public static String COLUMN_IMP_DATES_ASSOCIATED_COURSE = "impDatesAssociatedCourse";
        public static String COLUMN_IMP_DATES_INFO = "info";
        public static String COLUMN_IMP_DATES_DATE = "date";
        public static String COLUMN_IMP_DATES_SR_NO = "sr_no";
        public static String TABLE_NAME_OFFICE_HOURS = "officeHours";
        public static String COLUMN_OFFICE_HOURS_ASSOCIATED_COURSE = "officeHoursAssociatedCourse";
        public static String COLUMN_OFFICE_HOURS_DAY = "officeHoursDay";
        public static String COLUMN_OFFICE_HOURS_START_TIME = "officeHoursStartTime";
        public static String COLUMN_OFFICE_HOURS_END_TIME = "officeHoursEndTime";
        public static String COLUMN_OFFICE_HOURS_INSTR_NAME = "officeHoursInstrName";
        public static String TABLE_NAME_SCHEDULE = "schedule";
        public static String COLUMN_SCHEDULE_SR_NO = "schedule_sr_no";
        public static String COLUMN_SCHEDULE_ASSOCIATED_COURSE = "schedule_associated_course";
        public static String COLUMN_SCHEDULE_COMPONENT = "component";
        public static String COLUMN_SCHEDULE_START_TIME = "startTime";
        public static String COLUMN_SCHEDULE_END_TIME = "endTime";
        public static String COLUMN_SCHEDULE_DAYS = "scheduleDays";
    }
}
