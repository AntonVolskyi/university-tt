package university.system.service;

import java.util.List;
import university.system.model.Student;

public interface StudentService {
    Student save(Student student);

    Student findById(Long id);

    List<Student> findAll();

    List<Student> findByIds(List<Long> ids);

    void delete(Long id);
}
