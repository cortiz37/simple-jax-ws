package com.business.repository;

import com.business.model.Element;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * In memory 'database'
 */
@ApplicationScoped
public class ElementRepository {

    private final static List<Element> database = new ArrayList<>();

    static {
        database.add(new Element("default-e1", "Element 1", "Lorem ipsum dolor sit amet", new Date(), true, 5));
        database.add(new Element("default-e2", "Element 2", "Ut enim ad minim veniam", new Date(), false, 0));
        database.add(new Element("default-e3", "Element 3", "Excepteur sint occaecat cupidatat non proident,", new Date(), true, 15));
    }

    public Element save(Element element) {
        database.add(element);
        return element;
    }

    public Optional<Element> getById(String id) {
        return database.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public boolean delete(String id) {
        return database.stream()
            .filter(e -> e.getId().equals(id))
            .findFirst()
            .map(database::remove)
            .orElse(false);
    }

    public List<Element> getDatabase() {
        return database;
    }
}