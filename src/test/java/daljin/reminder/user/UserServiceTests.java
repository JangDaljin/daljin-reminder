package daljin.reminder.user;

import daljin.reminder.core.constant.UserStatus;
import daljin.reminder.core.entity.UserEntity;
import daljin.reminder.core.repository.UserRepository;
import daljin.reminder.user.dto.GetByIdResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.springframework.test.util.AssertionErrors.assertEquals;


@ExtendWith(MockitoExtension.class)
public class UserServiceTests {


    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Nested
    @DisplayName("단일 유저 조회")
    class GetUserTests {
        @Test
        void getUser() {
            UserEntity mockUserEntity;
            mockUserEntity = new UserEntity(1L, UserStatus.ENABLED, "test", 10, LocalDateTime.now(), LocalDateTime.now());

            Mockito.when(userRepository.findById(mockUserEntity.getId())).thenReturn(Optional.of(mockUserEntity));

            GetByIdResponseDto dto = userService.getUser(mockUserEntity.getId());

            GetByIdResponseDto expected = new GetByIdResponseDto(mockUserEntity.getId(), mockUserEntity.getName(), mockUserEntity.getAge(), mockUserEntity.getCreatedAt().toString(), mockUserEntity.getUpdatedAt().toString());
            assertEquals("DTO IS NOT EQUAL" ,  expected , dto );
        }
    }
}
