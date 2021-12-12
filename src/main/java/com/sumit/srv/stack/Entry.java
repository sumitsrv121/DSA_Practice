package com.sumit.srv.stack;

import java.util.Objects;

public class Entry {
    private int position;
    private int value;

    public Entry(int position, int value) {
        this.position = position;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return value == entry.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
