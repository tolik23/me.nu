package com.liutorovich.anatoliy.gmail.menu.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.liutorovich.anatoliy.gmail.menu.Interface.IMenuDatabase;

/**
 * Created by ToLik on 23.02.2017.
 */

public class MenuDataBase extends SQLiteOpenHelper implements IMenuDatabase {

    private static final String DATABASE_NAME = "MenuDB";
    private static final String TABLE_ORDERS = "orders";
    private static final String KEY_ID = "id";
    private static final String KEY_RESTAURANT = "restaurant";
    private static final String KEY_ADRESS = "adress";
    private static final String KEY_SUMM = "summ";
    private static final String KEY_DATE = "date";

    public MenuDataBase (Context context) {
        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ORDERS_TABLE = "CREATE TABLE " + TABLE_ORDERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_RESTAURANT + " TEXT,"
                + KEY_ADRESS + " TEXT," + KEY_SUMM + " TEXT," +  KEY_DATE + " TEXT" +")";
        db.execSQL(CREATE_ORDERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDERS);

        onCreate(db);
    }


    @Override
    public void addContact(String restaurant, String adress, double summ, String date) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_RESTAURANT, restaurant);
        cv.put(KEY_ADRESS, adress);
        cv.put(KEY_SUMM, summ);
        cv.put(KEY_DATE, date);

        db.insert(TABLE_ORDERS,null, cv);
        db.close();
    }

    @Override
    public Cursor getAllContacts() {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.query(TABLE_ORDERS, null, null, null, null, null, null);
        return c;
    }

    @Override
    public int getContactsCount() {
        String countQuery = "SELECT * FROM " + TABLE_ORDERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    @Override
    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ORDERS, null, null);
        db.close();

    }
}
