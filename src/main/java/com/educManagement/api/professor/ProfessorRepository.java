package com.educManagement.api.professor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Professor findByCpf(String cpf);

    Page<Professor> findAllByAtivoTrue(Pageable paginacao);
}
