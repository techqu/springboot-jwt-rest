package cn.echisan.springbootjwtdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
public class Menu implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 文本
     */
    @ApiModelProperty(value = "文本")
    @Column(name = "text")
    private String text;

    @ApiModelProperty(value = "angular路由")
    @Column(name = "link")
    private String link;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "backend_api_menus",
            joinColumns = @JoinColumn(name="menus_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="backend_apis_id", referencedColumnName="id"))
//    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<BackendApi> backendApis = new HashSet<>();

    @ManyToMany(mappedBy = "menus")
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();
}

