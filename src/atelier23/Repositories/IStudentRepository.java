package atelier23.Repositories;

import atelier23.Models.StudentModel;

import java.util.List;

public interface IStudentRepository {
    List<StudentModel> getAll();
    void create(StudentModel student);
    void clear();
//    void update(StudentModel student);
//    void delete(int id);
}
