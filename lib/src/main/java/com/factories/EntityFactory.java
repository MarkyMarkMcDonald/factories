package com.factories;

import org.duckapter.Duck;

import java.util.function.Function;

public interface EntityFactory<Entity, EntityBuilder> {

    EntityBuilder defaultBuilder();

    Entity save(Entity entity);

    default Entity create(Function<EntityBuilder, EntityBuilder> overrides) {
        Entity entity = build(overrides);
        return save(entity);
    }

    default Entity build(Function<EntityBuilder, EntityBuilder> overrides) {
        EntityBuilder defaultBuilder = defaultBuilder();

        EntityBuilder overriddenBuilder = overrides.apply(defaultBuilder);

        Builder<Entity> duckedBuilder = Duck.type(overriddenBuilder, Builder.class);

        return duckedBuilder.build();
    }

    default Entity build() {
        Builder<Entity> duckedBuilder = Duck.type(defaultBuilder(), Builder.class);
        return duckedBuilder.build();
    }

    default Entity create() {
        return create(overrides -> overrides);
    }

    Class<EntityBuilder> builderClass();

}
