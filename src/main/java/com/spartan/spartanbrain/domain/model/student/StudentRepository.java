/*
 * ====================================================================================
 *
 * Copyright (c) 2005, 2018
 *
 * ====================================================================================
 */
package com.spartan.spartanbrain.domain.model.student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentRepository extends CrudRepository<Student, Long> {}
