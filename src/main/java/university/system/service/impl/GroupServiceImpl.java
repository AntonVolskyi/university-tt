package university.system.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import university.system.dao.repository.GroupRepository;
import university.system.model.Group;
import university.system.service.GroupService;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {
    private GroupRepository repository;

    @Override
    public Group save(Group group) {
        return repository.save(group);
    }

    @Override
    public Group findById(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new RuntimeException("Can`t find group with id: " + id));
    }

    @Override
    public List<Group> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
