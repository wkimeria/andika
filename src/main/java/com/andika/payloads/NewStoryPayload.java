package com.andika.payloads;

import lombok.Data;

@lombok.Data
public class NewStoryPayload {
    private String owner;
    private int length;
    private int phraseLength;
    private int quorum;

    public boolean isValid() {
        return !(owner == null || owner.isEmpty() || length == 0 || phraseLength == 0 || quorum == 0);
    }
}