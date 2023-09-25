package edu.harvard.cs50.notesproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesprojectAdapter extends RecyclerView.Adapter<NotesprojectAdapter.NotesViewHolder> {
    public static class NotesViewHolder extends RecyclerView.ViewHolder{
        public LinearLayout containerView;
        public TextView nametextView;

        NotesViewHolder(View view){
            super(view);
            this.containerView = view.findViewById(R.id.note_row);
            this.nametextView = view.findViewById(R.id.note_row_text);

            this.containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Note note = (Note) containerView.getTag();
                    Intent intent = new Intent(v.getContext(), NotesActivity.class);
                    intent.putExtra("id", note.id);
                    intent.putExtra("content", note.contents);

                    context.startActivity(intent);
                }
            });

        }
    }

    List<Note> notes = new ArrayList<>();

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_row, parent, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        Note current = notes.get(position);
        holder.containerView.setTag(current);
        holder.nametextView.setText(current.contents);


    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void reload(){
        notes = MainActivity.database.noteDao().getAllNotes();
        notifyDataSetChanged();

    }

}
