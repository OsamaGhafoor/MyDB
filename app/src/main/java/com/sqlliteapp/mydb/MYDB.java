package com.sqlliteapp.mydb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MYDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="contacts table";
    private static final int Version = 3;
    private static final String TABLE_NAME = "contacts";
    private static final String KEY_NAME = "name";
    private static final String KEY_ID ="id";
    private static final String KEY_PHONE_NO = "phone_no";


    public MYDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(" CREATE TABLE " + TABLE_NAME+"("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ KEY_NAME + " TEXT, " + KEY_PHONE_NO+ " TEXT " +")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    //INSERTING

    public void addContacts( String name, String phone_no){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NAME,name);
        values.put(KEY_PHONE_NO,phone_no);


        db.insert(TABLE_NAME,null,values);


    }

    //SELECTING

    public ArrayList<ContentModel> fetchcontects(){
        SQLiteDatabase db = this.getReadableDatabase();
      Cursor cursor = db.rawQuery(" SELECT * FROM "+TABLE_NAME,null);

      ArrayList<ContentModel> contentModels = new ArrayList<>();

      while (cursor.moveToNext()){

          ContentModel model = new ContentModel();
          model.id = cursor.getInt(0);
          model.name  = cursor.getString(1);
          model.phone_no = cursor.getString(2);

          contentModels.add(model);
      }


      return contentModels;

    }


    //UPDATING

    public void updateContact(ContentModel contentModel)
    {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(KEY_PHONE_NO,contentModel.phone_no);

        db.update(TABLE_NAME,cv,KEY_ID+"="+contentModel.id,null);

    }

    //DELETING

    public void deleteContact(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,KEY_ID+"= ?",new String[]{String.valueOf(id)});
    }

}
