package university.system.service;

import java.util.List;
import university.system.model.LectureHall;

public interface LectureHallService {
    LectureHall save(LectureHall lectureHall);

    LectureHall findById(Long id);

    List<LectureHall> findAll();

    void delete(Long id);
}
