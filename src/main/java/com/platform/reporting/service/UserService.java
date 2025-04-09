package com.platform.reporting.service;

import com.platform.reporting.domain.User;
import com.platform.reporting.repository.UserRepository;
import com.platform.reporting.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Object not found."));
    }

    public User save(User user) {
        return repository.insert(user);
    }

    public User update(String id, User objUpdate) {
        User object = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Object not found."));
        updateData(object, objUpdate);
        object = repository.save(object);
        return object;
    }

    public void delete(String id) {
        repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Object not found."));
        repository.deleteById(id);
    }

    private void updateData(User object, User objUpdate) {
        object.setFirstName(objUpdate.getFirstName());
        object.setLastName(objUpdate.getLastName());
        object.setEmail(objUpdate.getEmail());
    }
}
