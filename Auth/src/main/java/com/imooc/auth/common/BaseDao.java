package com.imooc.auth.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by dello on 2016/7/27.
 */
@Repository
public class BaseDao {

    @Autowired
    protected JdbcTemplate jdbcTemplate;
}
