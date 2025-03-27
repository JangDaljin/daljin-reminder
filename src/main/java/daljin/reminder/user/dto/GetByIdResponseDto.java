package daljin.reminder.user.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetByIdResponseDto {
    Long id;

    String name;
    Integer age;

    String createdAt;
    String updatedAt;
}
