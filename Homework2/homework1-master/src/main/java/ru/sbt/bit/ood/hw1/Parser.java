package ru.sbt.bit.ood.hw1;

/**
 * Created by Григорий on 20.12.2016.
 */

public interface Parser<T> {
    public Iterable<T> parse();
}
