package daljin.reminder.core.repository;

import daljin.reminder.core.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity , Long> {
}
