package api;

import fakes.FakeProduct;
import org.example.api.model.ProductModel;
import org.example.api.resource.ProductResource;
import org.example.database.JooqConfiguration;
import org.example.database.dao.ProductDao;
import org.example.jooq.tables.records.TbProductRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.DatabaseExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(DatabaseExtension.class)
public class ProductResourceTest {
    private ProductResource productResource;

    private static boolean testsAreInitialised = false;

    private List<TbProductRecord> validProducts = new ArrayList<>();
    private List<TbProductRecord> invalidProducts = new ArrayList<>();

    @BeforeEach
    public void setup() {
        if(!testsAreInitialised) {
            testsAreInitialised = true;
            productResource = new ProductResource(JooqConfiguration.get());

            TbProductRecord hammerRecord = FakeProduct.anyProduct(FakeProduct.withName("Hammer"), FakeProduct.withRandomPrice(), FakeProduct.withStatus(ProductDao.ProductStatus.ACTIVE));
            TbProductRecord drillRecord = FakeProduct.anyProduct(FakeProduct.withName("Drill"), FakeProduct.withRandomPrice(), FakeProduct.withStatus(ProductDao.ProductStatus.ACTIVE));
            validProducts.addAll(Arrays.asList(hammerRecord, drillRecord));

            TbProductRecord invalidProductRecord = FakeProduct.anyProduct(FakeProduct.withName("Invalid Product"), FakeProduct.withRandomPrice(), FakeProduct.withStatus(ProductDao.ProductStatus.INACTIVE));
            invalidProducts.addAll(Arrays.asList(invalidProductRecord));
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


}
