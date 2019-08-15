package com.quguang.springbootjwtdemo.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "bigint COMMENT '主键'")
    protected Long id;

    @Version
	@Column(nullable = false, columnDefinition = "int default 0 COMMENT '乐观锁标记'")
	protected Integer version;

    @CreatedDate
	@Column(columnDefinition = "datetime default current_timestamp COMMENT '创建时间'")
	protected Date createDate;

	@Column(columnDefinition = "varchar(64) COMMENT '创建人id'")
	protected String createUserId;

	@Column(columnDefinition = "varchar(64) COMMENT '创建人姓名'")
	protected String createUserName;

    @LastModifiedDate
	@Column(columnDefinition = "datetime COMMENT '上次更新时间'")
	protected Date updateDate;

	@Column(columnDefinition = "varchar(64) COMMENT '上次更新人id'")
	protected String updateUserId;

	@Column(columnDefinition = "varchar(64) COMMENT '上次更新人姓名'")
	protected String updateUserName;

    /**
     * 0-未删除 1-已删除 默认:0
     */
	@Column(nullable = false, columnDefinition = "tinyint default 0 COMMENT '逻辑删除标记'")
    protected Integer deleteStatus = 0;
}
