/**
 *
 */
package users.service;

import java.util.ArrayList;

import users.model.UserTO;

/**
 * @author David Ruiz C
 *
 */
public interface UserService {

    String create(UserTO to);

    UserTO read(int id);

    boolean update(UserTO to);

    boolean delete(String id);
    
    ArrayList<UserTO> all();


}
