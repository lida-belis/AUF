package org.techmeskills.aqa5.auf.models;

import lombok.*;

@Data
@Getter
@ToString
@EqualsAndHashCode
@Builder
public class ProjectLombok {
    private String name;
    private String job;
    private String email;
    private String password;
}
