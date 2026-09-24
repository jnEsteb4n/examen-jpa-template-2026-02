package com.example.demo.repository;

import com.example.demo.model.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface IRepositoryRepository extends JpaRepository<Repository, Long> {
    /**
     * Obtener los repositorios derivados (que tengan un repositorio plantilla padre no nulo)
     * cuyo docente titular del Classroom tenga un correo institucional específico y cuya fecha
     * límite de entrega (deadline) sea posterior a una fecha dada.
     */

    List<Repository> findByParentRepositoryIsNotNullAndAssignment_Classroom_Teacher_EmailAndAssignment_DeadlineAfter(
            String teacherEmail, Timestamp deadline);

}
