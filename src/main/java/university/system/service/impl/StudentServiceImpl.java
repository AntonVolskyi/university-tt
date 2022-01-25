package university.system.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import university.system.dao.repository.StudentRepository;
import university.system.model.Student;
import university.system.service.StudentService;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepository repository;

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public Student findById(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new RuntimeException("Can`t find student with id: " + id));
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Student> findByIds(List<Long> ids) {
        return repository.findStudentsByIdIn(ids);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
