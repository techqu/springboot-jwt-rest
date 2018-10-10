package cn.echisan.springbootjwtdemo.repository;

import cn.echisan.springbootjwtdemo.entity.Menu;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MenuRepository extends JpaRepository<Menu, Integer> {

    @EntityGraph(attributePaths = "roles")
    Menu findOneWithRolesById(long id);

}
