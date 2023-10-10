# Android Notes App
## Overview
This is a simple Android notes application built using Java and the Room persistence library. Users can create new notes, edit existing ones, and delete notes they no longer need.



## Features
Create New Notes: Add a new note with a single click.  

Edit Notes: Simply click on a note to edit its contents.

Delete Notes: A delete option allows you to remove notes.  

Persistent Storage: Uses Room database to store notes persistently across user sessions.

## Usage
Create Note: Use the floating action button to create a new note.

Edit Note: Simply click on a note from the list to edit it

Delete Note: USe the delete button to remove a note from the list.

## Code Structure
'NoteDao': Interface containing methods for CRUD operations.

'Note': Plain Old Java Object (POJO) for note entitites

'NotesDatabase': Abstract class extending 'RoomDatabase', containing an abstract method that returns 'NoteDao'

'NotesActivity': Activity for editing individual notes.

'MainActivity': Main activity handling the list of notes.

'NotesprojectAdapter': Adapter for the RecyclerView in 'MainActivity'.
