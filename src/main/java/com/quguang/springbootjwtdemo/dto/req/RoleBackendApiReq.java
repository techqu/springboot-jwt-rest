package com.quguang.springbootjwtdemo.dto.req;

import lombok.Data;

/**
 * Created by 瞿广 on 2018/10/13 0013.
 */
@Data
public class RoleBackendApiReq {
    private String roleId;
    private String [] backendApiIds;
}
