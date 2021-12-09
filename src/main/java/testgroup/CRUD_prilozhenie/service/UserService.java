package testgroup.CRUD_prilozhenie.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import testgroup.CRUD_prilozhenie.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserService extends UserDetailsService {
    List<User> allUsers();

    void add(User user);

    void delete(User user);

    void edit(User user);

    User getById(int id);

    User findByUsername(String username);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
