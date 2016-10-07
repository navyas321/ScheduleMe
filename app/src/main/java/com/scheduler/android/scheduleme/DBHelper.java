package com.scheduler.android.scheduleme;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.sql.Date;
import java.util.ArrayList;

import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_COURSE_NAME;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_COURSE_NO;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_CREDIT_HRS;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_DISCUSSION_COMPONENT;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_DISCUSSION_LOCATION;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_IMP_DATES_ASSOCIATED_COURSE;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_IMP_DATES_DATE;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_IMP_DATES_INFO;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_IMP_DATES_SR_NO;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_LAB_COMPONENT;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_LAB_LOCATION;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_LECTURE_COMPONENT;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_LECTURE_LOCATION;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_OFFICE_HOURS_ASSOCIATED_COURSE;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_OFFICE_HOURS_DAY;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_OFFICE_HOURS_END_TIME;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_OFFICE_HOURS_INSTR_NAME;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_OFFICE_HOURS_START_TIME;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_SCHEDULE_ASSOCIATED_COURSE;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_SCHEDULE_COMPONENT;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_SCHEDULE_DAYS;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_SCHEDULE_END_TIME;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_SCHEDULE_SR_NO;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_SCHEDULE_START_TIME;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.DATABASE_NAME;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.TABLE_NAME_COURSES;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.TABLE_NAME_IMP_DATES;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.TABLE_NAME_OFFICE_HOURS;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.TABLE_NAME_SCHEDULE;

/**
 * Created by sahil1105 on 02/10/16.
 */

public class DBHelper extends SQLiteOpenHelper {

    enum Day {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

