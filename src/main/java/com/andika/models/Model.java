package com.andika.models;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Model {
    private int nextId = 1;
    private Map<Integer, Story> stories = new HashMap<>();


    @lombok.Data
    class Story {
        private int id;
        private String owner;
        private int length;
        private int phraseLength;
        private int quorum;
    }

    public int createStory(String owner, int length, int phraseLength, int quorum) {
        int id = nextId++;
        Story story = new Story();
        story.setId(id);
        story.setOwner(owner);
        story.setLength(length);
        story.setPhraseLength(phraseLength);
        story.setQuorum(quorum);
        stories.put(id, story);
        return id;
    }

    public List<Story> getAllStories() {
        return stories.keySet().stream().sorted().map((id) -> stories.get(id)).collect(Collectors.toList());
    }
}