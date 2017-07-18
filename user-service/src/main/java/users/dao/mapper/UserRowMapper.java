/**
 *
 */
package users.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import users.model.UserTO;

/**
 * @author David Ruiz C
 *
 */
public class UserRowMapper implements RowMapper<UserTO> {

    /* (non-Javadoc)
     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
     */
    @Override
    public UserTO mapRow(ResultSet arg0, int arg1) throws SQLException {
        final UserTO userTO = new UserTO();
        userTO.setEmail(arg0.getString("email"));
        userTO.setId(arg0.getInt("id"));
        userTO.setName(arg0.getString("name"));
        return userTO;
    }

}
