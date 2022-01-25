package university.system.service;

import java.util.List;
import university.system.model.Group;

public interface GroupService {
    Group save(Group group);

    Group findById(Long id);

    List<Group> findAll();

    void delete(Long id);
}
