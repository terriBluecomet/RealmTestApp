package za.co.bluecomet.realmtestapp.data;

import io.realm.Realm;
import io.realm.RealmResults;
import za.co.bluecomet.realmtestapp.model.Course;

public class CourseDbSet {

    private Realm r;

    public CourseDbSet(Realm realm) {
        r = realm;
    }

    public RealmResults <Course> getCourses(){
        return r.where(Course.class).findAll().sort("CourseName");
    }

    public Course getCourseById(String courseCode){
        return r.where(Course.class).equalTo("CourseCode", courseCode).findFirst();
    }

}
