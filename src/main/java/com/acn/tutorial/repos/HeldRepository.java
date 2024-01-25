package com.acn.tutorial.repos;

import com.acn.tutorial.domain.Held;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HeldRepository extends JpaRepository<Held, Long> {
}
