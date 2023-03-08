package de.maxde.base.player.rank.permissions;

import java.util.Collection;

public abstract class AbstractPermissionList implements Iterable<String>{

    public abstract Collection<String> getAllPermissions();

    public abstract boolean contains(String permission);

    public abstract void add(String permission);

    public abstract void remove(String permission);

}
