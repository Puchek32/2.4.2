package testgroup.CRUD_prilozhenie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testgroup.CRUD_prilozhenie.model.User;
import testgroup.CRUD_prilozhenie.dao.UserDAO;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;

    @Override
    @Transactional
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Override
    @Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    @Transactional
    public void edit(User user) {
        userDao.edit(user);
    }

    @Override
    @Transactional
    public User getById(int id) {
        return userDao.getById(id);
    }
}
