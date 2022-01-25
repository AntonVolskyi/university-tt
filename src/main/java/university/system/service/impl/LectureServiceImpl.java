package university.system.service.impl;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import university.system.dao.repository.LectureRepository;
import university.system.model.Lecture;
import university.system.service.LectureService;

@Service
@AllArgsConstructor
public class LectureServiceImpl implements LectureService {
    private LectureRepository repository;

    @Override
    public Lecture save(Lecture lecture) {
        return repository.save(lecture);
    }

    @Override
    public Lecture findById(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new RuntimeException("Can`t find lecture with id: " + id));
    }

    @Override
    public List<Lecture> findByStudentIdAndDate(Long studentId, LocalDate lectureDate) {
        return repository.findLecturesByStudentIdAndDate(studentId, lectureDate.toString());
    }

    @Override
    public List<Lecture> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
