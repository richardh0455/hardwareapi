package api;

import fakes.FakeProduct;
import org.assertj.core.api.Assertions;
import org.eclipse.jetty.server.Response;
import org.example.api.BasicResponse;
import org.example.api.model.ProductModel;
import org.example.api.resource.ProductResource;
import org.example.database.JooqConfiguration;
import org.example.database.dao.ProductDao;
import org.example.jooq.tables.pojos.TbProduct;
import org.example.jooq.tables.records.TbProductRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.DatabaseExtension;

import javax.ws.rs.WebApplicationException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(DatabaseExtension.class)
public class ProductResourceTest {
    private ProductResource productResource;
    private ProductDao productDao;

    private static boolean testsAreInitialised = false;

    private static List<TbProductRecord> validProducts = new ArrayList<>();
    private static List<TbProductRecord> invalidProducts = new ArrayList<>();

    private static final Object initLock = new Object();

    @BeforeEach
    public void setup() {
        productResource = new ProductResource(JooqConfiguration.get());
        productDao = new ProductDao(JooqConfiguration.get());
        synchronized (initLock) {
            if (!testsAreInitialised) {
                TbProductRecord hammerRecord = FakeProduct.anyProduct(FakeProduct.withName("Hammer"), FakeProduct.withRandomPrice(), FakeProduct.withStatus(ProductDao.ProductStatus.ACTIVE));
                TbProductRecord drillRecord = FakeProduct.anyProduct(FakeProduct.withName("Drill"), FakeProduct.withRandomPrice(), FakeProduct.withStatus(ProductDao.ProductStatus.ACTIVE));
                validProducts.addAll(Arrays.asList(hammerRecord, drillRecord));
                TbProductRecord invalidProductRecord = FakeProduct.anyProduct(FakeProduct.withName("Invalid Product"), FakeProduct.withRandomPrice(), FakeProduct.withStatus(ProductDao.ProductStatus.INACTIVE));
                invalidProducts.addAll(Arrays.asList(invalidProductRecord));
                testsAreInitialised = true;
            }
        }


    }

    @Test
    @DisplayName("Should return all active products")
    public void getAllActiveProducts() {
        List<ProductModel> activeProducts = productResource.getProducts();
        assertThat(activeProducts.size()).isEqualTo(validProducts.size());
        for(TbProductRecord validProduct : validProducts) {
            Optional<ProductModel> productOptional = activeProducts.stream().filter(productModel -> productModel.getId().equals(validProduct.getProductId())).findAny();
            assertThat(productOptional).isPresent();
            ProductModel comparisonProduct = productOptional.get();
            // All fields are populated
            assertThat(comparisonProduct.getName()).isEqualTo(validProduct.getProductName());
            assertThat(comparisonProduct.getPrice()).isEqualTo(validProduct.getProductPrice());
        }
    }

    @Test
    @DisplayName("Create a new Product")
    public void createProduct() {
        ProductModel product = productResource.createProduct(new ProductModel(null, "New Product", new BigDecimal("100.0")));
        assertThat(product.getId()).isNotNull();
        //The database is shared across tests, ensure validAssets is up to date
        validProducts.add(new TbProductRecord(productDao.fetchOneByProductId(product.getId())));
    }

    @Test
    @DisplayName("Update a Product")
    public void updateProduct() {
        BigDecimal updatedPrice = new BigDecimal("200.0");
        TbProductRecord product = validProducts.get(0);
        ProductModel updatedProduct = new ProductModel(product.getProductId(), "Updated Product", updatedPrice);
        ProductModel updated = productResource.updateProduct(product.getProductId(), updatedProduct);

        assertThat(updated.getPrice()).isEqualByComparingTo(updatedPrice);
        //The database is shared across tests, ensure validAssets is up to date
        validProducts.set(0, new TbProductRecord(productDao.fetchOneByProductId(product.getProductId())));
    }

    @Test
    @DisplayName("Try Update a Product with null fields")
    public void updateProductWithNullFields() {
        TbProductRecord product = validProducts.get(0);
        ProductModel updatedProduct = new ProductModel(product.getProductId(), null, null);
        ProductModel updated = productResource.updateProduct(product.getProductId(), updatedProduct);
        assertThat(updated.getName()).isEqualTo(product.getProductName());
        assertThat(updated.getPrice()).isEqualTo(product.getProductPrice());
    }


    @Test
    @DisplayName("Update a Product that does not exist")
    public void testGetConfigurationVersionThatDoesNotExist() {
        Assertions.assertThatThrownBy(() -> productResource.updateProduct(0, new ProductModel(0, "Update Product", new BigDecimal("100.0"))))
                .isInstanceOf(WebApplicationException.class)
                .hasMessage("Product Not found");
    }

    @Test
    @DisplayName("Delete a Product")
    public void deleteProduct() {
        TbProductRecord product = validProducts.get(0);
        BasicResponse response = productResource.deleteProduct(product.getProductId());
        assertThat(response.getCode()).isEqualTo(Response.SC_OK);
        TbProduct updatedProduct = productDao.fetchOneByProductId(product.getProductId());
        assertThat(updatedProduct.getProductStatus()).isEqualTo(ProductDao.ProductStatus.INACTIVE.toString());
        //The database is shared across tests, ensure validAssets is up to date
        validProducts.remove(0);
        invalidProducts.add(product);
    }

}
