package za.co.bluecomet.realmtestapp.data;

import io.realm.Realm;
import io.realm.RealmResults;
import za.co.bluecomet.realmtestapp.model.Student;

public class StudentDbSet {

    private Realm r;

    public StudentDbSet(Realm realm) {
        r=realm;
    }

    public RealmResults<Student> getStudents(){
        return r.where(Student.class).findAll().sort("Name");
    }

    public Student getStudentById(String studentID){
        return r.where(Student.class).equalTo("ID", studentID).findFirst();
    }

}
