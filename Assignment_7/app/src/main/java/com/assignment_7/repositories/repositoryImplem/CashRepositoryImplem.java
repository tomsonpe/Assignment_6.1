package com.assignment_7.repositories.repositoryImplem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.assignment_7.appConfig.database.DBConstants;
import com.assignment_7.domain.Cash;
import com.assignment_7.repositories.repository.CashRepository;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 214162966 on 4/18/2016.
 */
public class CashRepositoryImplem extends SQLiteOpenHelper implements CashRepository {
    public static final String TABLE_NAME="cash";
    private SQLiteDatabase database;

    public static final String COLUMN_ID="id";
    public static final String COLUMN_AMOUNT="amount";
    public static final String COLUMN_NAME="name";

    public static String DATABASE_CREATE=" CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_AMOUNT + " TEXT UNIQUE NOT NULL , "
            + COLUMN_NAME + " TEXT UNIQUE NOT NULL);";

    public CashRepositoryImplem(Context context){
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() {
        database=this.getWritableDatabase();
    }

    public void close(){
        this.close();
    }
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
    public Cash findById(Long id){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME,new String[]{COLUMN_ID,COLUMN_AMOUNT,COLUMN_NAME},COLUMN_ID+"=?",new String[]{String.valueOf(id)},null,null,null,null);

        if(cursor.moveToFirst()){
             final Cash cash=new Cash.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .amount(cursor.getString(cursor.getColumnIndex(COLUMN_AMOUNT)))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .build();
                return cash;
        }else{
            return null;
        }
    }
    @Override
    public Cash save(Cash entity) throws SQLException {
        open();
        ContentValues values=new ContentValues();
        values.put(COLUMN_ID,entity.getId());
        values.put(COLUMN_AMOUNT,entity.getAmount());
        values.put(COLUMN_NAME,entity.getName());

        long id =database.insertOrThrow(TABLE_NAME, null, values);
        Cash insertedEntity=new Cash.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }
    @Override
    public Cash update(Cash entity) throws SQLException {
        open();
        ContentValues values=new ContentValues();
        values.put(COLUMN_ID,entity.getId());
        values.put(COLUMN_AMOUNT,entity.getAmount());
        values.put(COLUMN_NAME,entity.getName());

        database.update(TABLE_NAME,
                values,COLUMN_ID + " =? ",new String[]{String.valueOf(entity.getId())});
        return entity;
    }
    @Override
    public Cash delete(Cash entity) throws SQLException {
        open();
        database.delete(TABLE_NAME,COLUMN_ID+ " =? ",new String[]{String.valueOf(entity.getId())});
        return entity;

    }
    @Override
    public Set<Cash> findAll() throws SQLException {
        SQLiteDatabase db=this.getReadableDatabase();
        Set<Cash> cash=new HashSet<>();
        open();
        Cursor cursor=db.query(TABLE_NAME,null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                final Cash cashy =new Cash.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .amount(cursor.getString(cursor.getColumnIndex(COLUMN_AMOUNT)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .build();
                cash.add(cashy);
            }while(cursor.moveToNext());
        }
        return cash;
    }
    @Override
    public int deleteAll() throws SQLException {
        open();
        int rowsDeleted=database.delete(TABLE_NAME,null,null);
        close();

        return rowsDeleted;
    }
}
