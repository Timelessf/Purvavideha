package cn.purvavideha.moff.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.config
 * @Author: 朱喜亮
 * @CreateTime: 2019-01-03 11:42
 * @Description: mybaitsplus分页插件
 * @Version: 1.0
 */
@Configuration
@MapperScan("cn.purvavideha.moff.dao")
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
