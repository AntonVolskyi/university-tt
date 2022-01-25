package university.system.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import university.system.dao.repository.LectureHallRepository;
import university.system.model.LectureHall;
import university.system.service.LectureHallService;

class LectureHallServiceImplTest {
    private static final long ID1 = 1L;
    private static final long ID2 = 2L;
    private LectureHallRepository lectureHallRepository;
    private LectureHallService lectureHallService;
    private static LectureHall expected;

    @BeforeAll
    static void beforeAll() {
        expected = new LectureHall();
        expected.setId(ID1);
        expected.setCapacity(150);
        expected.setDescription("Standard description");
    }

    @BeforeEach
    void setUp() {
        lectureHallRepository = Mockito.mock(LectureHallRepository.class);
        lectureHallService = new LectureHallServiceImpl(lectureHallRepository);
    }

    @Test
    void save_Ok() {
        LectureHall input = new LectureHall();
        input.setCapacity(150);
        input.setDescription("Standard description");
        Mockito.when(lectureHallRepository.save(input)).thenReturn(expected);
        LectureHall result = lectureHallService.save(input);
        assertEquals(expected, result);
    }

    @Test
    void getById_Ok() {
        Mockito.when(lectureHallRepository.findById(ID1)).thenReturn(Optional.of(expected));
        LectureHall result = lectureHallService.findById(ID1);
        assertEquals(expected, result);
    }

    @Test
    void getById_NotOk() {
        Mockito.when(lectureHallRepository.findById(ID1)).thenReturn(Optional.of(expected));
        try {
            lectureHallService.findById(ID2);
        } catch (RuntimeException r) {
            assertEquals("Can`t find lecture hall with id: " + ID2, r.getMessage());
            return;
        }
        fail("Expected Runtime exception");
    }

    @Test
    void findAll_Ok() {
        Mockito.when(lectureHallRepository.findAll()).thenReturn(List.of(expected));
        List<LectureHall> result = lectureHallService.findAll();
        assertEquals(List.of(expected), result);
    }
}
