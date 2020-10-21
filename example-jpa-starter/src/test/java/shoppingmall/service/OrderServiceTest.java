package shoppingmall.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import shoppingmall.domain.*;
import shoppingmall.domain.item.Book;
import shoppingmall.exception.NotEnoughStockException;

import java.util.List;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 15/10/2020
 * Time : 1:15 AM
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private ItemService itemService;

    @Test
    public void 주문_등록하기_테스트() {
        Address address = createAddress("Suwon", "AAA-30번길", "00123");
        Member member = createMember("chpark", address);
        Book book = createBook("Uncle-bob", "0000-1234", "Clean-Code", 20000, 100);

        int buyCount = 2;
        Long savedOrderId = orderService.order(member.getId(), book.getId(), buyCount);
        Order savedOrder = orderService.findById(savedOrderId);

        Assert.assertEquals(savedOrder.getMember().getName(), member.getName());
        Assert.assertEquals(savedOrder.getDelivery().getAddress().getStreet(), address.getStreet());
        Assert.assertEquals(savedOrder.getOrderItems().get(0).getItem().getStockQuantity(), 100 - buyCount);
    }

    @Test
    public void 주문_검색하기_테스트() {
        Address address = createAddress("Suwon", "AAA-30번길", "00123");
        Member member = createMember("chpark", address);
        Book book = createBook("Uncle-bob", "0000-1234", "Clean-Code", 20000, 100);

        int buyCount = 2;
        Long savedOrderId = orderService.order(member.getId(), book.getId(), buyCount);
        Order savedOrder = orderService.findById(savedOrderId);
        Assert.assertEquals(savedOrder.getMember().getName(), member.getName());

        OrderSearch orderSearch = new OrderSearch();
        // 정상 조건이므로 검색되야 한다.
        orderSearch.setMemberName("park");
        orderSearch.setOrderStatus(OrderStatus.ORDER);
        List<Order> searchResult = orderService.search(orderSearch);
        Assert.assertTrue(searchResult.size() > 0);
        Assert.assertEquals(searchResult.get(0).getMember().getName(), member.getName());

        // 주문되지 않은 경우이므로 검색되지 않아야 한다.
        orderSearch.setOrderStatus(OrderStatus.CANCEL);
        searchResult = orderService.search(orderSearch);
        Assert.assertTrue(searchResult.size() == 0);

        // 없는 회원이므로 검색되지 않아야 한다.
        orderSearch.setOrderStatus(OrderStatus.ORDER);
        orderSearch.setMemberName("pars");
        searchResult = orderService.search(orderSearch);
        Assert.assertTrue(searchResult.size() == 0);
    }

    @Test(expected = NotEnoughStockException.class)
    public void 재고_수량초과_테스트() {
        Address address = createAddress("Suwon", "AAA-30번길", "00123");
        Member member = createMember("chpark", address);
        Book book = createBook("Uncle-bob", "0000-1234", "Clean-Code", 20000, 100);

        int buyCount = 101;
        Long savedOrderId = orderService.order(member.getId(), book.getId(), buyCount);
        Order savedOrder = orderService.findById(savedOrderId);
        Assert.assertEquals(savedOrder.getMember().getName(), member.getName());

        Assert.fail("재고가 100개인데 101개 주문했으므로 실패해야 한다. ");
    }

    @Test
    public void 주문_취소_테스트() {
        Address address = createAddress("Suwon", "AAA-30번길", "00123");
        Member member = createMember("chpark", address);
        Book book = createBook("Uncle-bob", "0000-1234", "Clean-Code", 20000, 100);

        int buyCount = 10;
        Long savedOrderId = orderService.order(member.getId(), book.getId(), buyCount);
        Order savedOrder = orderService.findById(savedOrderId);
        Assert.assertEquals(savedOrder.getMember().getName(), member.getName());

        // 10개 주문했으므로 재고는 100-10 = 90이 되야한다.
        Assert.assertEquals(itemService.findItemById(book.getId()).getStockQuantity(), 90);

        // 주문 취소 이벤트
        orderService.cancel(savedOrder.getId());

        Order findOrder = orderService.findById(savedOrder.getId());
        // 주문이 취소되었으므로 주문상태가 취소로 변경되야 한다.
        Assert.assertEquals(findOrder.getStatus(), OrderStatus.CANCEL);
        // 주문이 취소되었으므로 재고가 다시 90 + 10 = 100이 되야한다.
        Assert.assertEquals(itemService.findItemById(book.getId()).getStockQuantity(), 100);
    }

    private Address createAddress(String city, String street, String zipcode) {
        Address address = new Address();
        address.setCity(city);
        address.setStreet(street);
        address.setZipcode(zipcode);
        return address;
    }

    private Member createMember(String memberName, Address address) {
        Member member = new Member();
        member.setName(memberName);
        member.setAddress(address);
        memberService.join(member);
        return member;
    }

    private Book createBook(String author, String isbn, String name, int price, int stock) {
        Book book = new Book();
        book.setIsbn(isbn);
        book.setAuthor(author);
        book.setName(name);
        book.setPrice(price);
        book.setStockQuantity(stock);
        itemService.saveItem(book);
        return book;
    }
}
