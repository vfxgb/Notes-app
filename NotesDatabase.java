package edu.harvard.cs50.notesproject;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract class NotesDatabase extends RoomDatabase {

    public abstract NoteDao noteDao();

}
