package com.assignment_7.repositories.repositoryImplem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.assignment_7.appConfig.database.DBConstants;
import com.assignment_7.domain.Photos;
import com.assignment_7.repositories.repository.PhotoRepository;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by 214162966 on 4/18/2016.
 */
public class PhotoRepositoryImplem extends SQLiteOpenHelper implements PhotoRepository {
    public static final String TABLE_NAME="photos";
    private SQLiteDatabase database;

    public static final String COLUMN_ID="id";
    public static final String COLUMN_FIRSTNAME="first";
    public static final String COLUMN_LASTNAME="last";

    public static String DATABASE_CREATE=" CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_FIRSTNAME + " TEXT UNIQUE NOT NULL , "
            + COLUMN_LASTNAME + " TEXT UNIQUE NOT NULL);";

    public PhotoRepositoryImplem(Context context){
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        database=this.getWritableDatabase();
    }

    public void close(){
        this.close();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    @Override
    public Photos findById(Long id){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME,new String[]{COLUMN_ID,COLUMN_FIRSTNAME,COLUMN_LASTNAME},COLUMN_ID+"=?",new String[]{String.valueOf(id)},null,null,null,null);

        if(cursor.moveToFirst()){
            final Photos photo=new Photos.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .first(cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME)))
                    .last(cursor.getString(cursor.getColumnIndex(COLUMN_LASTNAME)))
                    .build();
            return photo;
        }else{
            return null;
        }
    }
    @Override
    public Photos save(Photos entity) throws SQLException {
        open();
        ContentValues values=new ContentValues();
        values.put(COLUMN_ID,entity.getId());
        values.put(COLUMN_FIRSTNAME,entity.getCameramanFirstName());
        values.put(COLUMN_LASTNAME,entity.getCameramanLastName());

        long id=database.insertOrThrow(TABLE_NAME, null, values);
        Photos insertedEntity=new Photos.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }
    @Override
    public Photos update(Photos entity) throws SQLException {
        open();
        ContentValues values=new ContentValues();
        values.put(COLUMN_ID,entity.getId());
        values.put(COLUMN_FIRSTNAME,entity.getCameramanFirstName());
        values.put(COLUMN_LASTNAME,entity.getCameramanLastName());

        database.update(TABLE_NAME,
                values,COLUMN_ID + " =? ",new String[]{String.valueOf(entity.getId())});
        return entity;
    }
    @Override
    public Photos delete(Photos entity) throws SQLException {
        open();
        database.delete(TABLE_NAME,COLUMN_ID+ " =? ",new String[]{String.valueOf(entity.getId())});
        return entity;

    }
    @Override
    public Set<Photos> findAll() throws SQLException {
        SQLiteDatabase db=this.getReadableDatabase();
        Set<Photos> photo=new HashSet<>();
        open();
        Cursor cursor=db.query(TABLE_NAME,null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                final Photos photos =new Photos.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .first(cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME)))
                        .last(cursor.getString(cursor.getColumnIndex(COLUMN_LASTNAME)))
                        .build();
                photo.add(photos);
            }while(cursor.moveToNext());
        }
        return photo;
    }
    @Override
    public int deleteAll() throws SQLException {
        open();
        int rowsDeleted=database.delete(TABLE_NAME,null,null);
        close();

        return rowsDeleted;
    }

}
