package daljin.reminder.user.dto;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetByIdResponseDto {
    @NonNull
    public Integer id;

    @NonNull
    public String name;
    @NonNull
    public Integer age;

    @NonNull
    public String createdAt;
    @NonNull
    public String updatedAt;
}
