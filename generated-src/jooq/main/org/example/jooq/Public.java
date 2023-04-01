/*
 * This file is generated by jOOQ.
 */
package org.example.jooq;


import java.util.Arrays;
import java.util.List;

import org.example.jooq.tables.TbOrder;
import org.example.jooq.tables.TbOrderItem;
import org.example.jooq.tables.TbProduct;
import org.example.jooq.tables.TbSchema;
import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.tb_order</code>.
     */
    public final TbOrder TB_ORDER = TbOrder.TB_ORDER;

    /**
     * The table <code>public.tb_order_item</code>.
     */
    public final TbOrderItem TB_ORDER_ITEM = TbOrderItem.TB_ORDER_ITEM;

    /**
     * The table <code>public.tb_product</code>.
     */
    public final TbProduct TB_PRODUCT = TbProduct.TB_PRODUCT;

    /**
     * The table <code>public.tb_schema</code>.
     */
    public final TbSchema TB_SCHEMA = TbSchema.TB_SCHEMA;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            TbOrder.TB_ORDER,
            TbOrderItem.TB_ORDER_ITEM,
            TbProduct.TB_PRODUCT,
            TbSchema.TB_SCHEMA
        );
    }
}
