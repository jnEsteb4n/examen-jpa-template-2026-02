package com.example.demo.repository;

import com.example.demo.model.PullRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPullRequestRepository extends JpaRepository<PullRequest, Long> {
    /**
     * Listar los Pull Requests asociados a un curso específico (por nombre del Classroom) y
     * con un estado determinado (status), ordenados por fecha de creación de manera
     * descendente.
     */

    List<PullRequest> findByRepository_Assignment_Classroom_NameAndStatusOrderByCreatedAtDesc(
            String classroomName, String status);

    /**
     * Obtener los Pull Requests donde el revisor pertenezca a un rol específico (e.g. 'TA' o
     * 'TEACHER'), el autor del PR tenga un nombre de usuario (username) dado, y
     * pertenezcan a un Classroom de un semestre específico.
     */

    List<PullRequest> findByReviewer_RoleAndAuthor_UsernameAndRepository_Assignment_Classroom_Semester(
            String reviewerRole, String authorUsername, String semester);
}
