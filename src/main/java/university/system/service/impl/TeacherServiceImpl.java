package university.system.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import university.system.dao.repository.TeacherRepository;
import university.system.model.Teacher;
import university.system.service.TeacherService;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private TeacherRepository repository;

    @Override
    public Teacher save(Teacher teacher) {
        return repository.save(teacher);
    }

    @Override
    public Teacher findById(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new RuntimeException("Can`t find teacher with id: " + id));
    }

    @Override
    public List<Teacher> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
