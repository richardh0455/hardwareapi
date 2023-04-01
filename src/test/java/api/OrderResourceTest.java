package api;

import fakes.FakeProduct;
import org.example.api.model.OrderItemModel;
import org.example.api.model.OrderModel;
import org.example.api.resource.OrderResource;
import org.example.database.JooqConfiguration;
import org.example.database.dao.OrderDao;
import org.example.database.dao.OrderItemDao;
import org.example.database.dao.ProductDao;
import org.example.jooq.tables.pojos.TbOrder;
import org.example.jooq.tables.records.TbOrderRecord;
import org.example.jooq.tables.records.TbProductRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.DatabaseExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(DatabaseExtension.class)
public class OrderResourceTest {

    private static OrderResource orderResource;
    private static OrderDao orderDao;
    private static OrderItemDao orderItemDao;

    private static List<TbOrderRecord> validOrders = new ArrayList<TbOrderRecord>();
    private static List<TbOrderRecord> invalidOrders = new ArrayList<TbOrderRecord>();

    private static boolean testsAreInitialised = false;
    private static final Object initLock = new Object();
    @BeforeEach
    public void setup() {
        orderDao = new OrderDao(JooqConfiguration.get());
        orderItemDao = new OrderItemDao(JooqConfiguration.get());
        orderResource = new OrderResource(orderDao, orderItemDao);
        synchronized (initLock) {
            testsAreInitialised = true;
        }
    }

    @Test
    @DisplayName("Create an order")
    public void createOrder() {
        TbProductRecord productRecord = FakeProduct.anyProduct(FakeProduct.withName("Hammer"), FakeProduct.withRandomPrice(), FakeProduct.withStatus(ProductDao.ProductStatus.ACTIVE));
        TbProductRecord productRecord2 = FakeProduct.anyProduct(FakeProduct.withName("Sickle"), FakeProduct.withRandomPrice(), FakeProduct.withStatus(ProductDao.ProductStatus.ACTIVE));
        OrderModel orderModel = new OrderModel(null, 1);
        OrderItemModel item1 = new OrderItemModel(null, productRecord.getProductId(), 1);
        OrderItemModel item2 = new OrderItemModel(null, productRecord2.getProductId(), 10);
        orderModel.addOrderItems(item1, item2);
        Integer orderId = orderResource.createOrder(orderModel);
        TbOrder order = orderDao.fetchOneByOrderId(orderId);
        assertThat(order).isNotNull();
        validOrders.add(new TbOrderRecord(order));
        assertThat(orderItemDao.fetchByOritOrderId(orderId).size()).isEqualTo(2);
    }
}
