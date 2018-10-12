package com.quguang.springbootjwtdemo.config;

import com.quguang.springbootjwtdemo.entity.BackendApi;
import com.quguang.springbootjwtdemo.entity.Role;
import com.quguang.springbootjwtdemo.repository.BackendApiRepository;
import com.quguang.springbootjwtdemo.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AppFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {


    @Autowired
    private BackendApiRepository backendApiRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private FilterInvocationSecurityMetadataSource  superMetadataSource;

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

//    private MenuRepository menuRepository;
//    private BackendApiRepository backendApiRepository;

//    public void init(MenuRepository menuRepository, BackendApiRepository backendApiRepository) {
//        this.menuRepository = menuRepository;
//        this.backendApiRepository = backendApiRepository;
//    }
    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }




    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation) object;

        List<Role> neededRoles = this.getRequestNeededRoles(fi.getRequest().getMethod(), fi.getRequestUrl());

        if (neededRoles != null) {
            return SecurityConfig.createList(neededRoles.stream().map(role -> role.getName()).collect(Collectors.toList()).toArray(new String[]{}));
        }

        //没有匹配上的资源，都是登录访问
        return SecurityConfig.createList("ROLE_LOGIN");
//        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    public List<Role> getRequestNeededRoles(String method, String path) {
        String rawPath = path;
        //  remove parameters
        if (path.indexOf("?") > -1) {
            path = path.substring(0, path.indexOf("?"));
        }
        // /menus/{id}
        BackendApi api = backendApiRepository.findByPathAndMethod(path, method);
        if (api == null) {
            // try fetch by remove last path
            api = loadFromSimilarApi(method, path, rawPath);
        }

        if (api != null && api.getRoles().size() > 0) {
            return api.getRoles()
                    .stream()
                    .collect(Collectors.toList());
        }
        return null;
    }

    private BackendApi loadFromSimilarApi(String method, String path, String rawPath) {
        if (path.lastIndexOf("/") > -1) {
            path = path.substring(0, path.lastIndexOf("/"));
            List<BackendApi> apis = backendApiRepository.findByPathStartsWithAndMethod(path, method);

            // 如果为空，再去掉一层path
            while (apis == null) {
                if (path.lastIndexOf("/") > -1) {
                    path = path.substring(0, path.lastIndexOf("/"));
                    apis = backendApiRepository.findByPathStartsWithAndMethod(path, method);
                } else {
                    break;
                }
            }

            if (apis != null) {
                for (BackendApi backendApi : apis) {
                    if (antPathMatcher.match(backendApi.getPath(), rawPath)) {
                        return backendApi;
                    }
                }
            }
        }
        return null;
    }


}
