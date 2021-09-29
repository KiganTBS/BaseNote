package com.example.note;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class NotesDatabase extends RoomDatabase {
    public static NotesDatabase database; // Объект класса
    private static final String DB_NAME = "notes2.db";
    private static final Object LOCK = new Object(); // Замок для потоков (Чтоб 2 потока не создали ДБ)

    public static NotesDatabase getInstance(Context context){ // Возвращает экземляр БД
        synchronized (LOCK) {
            if (database == null) { //Если Бд не создана
                database = Room.databaseBuilder(context, NotesDatabase.class, DB_NAME).build();
            }
        }
        return database;
    }
    public abstract NotesDao notesDao(); // Получаем объект интерфейса
}
