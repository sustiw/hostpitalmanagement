package com.st.yt.hospitalManagement.repository;

import com.st.yt.hospitalManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department ,Long> {
}
