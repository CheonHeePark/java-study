package shoppingmall;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shoppingmall.domain.*;

import java.util.List;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 07/09/2020
 * Time : 6:07 AM
 */
@DataJpaTest
@RunWith(SpringRunner.class)
//@SpringBootTest
public class BasicCRUDTest {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    MemberRepository memberRepository;

    private Member member;
    private Order order;

    @Before
    public void init() {
        member = createMember("chpark", "Suwon", "BongYoungLo", "00001");
        order = createOrder(member);
    }

    @Test
    public void saveMemberTest() {
        Assert.assertNotNull(memberRepository);
        Member savedMember = saveMember(member);
        Assert.assertEquals(savedMember.getName(), member.getName());
        System.out.println("Finish, saveMemberTest");
    }

    @Test
    public void findMemberTest() {
        saveMember(member);
        Assert.assertEquals(memberRepository.count(), 1);

        List<Member> members = memberRepository.findByName(member.getName());
        Assert.assertNotNull(members);
        Assert.assertEquals(members.get(0).getCity(), member.getCity());
        System.out.println("Finish, findMemberTest");
    }

    @Test
    public void saveOrderTest() {
        Assert.assertNotNull(orderRepository);
        Member orderer = saveMember(member);
        Order savedOrder = saveOrder(order);
        Assert.assertNotNull(savedOrder);

        Assert.assertEquals(savedOrder.getMember().getName(), orderer.getName());
        System.out.println("Finish, saveOrderTest");
    }

    @Test
    public void findOrderTest() {
        Assert.assertNotNull(order);
        Item item = createItem("macbookpro", 240*10000, 1);
        Assert.assertNotNull(item);
        OrderItem orderItem = createOrderItem(order, item);
        Assert.assertNotNull(orderItem);
        order.addOrderItem(orderItem);
        member.addOrder(order);
        Order savedOrder = orderRepository.save(order);
        Assert.assertNotNull(savedOrder);

        saveMember(member);

        Order findOrder = orderRepository.findById(savedOrder.getId())
                .orElseThrow(null);
        Assert.assertNotNull(findOrder);

        OrderItem findOrderItem = findOrder.getOrderItems().get(0);
        Assert.assertNotNull(findOrderItem);

        Assert.assertEquals(findOrderItem.getItem().getName(), item.getName());
        System.out.println("Finish, findOrderTest");
    }
    private Member createMember(String name, String city, String street, String zipcode) {
        Member m = new Member();
        m.setName(name);
        m.setCity(city);
        m.setStreet(street);
        m.setZipcode(zipcode);
        return m;
    }

    private Item createItem(String name, int price, int quantity) {
        return Item.builder()
                .name(name)
                .price(price)
                .stockQuantity(quantity).build();
    }

    private Order createOrder(Member member) {
        Order order = new Order(member);
        return order;
    }

    private OrderItem createOrderItem(Order order, Item item) {
        return new OrderItem(order, item);
    }

    private Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    private Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

}
