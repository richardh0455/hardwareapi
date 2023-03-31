package org.example.database.dao;

import org.example.database.JooqConfiguration;
import org.example.jooq.tables.daos.TbProductDao;
import org.example.jooq.tables.pojos.TbProduct;
import org.jooq.Configuration;

import java.util.List;

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


    public enum ProductStatus {
        ACTIVE,
        INACTIVE
    }
}
