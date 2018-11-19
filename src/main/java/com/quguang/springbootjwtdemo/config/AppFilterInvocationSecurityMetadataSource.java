package com.quguang.springbootjwtdemo.config;

import com.quguang.springbootjwtdemo.entity.BackendApi;
import com.quguang.springbootjwtdemo.entity.Role;
import com.quguang.springbootjwtdemo.repository.BackendApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 资源源数据定义，将所有的资源和权限对应关系建立起来，即定义某一资源可以被哪些角色访问
 */
public class AppFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {


    @Autowired
    private BackendApiRepository backendApiRepository;


    private final AntPathMatcher antPathMatcher = new AntPathMatcher();


    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }


    /**
     * 重写getAttributes方法，
     * 通过api和method动态获取需要的roles列表，添加到attributes中
     * @param object
     * @return
     * @throws IllegalArgumentException
     */

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation) object;

        List<Role> neededRoles = this.getRequestNeededRoles(fi.getRequest().getMethod(), fi.getRequestUrl());

        if (neededRoles != null) {
            return SecurityConfig.createList(
                    neededRoles.stream()
                               .map(role -> role.getName())
                               .collect(Collectors.toList())
                               .toArray(new String[]{}));
        }

        //没有匹配上的资源，都是登录访问
        return SecurityConfig.createList("ROLE_LOGIN");
//        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    /**
     * 核心是getRequestNeededRoles怎么实现，
     * 获取到干净的RequestUrl（去掉参数）,
     * 然后看是否有对应的backendAPI，
     * 如果没有，则有可能该API有path参数，我们可以去掉最后的path，去库里模糊匹配，直到找到。
     * @param method
     * @param path
     * @return
     */
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
