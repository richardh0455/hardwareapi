package org.example.api.resource;

import com.codahale.metrics.annotation.Timed;
import org.example.api.model.ProductModel;
import org.example.database.JooqConfiguration;
import org.example.database.dao.ProductDao;
import org.jooq.Configuration;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;
import java.util.stream.Collectors;

@Path("/product")
public class ProductResource {

    ProductDao productDao;
    public ProductResource() {
        Configuration databaseConnection = JooqConfiguration.get();
        productDao = new ProductDao(databaseConnection);
    }

    public ProductResource(Configuration databaseConnection) {
        productDao = new ProductDao(databaseConnection);
    }

    @GET
    @Timed
    public List<ProductModel> getProducts() {
        return productDao.fetchAllActive().stream()
                .map(ProductModel::new)
                .collect(Collectors.toList());

    }
}
