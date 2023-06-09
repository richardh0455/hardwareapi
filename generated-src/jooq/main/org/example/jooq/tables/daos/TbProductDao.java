/*
 * This file is generated by jOOQ.
 */
package org.example.jooq.tables.daos;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.example.jooq.tables.TbProduct;
import org.example.jooq.tables.records.TbProductRecord;
import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbProductDao extends DAOImpl<TbProductRecord, org.example.jooq.tables.pojos.TbProduct, Integer> {

    /**
     * Create a new TbProductDao without any configuration
     */
    public TbProductDao() {
        super(TbProduct.TB_PRODUCT, org.example.jooq.tables.pojos.TbProduct.class);
    }

    /**
     * Create a new TbProductDao with an attached configuration
     */
    public TbProductDao(Configuration configuration) {
        super(TbProduct.TB_PRODUCT, org.example.jooq.tables.pojos.TbProduct.class, configuration);
    }

    @Override
    public Integer getId(org.example.jooq.tables.pojos.TbProduct object) {
        return object.getProductId();
    }

    /**
     * Fetch records that have <code>product_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.example.jooq.tables.pojos.TbProduct> fetchRangeOfProductId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(TbProduct.TB_PRODUCT.PRODUCT_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>product_id IN (values)</code>
     */
    public List<org.example.jooq.tables.pojos.TbProduct> fetchByProductId(Integer... values) {
        return fetch(TbProduct.TB_PRODUCT.PRODUCT_ID, values);
    }

    /**
     * Fetch a unique record that has <code>product_id = value</code>
     */
    public org.example.jooq.tables.pojos.TbProduct fetchOneByProductId(Integer value) {
        return fetchOne(TbProduct.TB_PRODUCT.PRODUCT_ID, value);
    }

    /**
     * Fetch a unique record that has <code>product_id = value</code>
     */
    public Optional<org.example.jooq.tables.pojos.TbProduct> fetchOptionalByProductId(Integer value) {
        return fetchOptional(TbProduct.TB_PRODUCT.PRODUCT_ID, value);
    }

    /**
     * Fetch records that have <code>product_name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.example.jooq.tables.pojos.TbProduct> fetchRangeOfProductName(String lowerInclusive, String upperInclusive) {
        return fetchRange(TbProduct.TB_PRODUCT.PRODUCT_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>product_name IN (values)</code>
     */
    public List<org.example.jooq.tables.pojos.TbProduct> fetchByProductName(String... values) {
        return fetch(TbProduct.TB_PRODUCT.PRODUCT_NAME, values);
    }

    /**
     * Fetch records that have <code>product_price BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.example.jooq.tables.pojos.TbProduct> fetchRangeOfProductPrice(BigDecimal lowerInclusive, BigDecimal upperInclusive) {
        return fetchRange(TbProduct.TB_PRODUCT.PRODUCT_PRICE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>product_price IN (values)</code>
     */
    public List<org.example.jooq.tables.pojos.TbProduct> fetchByProductPrice(BigDecimal... values) {
        return fetch(TbProduct.TB_PRODUCT.PRODUCT_PRICE, values);
    }

    /**
     * Fetch records that have <code>product_created_at BETWEEN lowerInclusive
     * AND upperInclusive</code>
     */
    public List<org.example.jooq.tables.pojos.TbProduct> fetchRangeOfProductCreatedAt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(TbProduct.TB_PRODUCT.PRODUCT_CREATED_AT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>product_created_at IN (values)</code>
     */
    public List<org.example.jooq.tables.pojos.TbProduct> fetchByProductCreatedAt(LocalDateTime... values) {
        return fetch(TbProduct.TB_PRODUCT.PRODUCT_CREATED_AT, values);
    }

    /**
     * Fetch records that have <code>updated_at BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.example.jooq.tables.pojos.TbProduct> fetchRangeOfUpdatedAt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(TbProduct.TB_PRODUCT.UPDATED_AT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>updated_at IN (values)</code>
     */
    public List<org.example.jooq.tables.pojos.TbProduct> fetchByUpdatedAt(LocalDateTime... values) {
        return fetch(TbProduct.TB_PRODUCT.UPDATED_AT, values);
    }

    /**
     * Fetch records that have <code>product_status BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.example.jooq.tables.pojos.TbProduct> fetchRangeOfProductStatus(String lowerInclusive, String upperInclusive) {
        return fetchRange(TbProduct.TB_PRODUCT.PRODUCT_STATUS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>product_status IN (values)</code>
     */
    public List<org.example.jooq.tables.pojos.TbProduct> fetchByProductStatus(String... values) {
        return fetch(TbProduct.TB_PRODUCT.PRODUCT_STATUS, values);
    }
}
