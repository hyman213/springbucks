package io.hyman.spring.waiterservice.dao;

import io.hyman.spring.waiterservice.model.OrderState;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description:
 * @author: Hyman
 * @date: 2019/07/28 10:03
 * @version： 1.0.0
 */
public class OrderStateHandler implements TypeHandler<OrderState> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, OrderState state, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, state.getType());
    }

    @Override
    public OrderState getResult(ResultSet resultSet, String s) throws SQLException {
        return OrderState.int2State(Integer.parseInt(s));
    }

    @Override
    public OrderState getResult(ResultSet resultSet, int i) throws SQLException {
        return OrderState.int2State(resultSet.getInt(i));
    }

    @Override
    public OrderState getResult(CallableStatement callableStatement, int i) throws SQLException {
        return OrderState.int2State(callableStatement.getInt(i));
    }
}
