package ca.gbc.comp3095.assignment1.service;

import ca.gbc.comp3095.assignment1.model.Shopping;
import ca.gbc.comp3095.assignment1.web.datatransfer.ShoppingDataTransfer;

import java.util.List;

public interface ShoppingService {
    Shopping save(ShoppingDataTransfer shoppingDataTransfer, String name);

    List<Shopping> findAll();

    Shopping findById(long id);

    List<Shopping> findByKeyword(String keyword);
}
