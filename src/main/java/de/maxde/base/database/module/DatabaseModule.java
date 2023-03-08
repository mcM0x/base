package de.maxde.base.database.module;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import de.maxde.base.database.AbstractDatabase;
import lombok.AllArgsConstructor;
import org.redisson.api.RedissonClient;

import java.sql.Connection;

@AllArgsConstructor
public class DatabaseModule extends AbstractModule {

    private AbstractDatabase<RedissonClient> sqlDatabase;

    @Override
    protected void configure() {
        bind(AbstractDatabase.class).annotatedWith(Names.named("redis")).toInstance(this.sqlDatabase);
    }
}
