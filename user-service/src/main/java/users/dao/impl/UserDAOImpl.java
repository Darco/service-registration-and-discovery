/**
 *
 */
package users.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import users.dao.UserDAO;
import users.dao.mapper.UserRowMapper;
import users.model.UserTO;

/**
 * @author David Ruiz C
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    /* (non-Javadoc)
     * @see users.dao.UserDAO#create(users.model.UserTO)
     */
    @Override
    public boolean create(UserTO to) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see users.dao.UserDAO#read(java.lang.String)
     */
    @Override
    public UserTO read(int id) {

        UserTO userTO = null;
        try {
            final StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("SELECT id, name, email ");
            sqlBuilder.append("  FROM users ");
            sqlBuilder.append(" WHERE id = :id ");

            LOGGER.info("[sql : {}, id : {}]", sqlBuilder.toString(), id);

            final SqlParameterSource source = new MapSqlParameterSource()
                    .addValue("id", id);

            userTO = jdbcTemplate.queryForObject(sqlBuilder.toString(), source, new UserRowMapper());

            LOGGER.info("user : {}", userTO);
        } catch (EmptyResultDataAccessException e) {
            LOGGER.error("Sin datos", e);
        } catch (IncorrectResultSizeDataAccessException e) {
            LOGGER.error("Registros incorrectos", e);
        } catch (DataAccessException e) {
            LOGGER.error("Error general", e);
        }

        return userTO;
    }

    /* (non-Javadoc)
     * @see users.dao.UserDAO#update(users.model.UserTO)
     */
    @Override
    public boolean update(UserTO to) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see users.dao.UserDAO#delete(java.lang.String)
     */
    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        return false;
    }

}
