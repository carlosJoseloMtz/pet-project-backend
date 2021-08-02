package mx.nopaloverflow.petservices.dtos;

import java.io.Serializable;

public class BaseDto implements Serializable {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
