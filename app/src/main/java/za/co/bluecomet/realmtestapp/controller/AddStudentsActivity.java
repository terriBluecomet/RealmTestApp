package za.co.bluecomet.realmtestapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import io.realm.Realm;
import za.co.bluecomet.realmtestapp.R;
import za.co.bluecomet.realmtestapp.data.StudentDbSet;

public class AddStudentsActivity extends AppCompatActivity {

    private Button btnAddNew;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_students);

        btnAddNew = findViewById(R.id.btnAddNew);
        recyclerView = findViewById(R.id.recyclerView);

        Realm.init(AddStudentsActivity.this);

        realm = Realm.getDefaultInstance();

        StudentDbSet studentDbSet =new StudentDbSet(realm);

        final RecycleAdapter recycleAdapter;
        recycleAdapter = new RecycleAdapter(studentDbSet.getStudents());
        recyclerView.setAdapter(recycleAdapter);

        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddStudentsActivity.this, EditStudentsActivity.class);
                startActivity(intent);
            }
        });




    }
}
