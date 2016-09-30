package com.scheduler.android.scheduleme;

import android.provider.BaseColumns;

/**
 * Created by Navid on 9/30/2016.
 */
public class CourseContract {
    public CourseContract(){}

    public static abstract class DataEntry implements BaseColumns {
        public static String TABLE_NAME_COURSES = "courses";
        public static String COLUMN_SCHEDULE_ID = "scheduleID";
        public static String COLUMN_IMP_DATES_ID = "impDatesID";
        public static String COLUMN_OFFICE_HOURS_ID = "officeHoursID";
        public static String COLUMN_NO_OF_COURSES = "noOfCourses";
        public static String TABLE_NAME_IMP_DATES = "impDates";
        public static String COLUMN_IMP_DATES_INFO = "info";
        public static String COLUMN_IMP_DATES_DATA = "data";
        public static String TABLE_NAME_OFFICE_HOURS = "officeHours";
        public static String COLUMN_OFFICE_HOURS_DAY = "officeHoursDay";
        public static String COLUMN_OFFICE_HOURS_START_TIME = "officeHoursStartTime";
        public static String COLUMN_OFFICE_HOURS_END_TIME = "officeHoursEndTime";
        public static String COLUMN_OFFICE_HOURS_NAME = "officeHoursName";
        public static String TABLE_NAME_SCHEDULE = "schedule";
        public static String COLUMN_SCHEDULE_COMPONENT = "component";
        public static String COLUMN_SCHEDULE_START_TIME = "startTime";
        public static String COLUMN_SCHEDULE_END_TIME = "endTime";
        public static String COLUMN_SCHEDULE_DATES = "scheduleDates";
    }
}