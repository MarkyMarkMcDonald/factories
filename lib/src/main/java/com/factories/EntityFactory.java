package com.factories;

import java.util.function.Function;

public interface EntityFactory<Entity, EntityBuilder extends Builder<Entity>> {

    EntityBuilder defaultBuilder();

    Entity save(Entity entity);

    default Entity create(Function<EntityBuilder, EntityBuilder> overrides) {
        Entity entity = overrides.apply(defaultBuilder()).build();
        return save(entity);
    }

    default Entity create() {
        return create(builder -> builder);
    }

}
