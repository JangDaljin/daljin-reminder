package daljin.reminder.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PutRequestDto {
    String name;
    Integer age;
}
