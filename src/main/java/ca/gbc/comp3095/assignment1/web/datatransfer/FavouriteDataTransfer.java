package ca.gbc.comp3095.assignment1.web.datatransfer;

import org.springframework.stereotype.Component;

@Component
public class FavouriteDataTransfer {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
