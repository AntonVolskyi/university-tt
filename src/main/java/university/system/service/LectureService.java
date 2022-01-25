package university.system.service;

import java.time.LocalDate;
import java.util.List;
import university.system.model.Lecture;

public interface LectureService {
    Lecture save(Lecture lecture);

    Lecture findById(Long id);

    List<Lecture> findByStudentIdAndDate(Long studentId, LocalDate date);

    List<Lecture> findAll();

    void delete(Long id);
}
