package daljin.reminder.user.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Getter
public class GetResponseDto {
    Integer count;
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
