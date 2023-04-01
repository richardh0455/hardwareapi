package org.example.database.dao;

import org.example.api.model.OrderModel;
import org.example.database.JooqConfiguration;
import org.example.jooq.tables.daos.TbOrderDao;
import org.example.jooq.tables.records.TbOrderRecord;

import static org.example.jooq.Tables.TB_ORDER;
import static org.jooq.impl.DSL.using;

public class OrderDao extends TbOrderDao {

    public OrderDao() {
        super(org.example.database.JooqConfiguration.get());
    }

    public OrderDao(org.jooq.Configuration configuration) {
        super(configuration);
    }

    public Integer createOrder(OrderModel order) {
        TbOrderRecord record = using(JooqConfiguration.get()).newRecord(TB_ORDER)
                .setOrderCustomerId(order.getCustomerId())
                .setOrderStatus(OrderStatus.ORDERED.toString());
        record.insert();
        return record.getOrderId();
    }

    public enum OrderStatus {
        ORDERED,
        IN_PROGRESS,

        COMPLETE,
        CANCELLED
    }

}
