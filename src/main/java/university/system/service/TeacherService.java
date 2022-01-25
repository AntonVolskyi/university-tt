package university.system.service;

import java.util.List;
import university.system.model.Teacher;

public interface TeacherService {
    Teacher save(Teacher teacher);

    Teacher findById(Long id);

    List<Teacher> findAll();

    void delete(Long id);
}
