/*
 * This file is generated by jOOQ.
 */
package org.example.jooq.tables.daos;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.example.jooq.tables.TbOrderItem;
import org.example.jooq.tables.records.TbOrderItemRecord;
import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbOrderItemDao extends DAOImpl<TbOrderItemRecord, org.example.jooq.tables.pojos.TbOrderItem, Integer> {

    /**
     * Create a new TbOrderItemDao without any configuration
     */
    public TbOrderItemDao() {
        super(TbOrderItem.TB_ORDER_ITEM, org.example.jooq.tables.pojos.TbOrderItem.class);
    }

    /**
     * Create a new TbOrderItemDao with an attached configuration
     */
    public TbOrderItemDao(Configuration configuration) {
        super(TbOrderItem.TB_ORDER_ITEM, org.example.jooq.tables.pojos.TbOrderItem.class, configuration);
    }

    @Override
    public Integer getId(org.example.jooq.tables.pojos.TbOrderItem object) {
        return object.getOritId();
    }

    /**
     * Fetch records that have <code>orit_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.example.jooq.tables.pojos.TbOrderItem> fetchRangeOfOritId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(TbOrderItem.TB_ORDER_ITEM.ORIT_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>orit_id IN (values)</code>
     */
    public List<org.example.jooq.tables.pojos.TbOrderItem> fetchByOritId(Integer... values) {
        return fetch(TbOrderItem.TB_ORDER_ITEM.ORIT_ID, values);
    }

    /**
     * Fetch a unique record that has <code>orit_id = value</code>
     */
    public org.example.jooq.tables.pojos.TbOrderItem fetchOneByOritId(Integer value) {
        return fetchOne(TbOrderItem.TB_ORDER_ITEM.ORIT_ID, value);
    }

    /**
     * Fetch a unique record that has <code>orit_id = value</code>
     */
    public Optional<org.example.jooq.tables.pojos.TbOrderItem> fetchOptionalByOritId(Integer value) {
        return fetchOptional(TbOrderItem.TB_ORDER_ITEM.ORIT_ID, value);
    }

    /**
     * Fetch records that have <code>orit_order_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.example.jooq.tables.pojos.TbOrderItem> fetchRangeOfOritOrderId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(TbOrderItem.TB_ORDER_ITEM.ORIT_ORDER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>orit_order_id IN (values)</code>
     */
    public List<org.example.jooq.tables.pojos.TbOrderItem> fetchByOritOrderId(Integer... values) {
        return fetch(TbOrderItem.TB_ORDER_ITEM.ORIT_ORDER_ID, values);
    }

    /**
     * Fetch records that have <code>orit_product_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.example.jooq.tables.pojos.TbOrderItem> fetchRangeOfOritProductId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(TbOrderItem.TB_ORDER_ITEM.ORIT_PRODUCT_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>orit_product_id IN (values)</code>
     */
    public List<org.example.jooq.tables.pojos.TbOrderItem> fetchByOritProductId(Integer... values) {
        return fetch(TbOrderItem.TB_ORDER_ITEM.ORIT_PRODUCT_ID, values);
    }

    /**
     * Fetch records that have <code>orit_quantity BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.example.jooq.tables.pojos.TbOrderItem> fetchRangeOfOritQuantity(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(TbOrderItem.TB_ORDER_ITEM.ORIT_QUANTITY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>orit_quantity IN (values)</code>
     */
    public List<org.example.jooq.tables.pojos.TbOrderItem> fetchByOritQuantity(Integer... values) {
        return fetch(TbOrderItem.TB_ORDER_ITEM.ORIT_QUANTITY, values);
    }

    /**
     * Fetch records that have <code>orit_price BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.example.jooq.tables.pojos.TbOrderItem> fetchRangeOfOritPrice(BigDecimal lowerInclusive, BigDecimal upperInclusive) {
        return fetchRange(TbOrderItem.TB_ORDER_ITEM.ORIT_PRICE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>orit_price IN (values)</code>
     */
    public List<org.example.jooq.tables.pojos.TbOrderItem> fetchByOritPrice(BigDecimal... values) {
        return fetch(TbOrderItem.TB_ORDER_ITEM.ORIT_PRICE, values);
    }

    /**
     * Fetch records that have <code>orit_status BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.example.jooq.tables.pojos.TbOrderItem> fetchRangeOfOritStatus(String lowerInclusive, String upperInclusive) {
        return fetchRange(TbOrderItem.TB_ORDER_ITEM.ORIT_STATUS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>orit_status IN (values)</code>
     */
    public List<org.example.jooq.tables.pojos.TbOrderItem> fetchByOritStatus(String... values) {
        return fetch(TbOrderItem.TB_ORDER_ITEM.ORIT_STATUS, values);
    }

    /**
     * Fetch records that have <code>orit_created_at BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.example.jooq.tables.pojos.TbOrderItem> fetchRangeOfOritCreatedAt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(TbOrderItem.TB_ORDER_ITEM.ORIT_CREATED_AT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>orit_created_at IN (values)</code>
     */
    public List<org.example.jooq.tables.pojos.TbOrderItem> fetchByOritCreatedAt(LocalDateTime... values) {
        return fetch(TbOrderItem.TB_ORDER_ITEM.ORIT_CREATED_AT, values);
    }

    /**
     * Fetch records that have <code>updated_at BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.example.jooq.tables.pojos.TbOrderItem> fetchRangeOfUpdatedAt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(TbOrderItem.TB_ORDER_ITEM.UPDATED_AT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>updated_at IN (values)</code>
     */
    public List<org.example.jooq.tables.pojos.TbOrderItem> fetchByUpdatedAt(LocalDateTime... values) {
        return fetch(TbOrderItem.TB_ORDER_ITEM.UPDATED_AT, values);
    }
}
