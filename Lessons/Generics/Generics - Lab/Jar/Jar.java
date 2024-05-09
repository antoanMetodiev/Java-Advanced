package Jar;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {
    private final Deque<T> collector;

    public Jar() {
        this.collector = new ArrayDeque<>();
    }

    public void add(T el) {
        this.collector.push(el);
    }

    public T remove() {
        return this.collector.pop();
    }
}
