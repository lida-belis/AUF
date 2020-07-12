package org.techmeskills.aqa5.auf.models;

public class User {
    private String username;
    private String password;

    public static class Builder{
        private User newUser;

        public Builder() {
            newUser = new User();
        }

        public Builder withUsername(String username) {
            newUser.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            newUser.password = password;
            return this;
        }

        public User build() {
            return newUser;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
