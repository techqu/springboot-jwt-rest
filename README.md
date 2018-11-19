# springboot-jwt-rest

## 简介
这是一个使用了springboot+springSecurity+jwt实现的基于token的权限管理的一个demo


## 使用
更改一下`application.properites`的数据库的一些配置信息，然后就可以运行了

首先注册的url是`/auth/register`
参数很简单就`username`,`password`

然后登陆是`/auth/login`

参数名称 | 类型 | 说明
------- | ---- | ----
username | String | 用户名
password | String | 密码
rememberMe | Interge | 记住我，只有两个值可以选，0:不记住，1:记住

推荐使用postman去测试，登陆成功后在响应头里可以找到token

## 一、简单叙述
首先会进入UsernamePasswordAuthenticationFilter并且设置权限为null和是否授权为false，
然后进入ProviderManager查找支持UsernamepasswordAuthenticationToken的provider
并且调用provider.authenticate(authentication);
再然后就是UserDetailsService接口的实现类（也就是自己真正具体的业务了），
这时候都检查过了后，就会回调UsernamePasswordAuthenticationFilter并且设置权限（具体业务所查出的权限）和设置授权为true（因为这时候确实所有关卡都检查过了）。

- UsernamePasswordAuthenticationFilter
- Authentication
- AuthenticationManager
- AuthenticationProvider
- UserDetailsService
// 回到起点进行后续操作，比如缓存认证信息到session和调用成功后的处理器等等
- UsernamePasswordAuthenticationFilter

