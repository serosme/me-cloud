package com.example.platform.system;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.model.ClassAnnotationAttributes;
import com.example.shared.mybatisplus.SuperEntity;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CodeGeneratorTest {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Test
    void generateCode() {
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> builder
                        .outputDir(System.getProperty("user.dir") + "/src/main/java")
                        .disableOpenDir())
                .packageConfig(builder -> builder
                        .parent("com.example.platform.system")
                        .entity("entity")
                        .mapper("mapper"))
                .strategyConfig(builder -> builder
                        .addTablePrefix("sys_")

                        // Entity
                        .entityBuilder()
                        .enableFileOverride()
                        .javaTemplate("templates/entity.java")
                        .enableLombok(
                                new ClassAnnotationAttributes("@Data", "lombok.Data"),
                                new ClassAnnotationAttributes("@FieldNameConstants", "lombok.experimental.FieldNameConstants"),
                                new ClassAnnotationAttributes("@EqualsAndHashCode(callSuper = true)", "lombok.EqualsAndHashCode"))
                        .superClass(SuperEntity.class)
                        .addSuperEntityColumns("id", "deletedAt")
                        .enableTableFieldAnnotation()
                        .disableSerialVersionUID()

                        // Mapper
                        .mapperBuilder()
                        .enableFileOverride()
                        .mapperTemplate("templates/mapper.java")
                        .mapperAnnotation(Mapper.class)
                        .superClass(MPJBaseMapper.class)
                        .disableMapperXml()

                        // Service
                        .serviceBuilder()
                        .disable()

                        // Controller
                        .controllerBuilder()
                        .disable())
                .execute();
    }
}
