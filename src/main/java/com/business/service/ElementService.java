package com.business.service;

import com.business.helper.JsonHelper;
import com.business.model.Element;
import com.business.repository.ElementRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Dependent
public class ElementService {

    @Inject
    private ElementRepository elementRepository;

    @Inject
    private JsonHelper jsonHelper;

    public List<Element> getAll() {
        return elementRepository.getDatabase();
    }

    public Optional<Element> getElementById(String id) {
        return elementRepository.getById(id);
    }

    public boolean delete(String id) {
        return elementRepository.delete(id);
    }

    public Element create(Element element) {
        element.setId(UUID.randomUUID().toString());
        return elementRepository.save(element);
    }

    public Optional<Element> replace(String id, Element element) {
        element.setId(id);
        if (delete(id)) {
            return Optional.of(elementRepository.save(element));
        }
        return Optional.empty();
    }

    public Optional<Element> merge(String id, Element element) throws IOException {
        element.setId(null);
        final Optional<Element> elementById = getElementById(id);
        if (elementById.isPresent()) {
            Element original = elementById.get();
            jsonHelper.merge(original, element);
            return elementById;
        }
        return Optional.empty();
    }
}