package com.assignment_7.repositories.repositoryImplem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.assignment_7.appConfig.database.DBConstants;
import com.assignment_7.domain.Cheque;
import com.assignment_7.domain.Credit;
import com.assignment_7.repositories.repository.ChequeRepository;
import com.assignment_7.repositories.repository.CreditRepository;
import com.assignment_7.repositories.repository.FuneralRepository;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 214162966 on 4/18/2016.
 */
public class CreditRepositoryimplem extends SQLiteOpenHelper implements CreditRepository{

        public static final String TABLE_NAME="credit";
        private SQLiteDatabase database;

        public static final String COLUMN_ID="id";
        public static final String COLUMN_NUMBER="no";
        public static final String COLUMN_NAME="name";

        public static String DATABASE_CREATE=" CREATE TABLE "
                + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NUMBER + " TEXT UNIQUE NOT NULL , "
                + COLUMN_NAME + " TEXT UNIQUE NOT NULL);";

        public CreditRepositoryimplem(Context context){
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
        public Credit findById(Long id){
            SQLiteDatabase db=this.getReadableDatabase();
            Cursor cursor=db.query(TABLE_NAME,new String[]{COLUMN_ID,COLUMN_NUMBER,COLUMN_NAME},COLUMN_ID+"=?",new String[]{String.valueOf(id)},null,null,null,null);

            if(cursor.moveToFirst()){
                final Credit credit=new Credit.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .no(cursor.getString(cursor.getColumnIndex(COLUMN_NUMBER)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .build();
                return credit;
            }else{
                return null;
            }
        }
    @Override
        public Credit save(Credit entity) throws SQLException {
            open();
            ContentValues values=new ContentValues();
            values.put(COLUMN_ID,entity.getId());
            values.put(COLUMN_NUMBER,entity.getNumber());
            values.put(COLUMN_NAME,entity.getName());

            long id=database.insertOrThrow(TABLE_NAME, null, values);
            Credit insertedEntity=new Credit.Builder()
                    .copy(entity)
                    .id(new Long(id))
                    .build();
            return insertedEntity;
        }
    @Override
        public Credit update(Credit entity) throws SQLException {
            open();
            ContentValues values=new ContentValues();
            values.put(COLUMN_ID,entity.getId());
            values.put(COLUMN_NUMBER,entity.getNumber());
            values.put(COLUMN_NAME,entity.getName());

            database.update(TABLE_NAME,
                    values,COLUMN_ID + " =? ",new String[]{String.valueOf(entity.getId())});
            return entity;
        }
    @Override
        public Credit delete(Credit entity) throws SQLException {
            open();
            database.delete(TABLE_NAME,COLUMN_ID+ " =? ",new String[]{String.valueOf(entity.getId())});
            return entity;

        }
    @Override
        public Set<Credit> findAll() throws SQLException {
            SQLiteDatabase db=this.getReadableDatabase();
            Set<Credit> credit=new HashSet<>();
            open();
            Cursor cursor=db.query(TABLE_NAME,null,null,null,null,null,null);
            if(cursor.moveToFirst()){
                do{
                    final Credit credits =new Credit.Builder()
                            .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                            .no(cursor.getString(cursor.getColumnIndex(COLUMN_NUMBER)))
                            .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                            .build();
                    credit.add(credits);
                }while(cursor.moveToNext());
            }
            return credit;
        }
    @Override
        public int deleteAll() throws SQLException {
            open();
            int rowsDeleted=database.delete(TABLE_NAME,null,null);
            close();

            return rowsDeleted;
        }

}
