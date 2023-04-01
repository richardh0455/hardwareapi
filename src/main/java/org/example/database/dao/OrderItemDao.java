package org.example.database.dao;

import org.example.api.model.OrderItemModel;
import org.example.database.JooqConfiguration;
import org.example.jooq.tables.daos.TbOrderItemDao;
import org.example.jooq.tables.pojos.TbProduct;
import org.example.jooq.tables.records.TbOrderItemRecord;

import java.math.BigDecimal;

import static org.example.jooq.Tables.TB_ORDER_ITEM;
import static org.jooq.impl.DSL.using;

public class OrderItemDao extends TbOrderItemDao {
    private ProductDao productDao;
    public OrderItemDao() {
        super(org.example.database.JooqConfiguration.get());
        productDao = new ProductDao();
    }

    public OrderItemDao(org.jooq.Configuration configuration) {
        super(configuration);
        productDao = new ProductDao(configuration);
    }

    public Integer createOrderItem(Integer orderId, OrderItemModel orderItem) throws Exception {
        //We may have discounts/modifiers to the price in the future
        // but for now we'll just use the product price
        TbProduct product = productDao.fetchOneByProductId(orderItem.getProductId());
        if(product == null) {
            throw new Exception("Product for this Order item does not exist");
        }
        if(!ProductDao.ProductStatus.ACTIVE.toString().equals(product.getProductStatus())) {
            throw new Exception("Product is not active/available");
        }
        BigDecimal price = product.getProductPrice();
        TbOrderItemRecord record = using(JooqConfiguration.get()).newRecord(TB_ORDER_ITEM)
                .setOritOrderId(orderId)
                .setOritProductId(orderItem.getProductId())
                .setOritPrice(price)
                .setOritStatus(OrderItemStatus.ORDERED.toString())
                .setOritQuantity(orderItem.getQuantity());
        record.insert();
        return record.getOritId();
    }

    public enum OrderItemStatus {
        ORDERED,
        SHIPPED,
        DELIVERED,
        CANCELLED
    }
}
