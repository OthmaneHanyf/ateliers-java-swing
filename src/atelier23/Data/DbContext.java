package atelier23.Data;

import atelier23.Models.StudentModel;

import java.util.ArrayList;
import java.util.List;

public class DbContext {
    public List<StudentModel> studentList;

    public DbContext() {
        this.studentList = new ArrayList<StudentModel> ();
        this.studentList.add(
            new StudentModel(1, "othmane", "hanyf", "19-01-2000", "GI", "Male")
        );
        this.studentList.add(
            new StudentModel(2, "ayoub", "kassi", "19-01-2000", "GI", "Male")
        );
    }
}
