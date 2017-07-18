/**
 *
 */
package users.service;

import users.model.UserTO;

/**
 * @author David Ruiz C
 *
 */
public interface UserService {

    boolean create(UserTO to);

    UserTO read(int id);

    boolean update(UserTO to);

    boolean delete(String id);


}
