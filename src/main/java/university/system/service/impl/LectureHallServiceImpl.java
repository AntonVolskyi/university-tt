package university.system.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import university.system.dao.repository.LectureHallRepository;
import university.system.model.LectureHall;
import university.system.service.LectureHallService;

@Service
@AllArgsConstructor
public class LectureHallServiceImpl implements LectureHallService {
    private LectureHallRepository repository;

    @Override
    public LectureHall save(LectureHall lectureHall) {
        return repository.save(lectureHall);
    }

    @Override
    public LectureHall findById(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new RuntimeException("Can`t find lecture hall with id: " + id));
    }

    @Override
    public List<LectureHall> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
