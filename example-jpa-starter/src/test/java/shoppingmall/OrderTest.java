package shoppingmall;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import shoppingmall.domain.*;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 16/09/2020
 * Time : 12:04 AM
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderTest {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private DeliveryRepository deliveryRepository;

    private Delivery delivery;
    private OrderItem orderItem1;
    private OrderItem orderItem2;
    private Order order;

    @Before
    public void setup() {
        order = new Order();
        delivery = new Delivery();
        orderItem1 = new OrderItem();
        orderItem2 = new OrderItem();
    }

    @Test
    public void orderNotCascade() {
        deliveryRepository.save(delivery);
        orderItemRepository.save(orderItem1);
        orderItemRepository.save(orderItem2);
        order.changeDeliveryInfo(delivery);
        order.addOrderItem(orderItem1);
        order.addOrderItem(orderItem2);
        orderRepository.save(order);
        checkRepositoryCount();
    }

    @Test
    public void orderWithCasecade() {
        /* 영속성전이는 엔티티를 영속화할때, 연관된 엔티티도 함께 영속화하는 것일뿐, 연관관계에 직접 관여하지 않는다.
         * 따라서 연관관계 설정은 영속성전이와 상관없이 직접 설정해야 한다.
         */
        order.changeDeliveryInfo(delivery);
        order.addOrderItem(orderItem1);
        order.addOrderItem(orderItem2);
        // EntityManager의 flush시점에 영속성 전이가 일어난다.
        orderRepository.save(order);
        checkRepositoryCount();
    }

    private void checkRepositoryCount() {
        Assert.assertEquals(orderRepository.count(), 1);
        Assert.assertEquals(orderItemRepository.count(), 2);
        Assert.assertEquals(deliveryRepository.count(), 1);
    }
}
