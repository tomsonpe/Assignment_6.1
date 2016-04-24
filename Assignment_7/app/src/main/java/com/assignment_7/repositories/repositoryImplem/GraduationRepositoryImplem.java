package com.assignment_7.repositories.repositoryImplem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.assignment_7.appConfig.database.DBConstants;
import com.assignment_7.domain.Funerals;
import com.assignment_7.domain.GraduationCeremony;
import com.assignment_7.repositories.repository.GraduationRepository;
import com.assignment_7.repositories.repository.PhotoEditorRepository;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 214162966 on 4/18/2016.
 */
public class GraduationRepositoryImplem extends SQLiteOpenHelper implements GraduationRepository{
    public static final String TABLE_NAME="graduation";
    private SQLiteDatabase database;

    public static final String COLUMN_ID="id";
    public static final String COLUMN_NUMBER="no";
    public static final String COLUMN_NAME="name";

    public static String DATABASE_CREATE=" CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NUMBER + " TEXT UNIQUE NOT NULL , "
            + COLUMN_NAME + " TEXT UNIQUE NOT NULL);";

    public GraduationRepositoryImplem(Context context){
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
    public GraduationCeremony findById(Long id){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME,new String[]{COLUMN_ID,COLUMN_NUMBER,COLUMN_NAME},COLUMN_ID+"=?",new String[]{String.valueOf(id)},null,null,null,null);

        if(cursor.moveToFirst()){
            final GraduationCeremony grad=new GraduationCeremony.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .no(cursor.getString(cursor.getColumnIndex(COLUMN_NUMBER)))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .build();
            return grad;
        }else{
            return null;
        }
    }
    @Override
    public GraduationCeremony save(GraduationCeremony entity) throws SQLException {
        open();
        ContentValues values=new ContentValues();
        values.put(COLUMN_ID,entity.getId());
        values.put(COLUMN_NUMBER,entity.getNo());
        values.put(COLUMN_NAME,entity.getName());

        Long id=database.insertOrThrow(TABLE_NAME, null, values);
        GraduationCeremony insertedEntity=new GraduationCeremony.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }
    @Override
    public GraduationCeremony update(GraduationCeremony entity) throws SQLException {
        open();
        ContentValues values=new ContentValues();
        values.put(COLUMN_ID,entity.getId());
        values.put(COLUMN_NUMBER,entity.getNo());
        values.put(COLUMN_NAME,entity.getName());

        database.update(TABLE_NAME,
                values,COLUMN_ID + " =? ",new String[]{String.valueOf(entity.getId())});
        return entity;
    }
    @Override
    public GraduationCeremony delete(GraduationCeremony entity) throws SQLException {
        open();
        database.delete(TABLE_NAME,COLUMN_ID+ " =? ",new String[]{String.valueOf(entity.getId())});
        return entity;

    }
    @Override
    public Set<GraduationCeremony> findAll() throws SQLException {
        SQLiteDatabase db=this.getReadableDatabase();
        Set<GraduationCeremony> grad=new HashSet<>();
        open();
        Cursor cursor=db.query(TABLE_NAME,null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                final GraduationCeremony grads =new GraduationCeremony.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .no(cursor.getString(cursor.getColumnIndex(COLUMN_NUMBER)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .build();
                grad.add(grads);
            }while(cursor.moveToNext());
        }
        return grad;
    }
    @Override
    public int deleteAll() throws SQLException {
        open();
        int rowsDeleted=database.delete(TABLE_NAME,null,null);
        close();

        return rowsDeleted;
    }
}
