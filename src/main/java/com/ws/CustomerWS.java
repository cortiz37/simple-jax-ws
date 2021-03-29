package com.ws;

import com.business.model.Author;
import com.business.model.Book;
import com.business.model.Section;
import com.business.service.DBService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@WebService(serviceName = "bookStore", portName = "bookStorePort")
public class CustomerWS {

    @Inject
    private DBService dbService;

    public Book getBook(String title) {
        return dbService.getAsStream(Book.class)
            .map(o -> (Book) o)
            .filter(b -> b.getTitle() == title)
            .findFirst().get();
    }

    public List<Author> getAllAuthors() {
        return dbService.getAsStream(Author.class)
            .map(o -> (Author) o)
            .collect(Collectors.toList());
    }

    public List<Section> getAllSections() {
        return dbService.getAsStream(Section.class)
            .map(o -> (Section) o)
            .collect(Collectors.toList());
    }

    public Boolean registerNewSection(String sectionName) {
        return dbService.getDatabase().get(Section.class.getSimpleName()).add(new Section(sectionName));
    }
}
