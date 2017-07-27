/**
 *
 */
package bookmarks.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

/**
 * @author David Ruiz C
 *
 */
public class BookmarkTO {

    @Id
    private int id;
    private String description;
    private Date date;

    public BookmarkTO(){
        super();
    }

    public BookmarkTO(Builder builder){
        this.date = builder.date;
        this.description = builder.description;
        this.id = builder.id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }
    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    static Builder getBuilder(){
        return new Builder();
    }

    static class Builder {
        private int id;
        private String description;
        private Date date;

        private Builder(){

        }

        Builder id(int id){
            this.id = id;
            return this;
        }

        Builder description(String description){
            this.description = description;
            return this;
        }

        Builder date(Date date){
            this.date = date;
            return this;
        }

        BookmarkTO build(){
            return new BookmarkTO(this);
        }
    }

}
