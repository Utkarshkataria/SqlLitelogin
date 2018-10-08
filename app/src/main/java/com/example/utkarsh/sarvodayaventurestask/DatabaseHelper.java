package com.example.utkarsh.sarvodayaventurestask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.utkarsh.sarvodayaventurestask.model.Users;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static  final String DATABASE_NAME = "usersdb";
    private static final String TABLE_NAME = "users";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_GENDER ="gender";
    private static final String KEY_PHONE ="phone";
    private static final String KEY_PASSWORD ="password";
     Context context;
    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="CREATE TABLE " + TABLE_NAME + "(" + KEY_EMAIL + " TEXT PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_GENDER + " TEXT," + KEY_PHONE + " TEXT," + KEY_PASSWORD + " TEXT" + ")";
        db.execSQL(query);
        Toast.makeText(context, ""+query, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public void insertRecord(Users users)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_EMAIL,users.getEmail());
        values.put(KEY_NAME,users.getName());
        values.put(KEY_GENDER,users.getGender());
        values.put(KEY_PHONE,users.getPhone());
        values.put(KEY_PASSWORD,users.getPassword());
        db.insert(TABLE_NAME,null,values);
        db.close();

    }
    public Users getRecord(String email){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,new String[]{KEY_EMAIL,KEY_NAME,KEY_GENDER,KEY_PHONE,KEY_PASSWORD},
                KEY_EMAIL + "=?" + " OR " + KEY_PHONE + "=?" , new String[] {email,email},
                null,null,null,null );


        if(cursor!=null)
            cursor.moveToFirst();

        Users users = new Users(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
        return users;
    }

    public int updateRecord(Users users){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME,users.getName());
        values.put(KEY_GENDER,users.getGender());
        values.put(KEY_PHONE,users.getPhone());
        values.put(KEY_PASSWORD,users.getPassword());
        values.put(KEY_EMAIL,users.getEmail());
        return db.update(TABLE_NAME,values,
                KEY_EMAIL +"=?",new String[]{users.getEmail()});
    }

    public  void deleteRecord(String id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME,KEY_EMAIL +"=?" + "||" + KEY_PHONE +"=?",new String[] {id});
        db.close();
    }

}

