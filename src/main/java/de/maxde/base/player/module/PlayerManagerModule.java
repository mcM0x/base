package de.maxde.base.player.module;

import com.google.inject.AbstractModule;
import de.maxde.base.player.AbstractPlayerManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayerManagerModule extends AbstractModule {

    private AbstractPlayerManager playerManager;

    @Override
    protected void configure() {
        bind(AbstractPlayerManager.class).toInstance(this.playerManager);
    }
}
