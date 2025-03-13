package kz.qbs.course.repository;

import kz.qbs.course.model.Role;
import kz.qbs.course.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@EnableJpaRepositories
public interface UserRepository  extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
    Optional<User> findByRole(Role role);
}
