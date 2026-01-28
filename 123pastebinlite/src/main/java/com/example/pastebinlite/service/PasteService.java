package com.example.pastebinlite.service;

import com.example.pastebinlite.model.Paste;
import com.example.pastebinlite.repository.PasteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class PasteService {
    @Autowired private PasteRepository pasteRepository;
    @Value("${app.test-mode}") private String testMode;

    public String createPaste(String content, Integer ttl, Integer maxViews) {
        String id = UUID.randomUUID().toString().substring(0, 8);
        pasteRepository.save(new Paste(id, content, System.currentTimeMillis(), ttl, maxViews));
        return id;
    }

    public Paste getPaste(String id, String testNowHeader) {
        Paste paste = pasteRepository.findById(id);
        if (paste == null) return null;

        long now = System.currentTimeMillis();
        if ("1".equals(testMode) && testNowHeader != null) {
            try { now = Long.parseLong(testNowHeader); } catch (Exception e) {}
        }

        if (paste.getTtl_seconds() != null) {
            if (now > paste.getCreated_at() + (paste.getTtl_seconds() * 1000)) return null;
        }

        Long newViewCount = pasteRepository.incrementViews(id);
        if (paste.getMax_views() != null && newViewCount > paste.getMax_views()) return null;

        paste.setViews(newViewCount.intValue());
        return paste;
    }
}