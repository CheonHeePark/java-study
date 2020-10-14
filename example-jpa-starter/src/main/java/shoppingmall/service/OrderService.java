package shoppingmall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shoppingmall.domain.*;
import shoppingmall.domain.item.Item;
import shoppingmall.domain.item.ItemRepository;

import java.util.ArrayList;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 15/10/2020
 * Time : 12:19 AM
 */

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Transactional
    // 상품 주문
    public Long order(Long memberId, Long itemId, int count) {
        // 주문할 회원, 상품정보 조회
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Wrong member_id: <" + memberId + ">"));
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Wrong item_id: <" + itemId + ">"));
        // 배송지 정보 설정
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        // 주문상품 추가
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        // 주문
        Order order = Order.createOrder(member, delivery, orderItem);
        orderRepository.save(order);
        return order.getId();
    }

    // 주문 취소
    @Transactional
    public void cancel(Long orderId) {
       Order order = orderRepository.findById(orderId)
               .orElseThrow(() -> new IllegalArgumentException("Wrong orderId: <" + orderId + ">"));
       order.cancelOrder();
    }

    // 주문 조회
    @Transactional
    public Order findById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Wrong orderId: <" + orderId + ">"));
    }
}
