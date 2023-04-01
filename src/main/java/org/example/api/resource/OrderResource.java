package org.example.api.resource;

import com.codahale.metrics.annotation.Timed;
import org.eclipse.jetty.server.Response;
import org.example.api.model.OrderModel;
import org.example.database.JooqConfiguration;
import org.example.database.dao.OrderDao;
import org.example.database.dao.OrderItemDao;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;

@Path("/order")
public class OrderResource {

    private OrderDao orderDao;
    private OrderItemDao orderItemDao;
    public OrderResource() {
        orderDao = new OrderDao(JooqConfiguration.get());
        orderItemDao = new OrderItemDao(JooqConfiguration.get());
    }

    public OrderResource(OrderDao orderDao, OrderItemDao orderItemDao) {
        this.orderDao = orderDao;
        this.orderItemDao = orderItemDao;
    }

    @POST
    @Timed
    public Integer createOrder(OrderModel orderModel) {
        //TODO:: We need to check that the user calling the API can create an order for
        // the customer specified in the orderModel. I considered using the customer id in the token
        // for this endpoint but the calling user is not always the customer, e.g. a Sales Rep creates an order
        // on behalf of a customer.
        Integer orderId = orderDao.createOrder(orderModel);
        orderModel.setId(orderId);
        orderModel.getOrderItems().forEach(orderItemModel -> {
            try {
                orderItemDao.createOrderItem(orderId, orderItemModel);
            } catch (Exception e) {
                throw new WebApplicationException(e.getMessage(), Response.SC_INTERNAL_SERVER_ERROR);
            }
        });

        return orderId;
    }

    //TODO:: Get Order, Update Order, Delete Order
}
