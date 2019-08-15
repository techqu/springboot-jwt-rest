package com.quguang.springbootjwtdemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "pe_permission_api")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class PermissionApi extends BaseEntity{


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

    /**
     * 权限等级，1为通用接口权限，2为需校验接口权限
     */
    private String apiLevel;

}
