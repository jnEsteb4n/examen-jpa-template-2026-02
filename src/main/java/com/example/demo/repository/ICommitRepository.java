package com.example.demo.repository;

import com.example.demo.model.Commit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommitRepository extends JpaRepository<Commit, Long> {

    /**
     * Listar los commits realizados en repositorios derivados de una plantilla con nombre
     * específico, cuyo mensaje contenga una palabra clave (ignorando
     * mayúsculas/minúsculas) y la cantidad de líneas añadidas sea estrictamente mayor a un
     * valor dado.
     */

    List<Commit> findByRepository_ParentRepository_NameAndMessageContainingIgnoreCaseAndLinesAddedGreaterThan(
            String templateName, String keyword, Integer linesAdded);
}
