/*
 * This file is generated by jOOQ.
 */
package org.example.jooq.tables.records;


import java.time.LocalDateTime;

import org.example.jooq.tables.TbOrder;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbOrderRecord extends UpdatableRecordImpl<TbOrderRecord> implements Record5<Integer, Integer, LocalDateTime, String, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.tb_order.order_id</code>.
     */
    public TbOrderRecord setOrderId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.tb_order.order_id</code>.
     */
    public Integer getOrderId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.tb_order.order_customer_id</code>.
     */
    public TbOrderRecord setOrderCustomerId(Integer value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.tb_order.order_customer_id</code>.
     */
    public Integer getOrderCustomerId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.tb_order.order_created_at</code>.
     */
    public TbOrderRecord setOrderCreatedAt(LocalDateTime value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.tb_order.order_created_at</code>.
     */
    public LocalDateTime getOrderCreatedAt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>public.tb_order.order_status</code>.
     */
    public TbOrderRecord setOrderStatus(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.tb_order.order_status</code>.
     */
    public String getOrderStatus() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.tb_order.updated_at</code>.
     */
    public TbOrderRecord setUpdatedAt(LocalDateTime value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.tb_order.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, Integer, LocalDateTime, String, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, Integer, LocalDateTime, String, LocalDateTime> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return TbOrder.TB_ORDER.ORDER_ID;
    }

    @Override
    public Field<Integer> field2() {
        return TbOrder.TB_ORDER.ORDER_CUSTOMER_ID;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return TbOrder.TB_ORDER.ORDER_CREATED_AT;
    }

    @Override
    public Field<String> field4() {
        return TbOrder.TB_ORDER.ORDER_STATUS;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return TbOrder.TB_ORDER.UPDATED_AT;
    }

    @Override
    public Integer component1() {
        return getOrderId();
    }

    @Override
    public Integer component2() {
        return getOrderCustomerId();
    }

    @Override
    public LocalDateTime component3() {
        return getOrderCreatedAt();
    }

    @Override
    public String component4() {
        return getOrderStatus();
    }

    @Override
    public LocalDateTime component5() {
        return getUpdatedAt();
    }

    @Override
    public Integer value1() {
        return getOrderId();
    }

    @Override
    public Integer value2() {
        return getOrderCustomerId();
    }

    @Override
    public LocalDateTime value3() {
        return getOrderCreatedAt();
    }

    @Override
    public String value4() {
        return getOrderStatus();
    }

    @Override
    public LocalDateTime value5() {
        return getUpdatedAt();
    }

    @Override
    public TbOrderRecord value1(Integer value) {
        setOrderId(value);
        return this;
    }

    @Override
    public TbOrderRecord value2(Integer value) {
        setOrderCustomerId(value);
        return this;
    }

    @Override
    public TbOrderRecord value3(LocalDateTime value) {
        setOrderCreatedAt(value);
        return this;
    }

    @Override
    public TbOrderRecord value4(String value) {
        setOrderStatus(value);
        return this;
    }

    @Override
    public TbOrderRecord value5(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public TbOrderRecord values(Integer value1, Integer value2, LocalDateTime value3, String value4, LocalDateTime value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TbOrderRecord
     */
    public TbOrderRecord() {
        super(TbOrder.TB_ORDER);
    }

    /**
     * Create a detached, initialised TbOrderRecord
     */
    public TbOrderRecord(Integer orderId, Integer orderCustomerId, LocalDateTime orderCreatedAt, String orderStatus, LocalDateTime updatedAt) {
        super(TbOrder.TB_ORDER);

        setOrderId(orderId);
        setOrderCustomerId(orderCustomerId);
        setOrderCreatedAt(orderCreatedAt);
        setOrderStatus(orderStatus);
        setUpdatedAt(updatedAt);
    }

    /**
     * Create a detached, initialised TbOrderRecord
     */
    public TbOrderRecord(org.example.jooq.tables.pojos.TbOrder value) {
        super(TbOrder.TB_ORDER);

        if (value != null) {
            setOrderId(value.getOrderId());
            setOrderCustomerId(value.getOrderCustomerId());
            setOrderCreatedAt(value.getOrderCreatedAt());
            setOrderStatus(value.getOrderStatus());
            setUpdatedAt(value.getUpdatedAt());
        }
    }
}
