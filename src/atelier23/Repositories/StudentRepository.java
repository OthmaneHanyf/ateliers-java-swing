package atelier23.Repositories;

import atelier23.Data.DbContext;
import atelier23.Models.StudentModel;

import java.util.List;

public class StudentRepository implements IStudentRepository {

    private DbContext _db;

    public StudentRepository(DbContext db) {
        _db = db;
    }

    @Override
    public List<StudentModel> getAll() {
        return _db.studentList;
    }

    @Override
    public void create(StudentModel student) {
        _db.studentList.add(student);
    }

    @Override
    public void clear() {
        _db.studentList.clear();
    }

}
