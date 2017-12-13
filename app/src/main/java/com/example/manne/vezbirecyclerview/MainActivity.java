package com.example.manne.vezbirecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.manne.vezbirecyclerview.Model.Student;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    StudentAdapter adapter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.button)
    Button button;

    @BindView(R.id.result)
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(adapter.getItemCount()==0) {
                    button.setText("Clear");
                    generateList();
                    recyclerView.setVisibility(View.VISIBLE);

                }
                else{
                    button.setText("Generate");
                    adapter.clear();
                    recyclerView.setVisibility(View.GONE);

                }
            }
        });

        adapter = new StudentAdapter(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void generateList() {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Dua", "Lipa", "https://pbs.twimg.com/profile_images/862732127233875968/d5fIHguu.jpg", true));
        students.add(new Student("Maluma", "Baby", "https://www.omgvip.com/wp-content/uploads/2017/01/maluma-vip.jpg", true));
        students.add(new Student("Taylor", "Swift", "https://stephaniemarksbooks.com/wp-content/uploads/2017/09/TaylorSwift.jpg", true));
        students.add(new Student("Luis", "Fonsi", "https://images.sk-static.com/images/media/profile_images/artists/328569/huge_avatar", true));
        students.add(new Student("Demi", "Lovato", "https://www.famousbirthdays.com/headshots/demi-lovato-4.jpg", true));
        students.add(new Student("INNA", "Inna", "https://www.famousbirthdays.com/headshots/inna-4.jpg", true));
        students.add(new Student("Calvin", "Harris", "https://media1.popsugar-assets.com/files/thumbor/ieJgbbLqyP7vSFIL4dZn0tbGTVY/fit-in/500x500/filters:format_auto-!!-:strip_icc-!!-/2015/05/19/819/n/1922398/131d52cd_edit_img_image_845205_1432060566_CalvinH.jpg", true));
        students.add(new Student("Prince", "Royce", "http://cdn01.cdn.justjaredjr.com/wp-content/uploads/headlines/2017/07/prince-royce-east-los-high-vincent.jpg", true));
        students.add(new Student("Jennifer", "Lopez", "https://www.biography.com/.image/t_share/MTE4MDAzNDEwNzQ4NjA1OTY2/jennifer-lopez-9542231-3-402.jpg", true));
        students.add(new Student("Zayn", "Malik", "https://www.famousbirthdays.com/faces/malik-zayn-image.jpg", false));
        adapter.setItems(students);
    }


}
