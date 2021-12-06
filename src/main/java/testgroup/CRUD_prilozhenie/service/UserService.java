package testgroup.CRUD_prilozhenie.service;

import testgroup.CRUD_prilozhenie.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserService {
    List<User> allUsers();
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getById(int id);
}
