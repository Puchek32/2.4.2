package testgroup.CRUD_prilozhenie.dao;

import org.springframework.stereotype.Repository;
import testgroup.CRUD_prilozhenie.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Role> allRoles() {
        return manager.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public void add(Role role) {
        manager.persist(role);
    }

    @Override
    public void delete(Role role) {
        manager.remove(manager.find(Role.class, role.getId()));
    }

    @Override
    public void edit(Role role) {
        manager.merge(role);
    }

    @Override
    public Role getById(int id) {
        return manager.find(Role.class, id);
    }
}
