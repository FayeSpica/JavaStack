package jre.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebContext {
    private List<Entity> entities;
    private List<Mapping> mappings;

    private Map<String,String> entityMap = new HashMap<>();
    private Map<String,String> mappingMap = new HashMap<>();

    public WebContext(List<Entity> entities, List<Mapping> mappings) {
        this.entities = entities;
        this.mappings = mappings;

        entities.stream().forEach(entity -> entityMap.put(entity.getName(),entity.getClz()));
        mappings.stream().forEach(mapping -> {
            mapping.getPatterns().stream().forEach(pattern->{
                mappingMap.put(pattern,mapping.getName());
            });
        });
    }

    public String getClz(String pattern){
        return entityMap.get(mappingMap.get(pattern));
    }

    @Override
    public String toString() {
        return "WebContext{" +
                "entities=" + entities +
                ", mappings=" + mappings +
                ", entityMap=" + entityMap +
                ", mappingMap=" + mappingMap +
                '}';
    }
}
