package com.example.manne.vezbirecyclerview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.manne.vezbirecyclerview.Model.Student;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by manne on 13.12.2017.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    Context context;
    List<Student> studentList = new ArrayList<>();

    public void setItems(List<Student> students){
        studentList=students;
        notifyDataSetChanged();


    }

    public void clear(){
        if(studentList!=null)
        {
            studentList.clear();
        }
        notifyDataSetChanged();
    }

    public StudentAdapter(Context context_){
        context = context_;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Student student = studentList.get(position);
        viewHolder.textView.setText(student.ime + " " + student.prezime);
        if(student.isActive){
            viewHolder.isActive.setText("Active");
            viewHolder.linearLayout.setBackgroundColor(Color.GREEN);
        }
        else{
            viewHolder.isActive.setText("Not active");
            viewHolder.linearLayout.setBackgroundColor(Color.RED);
        }
        Picasso.with(context)
                .load(student.photoUrl)
                .fit()
                .centerInside()
                .into(viewHolder.imageView);
    }


    @Override
    public int getItemCount() {
        return studentList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.text)
        TextView textView;
        @BindView(R.id.isActive)
        TextView isActive;
        @BindView(R.id.linearLayout)
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
