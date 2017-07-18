/**
 *
 */
package users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import users.dao.UserDAO;
import users.model.UserTO;
import users.service.UserService;

/**
 * @author David Ruiz C
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    /* (non-Javadoc)
     * @see users.service.UserService#create(users.model.UserTO)
     */
    @Override
    public boolean create(UserTO to) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see users.service.UserService#read(java.lang.String)
     */
    @Override
    public UserTO read(int id) {

        return userDAO.read(id);
    }

    /* (non-Javadoc)
     * @see users.service.UserService#update(users.model.UserTO)
     */
    @Override
    public boolean update(UserTO to) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see users.service.UserService#delete(java.lang.String)
     */
    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        return false;
    }

}
