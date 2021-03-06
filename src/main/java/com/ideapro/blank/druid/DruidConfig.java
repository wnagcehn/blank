package com.ideapro.blank.druid;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


/**
 * 配置druid需要的配置类，引入application.yml文件中以spring.datasource开头的信息
 * 因此需要在application.yml文件中配置相关信息。
 */
@Configuration
public class DruidConfig {
    private static final String DB_PREFIX = "spring.datasource.druid";

    @Bean
    @ConfigurationProperties(prefix = DB_PREFIX)
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }
//
//    @Bean
//    public ServletRegistrationBean statViewServlet(){
//        //创建servlet注册实体
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
//        //设置ip白名单
//        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
//        //设置ip黑名单
//        servletRegistrationBean.addInitParameter("deny","192.168.0.2");
//        //设置控制台管理用户__登录用户名和密码
//        servletRegistrationBean.addInitParameter("loginUsername","admin");
//        servletRegistrationBean.addInitParameter("loginPassword","123456");
//        //是否可以重置数据
//        servletRegistrationBean.addInitParameter("resetEnable","false");
//        return servletRegistrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean statFilter(){
//        //创建过滤器
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
//        //设置过滤器过滤路径
//        filterRegistrationBean.addUrlPatterns("/*");
//        //忽略过滤的形式
//        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }

}
