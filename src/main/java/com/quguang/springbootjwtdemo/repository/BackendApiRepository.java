package com.quguang.springbootjwtdemo.repository;

import com.quguang.springbootjwtdemo.entity.BackendApi;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BackendApiRepository extends JpaRepository<BackendApi, Integer> {

    @EntityGraph(attributePaths = "roles")
    BackendApi findByPathAndMethod(String path, String method);

    @EntityGraph(attributePaths = "roles")
    List<BackendApi> findByPathStartsWithAndMethod(String path, String method);


}
