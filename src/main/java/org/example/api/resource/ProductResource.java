package org.example.api.resource;

import com.codahale.metrics.annotation.Timed;
import org.eclipse.jetty.server.Response;
import org.example.api.model.ProductModel;
import org.example.database.JooqConfiguration;
import org.example.database.dao.ProductDao;
import org.example.jooq.tables.pojos.TbProduct;
import org.jooq.Configuration;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
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

    @POST
    @Timed
    @RolesAllowed("ADMIN")
    public ProductModel createProduct(ProductModel productModel) {
        Integer id = productDao.createProduct(productModel);
        productModel.setId(id);
        return productModel;
    }
    @POST
    @Timed
    @RolesAllowed("ADMIN")
    @Path("/{id}")
    public ProductModel updateProduct(@PathParam("id") Integer id, ProductModel productModel) {
        TbProduct product = productDao.fetchOneByProductId(id);
        if (product == null) {
            throw new WebApplicationException("Product Not found", Response.SC_NOT_FOUND);
        }
        boolean success = productDao.updateProduct(product, productModel);
        if (!success) {
            throw new WebApplicationException("Product Update failed", Response.SC_INTERNAL_SERVER_ERROR);
        }
        product = productDao.fetchOneByProductId(id);
        return new ProductModel(product);
    }

}
