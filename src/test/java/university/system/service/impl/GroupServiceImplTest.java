package university.system.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import university.system.dao.repository.GroupRepository;
import university.system.model.Group;
import university.system.service.GroupService;

class GroupServiceImplTest {
    private static final long ID1 = 1L;
    private static final long ID2 = 2L;
    private GroupRepository groupRepository;
    private GroupService groupService;
    private static Group expected;

    @BeforeAll
    static void beforeAll() {
        expected = new Group();
        expected.setId(ID1);
        expected.setGroupName("NE");
    }

    @BeforeEach
    void setUp() {
        groupRepository = Mockito.mock(GroupRepository.class);
        groupService = new GroupServiceImpl(groupRepository);
    }

    @Test
    void save_Ok() {
        Group input = new Group();
        input.setGroupName("NE");
        Mockito.when(groupRepository.save(input)).thenReturn(expected);
        Group result = groupService.save(input);
        assertEquals(expected, result);
    }

    @Test
    void findById_NotOk() {
        Mockito.when(groupRepository.findById(ID1)).thenReturn(Optional.of(expected));
        try {
            groupService.findById(ID2);
        } catch (RuntimeException r) {
            assertEquals("Can`t find group with id: " + ID2, r.getMessage());
            return;
        }
        fail("Expected Runtime Exception");
    }

    @Test
    void findById_Ok() {
        Mockito.when(groupRepository.findById(ID1)).thenReturn(Optional.of(expected));
        Group result = groupService.findById(ID1);
        assertEquals(expected, result);
    }

    @Test
    void findAll_Ok() {
        Mockito.when(groupRepository.findAll()).thenReturn(List.of(expected));
        List<Group> result = groupService.findAll();
        assertEquals(List.of(expected), result);
    }
}
