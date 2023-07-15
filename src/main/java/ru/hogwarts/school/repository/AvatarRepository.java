package ru.hogwarts.school.repository;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Avatar;

import java.util.List;
import java.util.Optional;


public interface AvatarRepository extends JpaRepository <Avatar, Long> {
    List<Avatar> findAll();
    Optional<Avatar> findAvatarByStudentId (Long studentId);
}
