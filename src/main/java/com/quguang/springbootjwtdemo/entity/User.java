package com.quguang.springbootjwtdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by quguang on 2018/6/23
 */
@Data
@Entity
@Table(name = "bs_user")
@ApiModel(description= "返回用户信息")
public class User  extends BaseEntity {

    @ApiModelProperty(value = "用户名")
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;



    @JsonIgnore
    @ManyToMany(cascade=CascadeType.ALL)
    @org.hibernate.annotations.ForeignKey(name="none")
    @JoinTable(
            name = "pe_user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
//    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @BatchSize(size = 100)
    private Set<Role> roles = new HashSet<>();//用户与角色   多对多





}
