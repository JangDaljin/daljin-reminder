package daljin.reminder.user.domain;

import lombok.*;

import java.util.Date;



@Getter
@Setter
@Builder
public class User {

    @NonNull
    private Integer id;

    @NonNull
    private String name;
    @NonNull
    private Integer age;

    @NonNull
    private Date createdAt;
    @NonNull
    private Date updatedAt;
}