    public DBHelper (Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME_COURSES +" (" + COLUMN_COURSE_NAME +" TEXT PRIMARY KEY NOT NULL, "+ COLUMN_COURSE_NO +" INT NOT NULL AUTO INCREMENT, "+ COLUMN_CREDIT_HRS +" INT NOT NULL, "+ COLUMN_LECTURE_LOCATION +" TEXT, "+ COLUMN_DISCUSSION_LOCATION +" TEXT, "+ COLUMN_LAB_LOCATION +" TEXT, "+ COLUMN_LAB_COMPONENT +" INT DEFAULT 0, "+ COLUMN_DISCUSSION_COMPONENT +" INT DEFAULT 0, "+ COLUMN_LAB_COMPONENT +"INT DEFAULT 0)");
        db.execSQL("create table "+ TABLE_NAME_IMP_DATES + " (" + COLUMN_IMP_DATES_ASSOCIATED_COURSE +" TEXT PRIMARY KEY NOT NULL, " + COLUMN_IMP_DATES_DATE +" DATE NOT NULL, " + COLUMN_IMP_DATES_INFO +" TEXT, "+ COLUMN_IMP_DATES_SR_NO +" INT NOT NULL AUTO INCREMENT PRIMARY KEY)");
        db.execSQL("create table "+ TABLE_NAME_OFFICE_HOURS + " (" + COLUMN_OFFICE_HOURS_ASSOCIATED_COURSE +" TEXT PRIMARY KEY NOT NULL, " + COLUMN_OFFICE_HOURS_DAY +" TEXT NOT NULL, " + COLUMN_OFFICE_HOURS_START_TIME +" DATETIME, "+ COLUMN_OFFICE_HOURS_END_TIME +" DATETIME, "+ COLUMN_OFFICE_HOURS_INSTR_NAME +" TEXT)");
        db.execSQL("create table "+ TABLE_NAME_SCHEDULE + " (" + COLUMN_SCHEDULE_SR_NO +" INT NOT NULL AUTO INCREMENT, " + COLUMN_SCHEDULE_ASSOCIATED_COURSE + " TEXT NOT NULL PRIMARY KEY, " + COLUMN_SCHEDULE_COMPONENT +" TEXT NOT NULL, " + COLUMN_SCHEDULE_START_TIME +" DATETIME, " + COLUMN_SCHEDULE_END_TIME +" DATETIME, " + COLUMN_SCHEDULE_DAYS +" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_COURSES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_IMP_DATES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_OFFICE_HOURS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_SCHEDULE);
        onCreate(db);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int insertCourse(Course newCourse) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues_courses = new ContentValues();
        contentValues_courses.put(COLUMN_COURSE_NAME, newCourse.getCourseName());
        contentValues_courses.put(COLUMN_CREDIT_HRS, newCourse.getCreditHours());
        contentValues_courses.put(COLUMN_LECTURE_LOCATION, newCourse.getLectureLocation());
        contentValues_courses.put(COLUMN_DISCUSSION_LOCATION, newCourse.getDiscussionLocation());
        contentValues_courses.put(COLUMN_LAB_LOCATION, newCourse.getLabLocation());
        contentValues_courses.put(COLUMN_LECTURE_COMPONENT, newCourse.hasLectureComponent()? 1 : 0);
        contentValues_courses.put(COLUMN_DISCUSSION_COMPONENT, newCourse.hasDiscussionComponent()? 1 : 0);
        contentValues_courses.put(COLUMN_LAB_COMPONENT, newCourse.hasLabComponent()? 1 : 0);
        db.insert(TABLE_NAME_COURSES, null, contentValues_courses);
        ArrayList<Date> imp_dates = newCourse.getImpDates();
        ArrayList<String> imp_dates_info = newCourse.getInfoImpDates();
        for (int i = 0; i < imp_dates.size(); i++) {
            ContentValues contentValues_imp_dates = new ContentValues();
            contentValues_imp_dates.put(COLUMN_IMP_DATES_ASSOCIATED_COURSE, newCourse.getCourseName());
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:MM");
            String date = sdf.format(imp_dates.get(i));
            contentValues_imp_dates.put(COLUMN_IMP_DATES_DATE, date);
            contentValues_imp_dates.put(COLUMN_IMP_DATES_INFO, imp_dates_info.get(i));
            db.insert(TABLE_NAME_IMP_DATES, null, contentValues_imp_dates);
        }

        Course.Schedule course_schedule = newCourse.getCourseSchedule();
        if (newCourse.hasLectureComponent()) {
            ArrayList<Course.Schedule.Lecture> lectures = course_schedule.getLectures();
            for (int i = 0; i < lectures.size(); i++) {
                ContentValues contentValues_schedule = new ContentValues();
                contentValues_schedule.put(COLUMN_SCHEDULE_ASSOCIATED_COURSE, newCourse.getCourseName());
                contentValues_schedule.put(COLUMN_SCHEDULE_COMPONENT, "LECTURE");
                contentValues_schedule.put(COLUMN_SCHEDULE_DAYS, lectures.get(i).getDay().toString());
                contentValues_schedule.put(COLUMN_SCHEDULE_START_TIME, lectures.get(i).getStartTime().toString());
                contentValues_schedule.put(COLUMN_SCHEDULE_END_TIME, lectures.get(i).getEndTime().toString());
                db.insert(TABLE_NAME_SCHEDULE, null, contentValues_schedule);
            }

        }
        if (newCourse.hasDiscussionComponent()) {
            ArrayList<Course.Schedule.Discussion> discussions = course_schedule.getDiscussions();
            for (int i = 0; i < discussions.size(); i++) {
                ContentValues contentValues_schedule = new ContentValues();
                contentValues_schedule.put(COLUMN_SCHEDULE_ASSOCIATED_COURSE, newCourse.getCourseName());
                contentValues_schedule.put(COLUMN_SCHEDULE_COMPONENT, "DISCUSSION");
                contentValues_schedule.put(COLUMN_SCHEDULE_DAYS, discussions.get(i).getDay().toString());
                contentValues_schedule.put(COLUMN_SCHEDULE_START_TIME, discussions.get(i).getStartTime().toString());
                contentValues_schedule.put(COLUMN_SCHEDULE_END_TIME, discussions.get(i).getEndTime().toString());
                db.insert(TABLE_NAME_SCHEDULE, null, contentValues_schedule);
            }

        }
        if (newCourse.hasLabComponent()) {
            ArrayList<Course.Schedule.Lab> labs = course_schedule.getLabs();
            for (int i = 0; i < labs.size(); i++) {
                ContentValues contentValues_schedule = new ContentValues();
                contentValues_schedule.put(COLUMN_SCHEDULE_ASSOCIATED_COURSE, newCourse.getCourseName());
                contentValues_schedule.put(COLUMN_SCHEDULE_COMPONENT, "LAB");
                contentValues_schedule.put(COLUMN_SCHEDULE_DAYS, labs.get(i).getDay().toString());
                contentValues_schedule.put(COLUMN_SCHEDULE_START_TIME, labs.get(i).getStartTime().toString());
                contentValues_schedule.put(COLUMN_SCHEDULE_END_TIME, labs.get(i).getEndTime().toString());
                db.insert(TABLE_NAME_SCHEDULE, null, contentValues_schedule);
            }

        }

        ArrayList<Course.Office_Hours> office_hours = newCourse.getOffice_hours();
        for (int i = 0; i < office_hours.size(); i++) {
            ContentValues contentValues_officeHrs = new ContentValues();
            contentValues_officeHrs.put(COLUMN_OFFICE_HOURS_ASSOCIATED_COURSE, newCourse.getCourseName());
            contentValues_officeHrs.put(COLUMN_OFFICE_HOURS_DAY, office_hours.get(i).getDay().toString());
            contentValues_officeHrs.put(COLUMN_OFFICE_HOURS_START_TIME, office_hours.get(i).getStartTime().toString());
            contentValues_officeHrs.put(COLUMN_OFFICE_HOURS_END_TIME, office_hours.get(i).getEndTime().toString());
            contentValues_officeHrs.put(COLUMN_OFFICE_HOURS_INSTR_NAME, office_hours.get(i).getInstructor_name());
            db.insert(TABLE_NAME_OFFICE_HOURS, null, contentValues_officeHrs);
        }

        return numberOfCourses();
    }

    public int numberOfCourses() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME_COURSES);
        return numRows;
    }











}
