package com.quguang.springbootjwtdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "pe_permission_menu")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class PermissionMenu extends BaseEntity  {



    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 文本
     */
    @ApiModelProperty(value = "文本")
    @Column(name = "text")
    private String text;

    @ApiModelProperty(value = "angular路由")
    @Column(name = "link")
    private String link;


    //展示图标
    private String menuIcon;

    //排序号
    private String menuOrder;

    @Transient
    private List<PermissionMenu> children;


}
