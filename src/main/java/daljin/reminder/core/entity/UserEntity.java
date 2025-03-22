package daljin.reminder.core.entity;

import daljin.reminder.core.constant.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_user")
public class UserEntity {
    //UNSIGNED INT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    @ColumnDefault("'ENABLED'")
    @Enumerated(EnumType.STRING)
    UserStatus status;

    @Column(nullable = false)
    String name;

    //UNSIGNED SMALL INT
    @Column(nullable = false)
    Integer age;

    @Column(name = "created_at")
    @CreatedDate
    LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    LocalDateTime updatedAt;
}
