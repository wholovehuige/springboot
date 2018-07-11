//package com.roy.tools.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.servlet.resource.ResourceUrlProvider;
//
///**
// * 为静态资源添加版本号,防止静态资源修改后，用户因为浏览器缓存无法获得最新静态资源方法
// */
//@ControllerAdvice
//public class ResourceUrlProviderController {
//
//    @Autowired
//    private ResourceUrlProvider resourceUrlProvider;
//
//    @ModelAttribute("urls")
//    public ResourceUrlProvider urls() {
//        return this.resourceUrlProvider;
//    }
//}