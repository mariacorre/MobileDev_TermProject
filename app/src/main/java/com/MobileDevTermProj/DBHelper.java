package com.MobileDevTermProj;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "TermProject.db";
    public static final String QUESTIONS_TABLE_NAME = "questions";
    public static final String QUESTIONS_COLUMN_ID = "id";
    public static final String QUESTIONS_COLUMN_QUESTION = "question";
    public static final String QUESTIONS_COLUMN_ANSWER = "answer";
    public static final String QUESTIONS_COLUMN_CHOICE1 = "choice1";
    public static final String QUESTIONS_COLUMN_CHOICE2 = "choice2";
    public static final String QUESTIONS_COLUMN_CHOICE3 = "choice3";
    private int text;
    private Context context;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table " + QUESTIONS_TABLE_NAME + " (" +
                        QUESTIONS_COLUMN_ID + " integer primary key, " +
                        QUESTIONS_COLUMN_QUESTION + " text, " +
                        QUESTIONS_COLUMN_ANSWER + " text, " +
                        QUESTIONS_COLUMN_CHOICE1 + " text, " +
                        QUESTIONS_COLUMN_CHOICE2 + " text, " +
                        QUESTIONS_COLUMN_CHOICE3 + " text" +
                        ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS questions");
        onCreate(db);
    }

    public boolean insertQuestion(String question, String answer, String choice1, String choice2, String choice3) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(QUESTIONS_COLUMN_QUESTION, question);
        contentValues.put(QUESTIONS_COLUMN_ANSWER, answer);
        contentValues.put(QUESTIONS_COLUMN_CHOICE1, choice1);
        contentValues.put(QUESTIONS_COLUMN_CHOICE2, choice2);
        contentValues.put(QUESTIONS_COLUMN_CHOICE3, choice3);
        long result = db.insert(QUESTIONS_TABLE_NAME, null, contentValues);
        if(result > 0){
            return true;
        }
        return false;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + QUESTIONS_TABLE_NAME + " where " + QUESTIONS_COLUMN_ID + " = " + id + "", null);
        return res;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, QUESTIONS_TABLE_NAME);
        return numRows;
    }

    public boolean updateQuestion(Integer id, String question, String answer, String choice1, String choice2, String choice3) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(QUESTIONS_COLUMN_QUESTION, question);
        contentValues.put(QUESTIONS_COLUMN_ANSWER, answer);
        contentValues.put(QUESTIONS_COLUMN_CHOICE1, choice1);
        contentValues.put(QUESTIONS_COLUMN_CHOICE2, choice2);
        contentValues.put(QUESTIONS_COLUMN_CHOICE3, choice3);
        db.update(QUESTIONS_TABLE_NAME, contentValues, QUESTIONS_COLUMN_ID + " = ? ", new String[]{Integer.toString(id)});

        return true;
    }

    public Integer deleteQuestion(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(QUESTIONS_TABLE_NAME,
                QUESTIONS_COLUMN_ID + " = ? ",
                new String[]{Integer.toString(id)});
    }

    public List<Question> getAllQuestions() {
        List<Question> list = new ArrayList<Question>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + QUESTIONS_TABLE_NAME, null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            Question q = new Question();
            q.setId(res.getInt(res.getColumnIndex("id")));
            q.setQuestion(res.getString(res.getColumnIndex(QUESTIONS_COLUMN_QUESTION)));
            q.setAnswer(res.getString(res.getColumnIndex(QUESTIONS_COLUMN_ANSWER)));
            q.setChoice1(res.getString(res.getColumnIndex(QUESTIONS_COLUMN_CHOICE1)));
            q.setChoice2(res.getString(res.getColumnIndex(QUESTIONS_COLUMN_CHOICE2)));
            q.setChoice3(res.getString(res.getColumnIndex(QUESTIONS_COLUMN_CHOICE3)));

            list.add(q);
            res.moveToNext();
        }
        return list;
    }
}