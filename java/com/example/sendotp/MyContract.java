package com.example.sendotp;

public class MyContract {
    public static final String TABLE_NAME = "users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "status";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +

                    COLUMN_NAME + " TEXT," +
                    COLUMN_AGE + " TEXT)";
}