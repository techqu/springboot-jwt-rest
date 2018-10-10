package com.quguang.springbootjwtdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Menu implements Serializable {

    private static final long serialVersionUID = 1334524323423345L;

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Set<BackendApi> getBackendApis() {
        return backendApis;
    }

    public void setBackendApis(Set<BackendApi> backendApis) {
        this.backendApis = backendApis;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

