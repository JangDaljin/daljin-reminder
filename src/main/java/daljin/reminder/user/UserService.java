package daljin.reminder.user;

import daljin.reminder.core.constant.UserStatus;
import daljin.reminder.core.entity.UserEntity;
import daljin.reminder.core.repository.UserRepository;
import daljin.reminder.user.dto.GetByIdResponseDto;
import daljin.reminder.user.dto.GetResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service()
public class UserService {


    private final UserRepository userRepository;

    public UserService(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    public GetResponseDto page(int pageNo, int pageSize) {
        Page<UserEntity> page = this.userRepository.findByStatus(UserStatus.ENABLED, PageRequest.of(
                pageNo - 1,
                pageSize
        ));


        return new GetResponseDto(
                page.getTotalElements(),
                page.getContent().stream().map(user -> new GetResponseDto.User(
                        user.getId(),
                        user.getName(),
                        user.getAge(),
                        user.getCreatedAt().format(DateTimeFormatter.BASIC_ISO_DATE),
                        user.getUpdatedAt().format(DateTimeFormatter.BASIC_ISO_DATE)
                )).toList()
        );
    }

    public GetByIdResponseDto getUser(long id) {
        UserEntity user = this.userRepository.findById((long) id).orElseThrow();
        return new GetByIdResponseDto(
                user.getId(),
                user.getName(),
                user.getAge(),
                user.getCreatedAt().format(DateTimeFormatter.BASIC_ISO_DATE),
                user.getUpdatedAt().format(DateTimeFormatter.BASIC_ISO_DATE)
        );
    }

    public void create(String name, int age) {
        UserEntity newUser = UserEntity.builder()
                .status(UserStatus.ENABLED)
                .name(name)
                .age(age)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        this.userRepository.save(newUser);
    }


    public void update(long id, String name, int age) {
        UserEntity user = this.userRepository.findById(id).orElseThrow();
        user.setName(name);
        user.setAge(age);
        user.setUpdatedAt(LocalDateTime.now());
        this.userRepository.save(user);
    }

    public void delete(long id) {
        UserEntity user = this.userRepository.findById(id).orElseThrow();
        user.setStatus(UserStatus.DELETED);

        this.userRepository.save(user);
    }
}
