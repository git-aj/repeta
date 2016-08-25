package com.test.dao;

import com.test.model.Shop;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ShopRowMapper implements RowMapper<Shop> {

    @Override
    public Shop mapRow(ResultSet resultSet, int i) throws SQLException {
        Shop result = new Shop();
        return result;
    }
}