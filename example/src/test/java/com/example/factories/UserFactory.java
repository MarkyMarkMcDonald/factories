package com.example.factories;

import com.example.User;
import com.example.UserBuilder;
import com.factories.EntityFactory;

public class UserFactory implements EntityFactory<User, UserBuilder> {

    @Override
    public UserBuilder defaultBuilder() {
        return new UserBuilder();
    }

    @Override
    public User save(User user) {
        return user;
    }
}
