package daljin.reminder.core.entity;


import daljin.reminder.core.constant.PostStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_POST")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    UserEntity user;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    PostStatus status;

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    String content;

    @Column(name = "created_at",nullable = false , updatable = false)
    LocalDateTime createdAt;

    @Column(name = "updated_at",nullable = false)
    LocalDateTime updatedAt;

}
