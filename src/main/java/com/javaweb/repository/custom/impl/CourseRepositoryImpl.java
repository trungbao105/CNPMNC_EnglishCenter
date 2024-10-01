package com.javaweb.repository.custom.impl;

import com.javaweb.entity.CourseEntity;
import com.javaweb.model.request.CourseSearchRequest;
import com.javaweb.repository.custom.CourseRepositoryCustom;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;
@Repository
@PropertySource("classpath:application.properties")
@Primary
public class CourseRepositoryImpl implements CourseRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;
    @Value("${spring.datasource.url}")
    private String DB_URL;
    @Value("${spring.datasource.username}")
    private String USER;
    @Value("${spring.datasource.password}")
    private String PASS;
    public static void queryNormal(CourseSearchRequest courseSearchRequest, StringBuilder where) {
        try {
            Field[] fields = CourseSearchRequest.class.getDeclaredFields();
            for (Field item : fields) {
                item.setAccessible(true);
                String fieldName = item.getName();
                if (!fieldName.equals("staffId")){
                    Object value = item.get(courseSearchRequest);
                    if (value != null && value!="") {
                        if (item.getType().getName().equals("java.lang.Long") || item.getType().getName().equals("java.lang.Integer")) {
                            where.append(" AND b." + fieldName + "=" + value + " ");
                        } else if (item.getType().getName().equals("java.lang.String")){
                            where.append(" AND b." + fieldName + " LIKE '%" + value + "%' ");
                        }
                    }
                }
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<CourseEntity> findAll(CourseSearchRequest courseSearchRequest) {
        StringBuilder sql = new StringBuilder("Select * From course c ");
        StringBuilder where = new StringBuilder(" where 1 = 1  ");
        queryNormal(courseSearchRequest, where);
        sql.append(where);
        Query query = entityManager.createNativeQuery(sql.toString(),CourseEntity.class);
        return query.getResultList();
    }
}
