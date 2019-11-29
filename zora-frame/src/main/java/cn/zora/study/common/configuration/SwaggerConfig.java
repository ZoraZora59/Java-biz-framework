package cn.zora.study.common.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <h3>study</h3>
 * <p>Swagger配置信息</p>
 *
 * @author : zora
 * @date : 2019/11/28
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = "swagger.enable",havingValue = "true")
public class SwaggerConfig {
    @Bean
    public Docket allInOneRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("博客All In One")
                .apiInfo(new ApiInfoBuilder().title("博客API接口文档").description("Restful接口").build())
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.zora.study.blog.basic.web.api"))
                .paths(PathSelectors.any())
                .build();
    }
}
