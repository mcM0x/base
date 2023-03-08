package de.maxde.base.database.manipulator;

public abstract class AbstractDatabaseManipulator<V> extends AbstractDatabaseGetter<V> {

    public abstract void set(V v);
}
