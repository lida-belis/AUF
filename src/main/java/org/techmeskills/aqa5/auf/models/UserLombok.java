package org.techmeskills.aqa5.auf.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Getter
@Setter
public class UserLombok {
    private String username;
    private String password;
}
