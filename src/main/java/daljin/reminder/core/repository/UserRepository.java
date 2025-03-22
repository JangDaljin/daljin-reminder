package daljin.reminder.core.repository;

import daljin.reminder.core.constant.UserStatus;
import daljin.reminder.core.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Page<UserEntity> findByStatus(UserStatus status, Pageable pageable);


}
