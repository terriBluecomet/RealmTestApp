package za.co.bluecomet.realmtestapp.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import za.co.bluecomet.realmtestapp.R;
import za.co.bluecomet.realmtestapp.data.CourseDbSet;
import za.co.bluecomet.realmtestapp.data.StudentDbSet;
import za.co.bluecomet.realmtestapp.model.Course;
import za.co.bluecomet.realmtestapp.model.Student;

public class EditStudentsActivity extends AppCompatActivity {

    private EditText editName, editSurname, editAge, editCourse, editStudentId;
    private Button btnSave;


    Realm realm;

    Student mStudent = new Student();
    Course mCourse = new Course();

    StudentDbSet mStudentDbSet;
    CourseDbSet mCourseDbSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editAge = findViewById(R.id.editAge);
        editCourse = findViewById(R.id.editCourse);
        editName = findViewById(R.id.editName);
        editSurname = findViewById(R.id.editSurname);
        editStudentId = findViewById(R.id.editStudentId);
        btnSave = findViewById(R.id.btnSave);



        realm = Realm.getDefaultInstance();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveToDb();
                Toast.makeText(EditStudentsActivity.this, "record saved", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        mStudentDbSet = new StudentDbSet(realm);
       // mStudent = mStudentDbSet.getStudentById(mStudent.ID);

        mCourseDbSet = new CourseDbSet(realm);
       // mCourse = mCourseDbSet.getCourseById(mCourse.CourseCode);


    }

    private void saveToDb() {
        realm.beginTransaction();

        mStudent.ID = editStudentId.getText().toString();
        mStudent.Name = editName.getText().toString();
        mStudent.Surname = editSurname.getText().toString();
        mStudent.Age = Integer.parseInt(editAge.getText().toString());
        mCourse.CourseName = editCourse.getText().toString();

        realm.insertOrUpdate(mStudent);
        realm.commitTransaction();

    }

   }
