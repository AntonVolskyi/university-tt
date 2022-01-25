package university.system.dao.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import university.system.model.Lecture;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long>{
    @Query(value = "SELECT l FROM Student s "
            + "JOIN s.lectures l "
            + "JOIN FETCH l.teacher "
            + "JOIN FETCH l.lectureHall "
            + "WHERE s.id = :studentId "
            + "AND to_char(l.lectureDate , 'YYYY-MM-DD') = :lectureDate")
    List<Lecture> findLecturesByStudentIdAndDate(Long studentId, String lectureDate);
}
