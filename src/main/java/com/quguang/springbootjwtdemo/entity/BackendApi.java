package com.quguang.springbootjwtdemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class BackendApi implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tag")
    private String tag;

    @Column(name = "path")
    private String path;

    @Column(name = "method")
    private String method;

    @Column(name = "summary")
    private String summary;

    @Column(name = "operation_id")
    private String operationId;

    @ManyToMany(mappedBy = "backendApis")
//    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Menu> menus = new HashSet<>();

}