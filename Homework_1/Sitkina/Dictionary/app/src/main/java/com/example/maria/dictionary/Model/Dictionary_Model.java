package com.example.maria.dictionary.Model;

/**
 * Created by maria on 28.10.17.
 */

public class Dictionary_Model {
    private String id;
    private String word;
    private String definition;

    public Dictionary_Model(String id, String word, String definition) {
        this.id = id;
        this.word = word;
        this.definition = definition;
    }

    public String getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
