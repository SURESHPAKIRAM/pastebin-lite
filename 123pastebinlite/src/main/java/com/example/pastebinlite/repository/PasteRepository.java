package com.example.pastebinlite.repository;

import com.example.pastebinlite.model.Paste;
import org.springframework.stereotype.Repository;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@Repository
public class PasteRepository {
    // We use a HashMap instead of Redis for local testing
    private final Map<String, Paste> store = new ConcurrentHashMap<>();

    public void save(Paste paste) {
        store.put(paste.getId(), paste);
    }

    public Paste findById(String id) {
        return store.get(id);
    }

    public Long incrementViews(String id) {
        Paste paste = store.get(id);
        if (paste != null) {
            paste.setViews(paste.getViews() + 1);
            return (long) paste.getViews();
        }
        return 0L;
    }
}