package com.lanou3g.study.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class Query extends QueryRunner {
    public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh) throws SQLException {



        T t = super.query(conn, sql, rsh);


        return t;
    }

    @Override
    public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        T t = super.query(conn, sql, rsh,params);
        return t;
    }
}