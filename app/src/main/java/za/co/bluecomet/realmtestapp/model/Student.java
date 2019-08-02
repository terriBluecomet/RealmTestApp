package za.co.bluecomet.realmtestapp.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Student extends RealmObject {
    @PrimaryKey
    public String ID;
    public String Name;
    public String Surname;
    public int Age;
    private RealmList <Course> Courses;

    public Student(){

    }
}