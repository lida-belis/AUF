package org.techmeskills.aqa5.auf.models;

public class Project {
    private String name;
    private String job;
    private String email;
    private String password;

    public static class Builder {
        private Project newProject;

        public Builder() {
            newProject = new Project();
        }

        public Builder withName(String name) {
            newProject.name = name;
            return this;
        }

        public Builder withJob(String job) {
            newProject.job = job;
            return this;
        }

        public Builder withEmail(String email) {
            newProject.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            newProject.password = password;
            return this;
        }

        public Project build() {
            return newProject;
        }
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
