/**
 *
 */
package users.dao.impl;

import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import users.dao.UserDAO;
import users.dao.mapper.UserRowMapper;
import users.model.UserTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;  

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
    public String create(UserTO to) {
    	String mensaje = " ";
           // Connection con = null; 
            //Statement stmt = null; 
            //int result = 0; 
            try { 
               /*Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
               con = DriverManager.getConnection( "jdbc:hsqldb:mem:dataSource", "sa", ""); 
               stmt = con.createStatement(); 
               result = stmt.executeUpdate("INSERT INTO users VALUES (5, 'Jeshua Cabrera', 'jeshua.cabrera@planetmedia.com.mx', NOW())"); 
               con.commit(); */
            	String query = "INSERT INTO users VALUES (:id, :name, :email)";
            	Map<String, Object> paramMap = new HashMap<String, Object>();
            	paramMap.put("id",to.getId());
            	paramMap.put("name",to.getName());
            	paramMap.put("email",to.getEmail());
            	jdbcTemplate.update(query, paramMap);
            	
            }catch (Exception e) { 
               //e.printStackTrace(System.out); 
               LOGGER.error("error al insertar", e);
               mensaje = "error al insertar";
            }
            	
           // System.out.println(result + " filas afectadas"); 
            mensaje = "datos insertados correctamente"; 


        //return userTO;
        return mensaje;
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

	@Override
	public ArrayList<UserTO> all() {
		final StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("SELECT id, name, email ");
        sqlBuilder.append(" FROM users");
        
		return (ArrayList<UserTO>) this.jdbcTemplate.query(sqlBuilder.toString(), new RowMapper<UserTO>() {
	        
	        public UserTO mapRow(ResultSet rs, int i) throws SQLException {
	        	UserTO p = new UserTO();
	            p.setId(rs.getInt("id"));
	            p.setName(rs.getString("name"));
	            p.setEmail(rs.getString("email"));
	            return p;
	        }
	    });
	}

}