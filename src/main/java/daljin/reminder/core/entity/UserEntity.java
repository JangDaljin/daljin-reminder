package daljin.reminder.core.entity;

import daljin.reminder.core.constant.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_USER")
public class UserEntity {
    //UNSIGNED INT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    @Enumerated(EnumType.STRING)
    UserStatus status;

    @Column(nullable = false)
    String name;

    //UNSIGNED SMALL INT
    @Column(nullable = false)
    Integer age;

    @Column(name = "created_at", nullable = false , updatable = false)
    LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user")
    final List<PostEntity> posts = new ArrayList<>();
}
