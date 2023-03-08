package de.maxde.base.uuid.module;

import com.google.inject.AbstractModule;
import de.maxde.base.uuid.AbstractUUIDManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UUIDModule extends AbstractModule {

    private AbstractUUIDManager uuidManager;

    @Override
    protected void configure() {
        bind(AbstractUUIDManager.class).toInstance(this.uuidManager);
    }
}
