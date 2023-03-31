package org.example.database.dao;

import org.apache.commons.lang3.StringUtils;
import org.example.api.model.ProductModel;
import org.example.database.JooqConfiguration;
import org.example.jooq.tables.daos.TbProductDao;
import org.example.jooq.tables.pojos.TbProduct;
import org.example.jooq.tables.records.TbProductRecord;
import org.jooq.Configuration;

import java.util.List;

import static org.example.jooq.tables.TbProduct.TB_PRODUCT;
import static org.jooq.impl.DSL.using;

public class ProductDao extends TbProductDao {

    public ProductDao() {
        super(JooqConfiguration.get());
    }

    public ProductDao(Configuration configuration) {
        super(configuration);
    }

    public List<TbProduct> fetchAllActive() {
        return fetchByProductStatus(ProductStatus.ACTIVE.toString());
    }

    /**
     * Create a new product
     * @param product
     * @return the Id of the new Product
     */
    public Integer createProduct(ProductModel product) {
         TbProductRecord record = using(JooqConfiguration.get()).newRecord(TB_PRODUCT)
                .setProductName(product.getName())
                .setProductPrice(product.getPrice())
                .setProductStatus(ProductStatus.ACTIVE.toString());
         record.insert();
         return record.getProductId();
    }

    public boolean updateProduct(TbProduct product, ProductModel model) {
        TbProductRecord record = new TbProductRecord(product);
        if(StringUtils.isNotEmpty(model.getName())) {
            record.setProductName(model.getName());
        }
        if(model.getPrice() != null) {
            record.setProductPrice(model.getPrice());
        }
        return using(JooqConfiguration.get()).update(TB_PRODUCT)
                .set(record)
                .where(TB_PRODUCT.PRODUCT_ID.eq(product.getProductId()))
                .execute() > 0;
    }


    public enum ProductStatus {
        ACTIVE,
        INACTIVE
    }
}
