package com.hcl.ddl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import com.hcl.setup.config.SpringConfig;

public class ShowDataBases {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        String sql = "SELECT ";
        
        System.out.println("Got  successfully."+jdbcTemplate.queryForList(sql,String.class));
    }
}
