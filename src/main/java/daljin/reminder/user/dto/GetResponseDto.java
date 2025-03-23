package daljin.reminder.user.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class GetResponseDto {
    long count;
    List<GetResponseDto.User> users;

    @AllArgsConstructor
    @Getter
    public static class User {
        Long id;

        String name;
        Integer age;

        String createdAt;
        String updatedAt;
    }
}
