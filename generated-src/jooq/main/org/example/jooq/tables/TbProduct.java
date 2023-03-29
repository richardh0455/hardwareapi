/*
 * This file is generated by jOOQ.
 */
package org.example.jooq.tables;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

import org.example.jooq.Keys;
import org.example.jooq.Public;
import org.example.jooq.tables.records.TbProductRecord;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function5;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbProduct extends TableImpl<TbProductRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.tb_product</code>
     */
    public static final TbProduct TB_PRODUCT = new TbProduct();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TbProductRecord> getRecordType() {
        return TbProductRecord.class;
    }

    /**
     * The column <code>public.tb_product.product_id</code>.
     */
    public final TableField<TbProductRecord, Integer> PRODUCT_ID = createField(DSL.name("product_id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.tb_product.product_name</code>.
     */
    public final TableField<TbProductRecord, String> PRODUCT_NAME = createField(DSL.name("product_name"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.tb_product.product_price</code>.
     */
    public final TableField<TbProductRecord, BigDecimal> PRODUCT_PRICE = createField(DSL.name("product_price"), SQLDataType.NUMERIC(10, 2).nullable(false), this, "");

    /**
     * The column <code>public.tb_product.product_created_at</code>.
     */
    public final TableField<TbProductRecord, LocalDateTime> PRODUCT_CREATED_AT = createField(DSL.name("product_created_at"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.tb_product.updated_at</code>.
     */
    public final TableField<TbProductRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    private TbProduct(Name alias, Table<TbProductRecord> aliased) {
        this(alias, aliased, null);
    }

    private TbProduct(Name alias, Table<TbProductRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.tb_product</code> table reference
     */
    public TbProduct(String alias) {
        this(DSL.name(alias), TB_PRODUCT);
    }

    /**
     * Create an aliased <code>public.tb_product</code> table reference
     */
    public TbProduct(Name alias) {
        this(alias, TB_PRODUCT);
    }

    /**
     * Create a <code>public.tb_product</code> table reference
     */
    public TbProduct() {
        this(DSL.name("tb_product"), null);
    }

    public <O extends Record> TbProduct(Table<O> child, ForeignKey<O, TbProductRecord> key) {
        super(child, key, TB_PRODUCT);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<TbProductRecord, Integer> getIdentity() {
        return (Identity<TbProductRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<TbProductRecord> getPrimaryKey() {
        return Keys.TB_PRODUCT_PKEY;
    }

    @Override
    public TbProduct as(String alias) {
        return new TbProduct(DSL.name(alias), this);
    }

    @Override
    public TbProduct as(Name alias) {
        return new TbProduct(alias, this);
    }

    @Override
    public TbProduct as(Table<?> alias) {
        return new TbProduct(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public TbProduct rename(String name) {
        return new TbProduct(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TbProduct rename(Name name) {
        return new TbProduct(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public TbProduct rename(Table<?> name) {
        return new TbProduct(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, BigDecimal, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function5<? super Integer, ? super String, ? super BigDecimal, ? super LocalDateTime, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function5<? super Integer, ? super String, ? super BigDecimal, ? super LocalDateTime, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
