package daljin.reminder.user.dto;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetResponseDto {
    @NonNull
    public Integer count;
    @NonNull
    public List<GetResponseDto.User> users;

    @RequiredArgsConstructor
    public static class User {
        @NonNull
        public Integer id;

        @NonNull
        String name;
        @NonNull
        public Integer age;

        @NonNull
        public String createdAt;
        @NonNull
        public String updatedAt;
    }
}
