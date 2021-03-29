package com.business.service;

import com.business.model.Author;
import com.business.model.Book;
import com.business.model.Section;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;
import java.util.stream.Stream;

@ApplicationScoped
public class DBService {

    private final static Map<String, List<Object>> database = new HashMap<>();

    static {
        database.put(Section.class.getSimpleName(), new ArrayList<>());
        database.put(Author.class.getSimpleName(), new ArrayList<>());
        database.put(Book.class.getSimpleName(), new ArrayList<>());

        database.get(Section.class.getSimpleName()).add(new Section("Fantasy"));
        database.get(Section.class.getSimpleName()).add(new Section("Crime"));
        database.get(Section.class.getSimpleName()).add(new Section("Novel"));
        database.get(Section.class.getSimpleName()).add(new Section("Story"));

        database.get(Author.class.getSimpleName()).add(new Author("John S.", "UK"));
        database.get(Author.class.getSimpleName()).add(new Author("Mary J.", "US"));
        database.get(Author.class.getSimpleName()).add(new Author("Luis G.", "ES"));

        database.get(Book.class.getSimpleName()).add(new Book(
                "The perfect crime",
                "Crime",
                Collections.singletonList("John S.")
            )
        );
        database.get(Book.class.getSimpleName()).add(new Book(
                "Laura",
                "Novel",
                Collections.singletonList("John S.")
            )
        );
        database.get(Book.class.getSimpleName()).add(new Book(
                "Bullets",
                "Crime",
                Collections.singletonList("John S.")
            )
        );
        database.get(Book.class.getSimpleName()).add(new Book(
                "My friend the bear",
                "Story",
                Collections.singletonList("Mary J.")
            )
        );
        database.get(Book.class.getSimpleName()).add(new Book(
                "La laguna azul",
                "Fantasy",
                Collections.singletonList("Luis G.")
            )
        );
        database.get(Book.class.getSimpleName()).add(new Book(
                "Mi granja",
                "Fantasy",
                Collections.singletonList("Luis G.")
            )
        );
    }

    public Map<String, List<Object>> getDatabase() {
        return database;
    }

    public Stream<Object> getAsStream(Class clazz) {
        return database.get(clazz.getSimpleName()).stream();
    }
}
