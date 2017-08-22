/**
 *
 */
package gems.model;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.Region;

/**
 * @author David Ruiz C
 *
 */
@Region("gems")
public class GemTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 532647934216775594L;
    private static final AtomicLong COUNTER = new AtomicLong(0L);

    @PersistenceConstructor
    public GemTO() {
        this.id = COUNTER.getAndIncrement();
    }

    @Id
    private long id;
    private String name;
    private String email;
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "GemTO [id=" + id + ", name=" + name + ", email=" + email + "]";
    }



}
