package com.puyan.shengren.agricultural.Config;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName: LocalDateTimeConfig
 * @Description: TODO
 * @Author: idmin
 * @Date: 2020/7/21 15:04
 * @Version: 1.0
 **/
@Configuration
public class LocalDateTimeConfig {
    /**
     * @Author guoyangyang
     * @Description  把localDateTime中日期和时间之间的T消除
     * @Date  2020/7/21 15:08
     * @Param
     * @return * @return: com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
     **/
    @Bean
    public LocalDateTimeSerializer localDateTimeDeserializer() {
        return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> builder.serializerByType(LocalDateTime.class, localDateTimeDeserializer());
    }
}
