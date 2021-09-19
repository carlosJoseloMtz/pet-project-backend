package mx.nopaloverflow.petservices.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;


public class BaseModel {

    @Id
    private String id;

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastUpdated;
    private boolean enabled;

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof BaseModel)) {
            return super.equals(obj);
        }

        final var model = (BaseModel) obj;
        return this.getId().equals(model.getId());
    }

    @Override
    public int hashCode() {
        // object has not been saved/bound to the database
        if (this.id == null) {
            return super.hashCode();
        }

        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "[" + getClass().getSimpleName() + "=" + this.getId() + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
