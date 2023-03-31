package fakes;

import org.example.database.JooqConfiguration;
import org.example.database.dao.ProductDao;
import org.example.jooq.tables.records.TbProductRecord;
import org.jetbrains.annotations.NotNull;
import org.testcontainers.shaded.org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.util.function.Consumer;

import static org.example.jooq.tables.TbProduct.TB_PRODUCT;
import static org.jooq.impl.DSL.using;

public class FakeProduct {

    @SafeVarargs
    public static TbProductRecord anyProduct(@NotNull Consumer<TbProductRecord>... modifiers) {
        TbProductRecord record = using(JooqConfiguration.get()).newRecord(TB_PRODUCT);
        for (Consumer<TbProductRecord> modifier : modifiers) {
            modifier.accept(record);
        }
        record.insert();
        return record;
    }

    public static Consumer<TbProductRecord> withName(String productName) {
        return record -> record.setProductName(productName);
    }

    public static Consumer<TbProductRecord> withRandomName() {
        return record -> record.setProductName(RandomStringUtils.random(7));
    }

    public static Consumer<TbProductRecord> withPrice(BigDecimal price) {
        return record -> record.setProductPrice(price);
    }

    public static Consumer<TbProductRecord> withRandomPrice() {
        double min = 0.1;
        double max = 100.0;
        double diff = max - min;
        double randomValue = min + Math.random( ) * diff;
        double rounded = Math.floor(randomValue * 10);
        double randomMoney = rounded/10;
        return record -> record.setProductPrice(new BigDecimal(randomMoney));
    }

    public static Consumer<TbProductRecord> withStatus (ProductDao.ProductStatus productStatus) {
        return record -> record.setProductStatus(productStatus.toString());
    }
}
