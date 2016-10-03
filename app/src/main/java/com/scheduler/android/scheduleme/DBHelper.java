package com.scheduler.android.scheduleme;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_COURSE_NAME;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_COURSE_NO;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_CREDIT_HRS;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_IMP_DATES_ASSOCIATED_COURSE;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_IMP_DATES_DATE;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_IMP_DATES_ID;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_IMP_DATES_INFO;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_IMP_DATES_SR_NO;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_OFFICE_HOURS_ASSOCIATED_COURSE;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_OFFICE_HOURS_DAY;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_OFFICE_HOURS_END_TIME;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_OFFICE_HOURS_ID;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_OFFICE_HOURS_INSTR_NAME;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_OFFICE_HOURS_START_TIME;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_SCHEDULE_ASSOCIATED_COURSE;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_SCHEDULE_COMPONENT;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_SCHEDULE_DAYS;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_SCHEDULE_END_TIME;
import static com.scheduler.android.scheduleme.CourseContract.DataEntry.COLUMN_SCHEDULE_ID;
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

    public DBHelper (Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME_COURSES +" (" + COLUMN_COURSE_NAME +" TEXT PRIMARY KEY NOT NULL, "+ COLUMN_COURSE_NO +" INT NOT NULL AUTO INCREMENT, "+ COLUMN_CREDIT_HRS +" INT NOT NULL, "+ COLUMN_IMP_DATES_ID +" TEXT NOT NULL, "+ COLUMN_OFFICE_HOURS_ID +" TEXT NOT NULL, "+ COLUMN_SCHEDULE_ID +" TEXT NOT NULL)");
        db.execSQL("create table "+ TABLE_NAME_IMP_DATES + " (" + COLUMN_IMP_DATES_ASSOCIATED_COURSE +" TEXT PRIMARY KEY NOT NULL, " + COLUMN_IMP_DATES_DATE +" DATE NOT NULL, " + COLUMN_IMP_DATES_INFO +" TEXT, "+ COLUMN_IMP_DATES_SR_NO +" INT NOT NULL AUTO INCREMENT PRIMARY KEY)");
        db.execSQL("create table "+ TABLE_NAME_OFFICE_HOURS + " (" + COLUMN_OFFICE_HOURS_ASSOCIATED_COURSE +" TEXT PRIMARY KEY NOT NULL, " + COLUMN_OFFICE_HOURS_DAY +" TEXT NOT NULL, " + COLUMN_OFFICE_HOURS_START_TIME +" DATETIME, "+ COLUMN_OFFICE_HOURS_END_TIME +" DATETIME, "+ COLUMN_OFFICE_HOURS_INSTR_NAME +" TEXT)");
        db.execSQL("create table "+ TABLE_NAME_SCHEDULE + " (" + COLUMN_SCHEDULE_SR_NO +" INT NOT NULL AUTO INCREMENT, " + COLUMN_SCHEDULE_ASSOCIATED_COURSE + " TEXT NOT NULL PRIMARY KEY, " + COLUMN_SCHEDULE_COMPONENT +" TEXT NOT NULL, " + COLUMN_SCHEDULE_START_TIME +" DATETIME, " + COLUMN_SCHEDULE_END_TIME +" DATETIME, " + COLUMN_SCHEDULE_DAYS +" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_COURSES);
        onCreate(db);
    }



}
