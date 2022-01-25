package university.system.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import university.system.model.LectureHall;

@Repository
public interface LectureHallRepository extends JpaRepository<LectureHall, Long> {
}
