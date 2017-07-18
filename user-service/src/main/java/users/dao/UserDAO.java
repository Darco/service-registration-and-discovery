/**
 *
 */
package users.dao;

import users.model.UserTO;

/**
 * @author David Ruiz C
 *
 */
public interface UserDAO {

    boolean create(UserTO to);

    UserTO read(int id);

    boolean update(UserTO to);

    boolean delete(String id);

}
