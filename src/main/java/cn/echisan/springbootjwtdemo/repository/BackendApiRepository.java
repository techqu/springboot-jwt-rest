package cn.echisan.springbootjwtdemo.repository;

import cn.echisan.springbootjwtdemo.entity.BackendApi;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BackendApiRepository extends JpaRepository<BackendApi, Integer> {

    @EntityGraph(attributePaths = "menus")
    BackendApi findByPathAndMethod(String path, String method);

    @EntityGraph(attributePaths = "menus")
    List<BackendApi> findByPathStartsWithAndMethod(String path, String method);


}
