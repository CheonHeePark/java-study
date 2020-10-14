package shoppingmall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shoppingmall.domain.item.Item;
import shoppingmall.domain.item.ItemRepository;

import java.util.List;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 14/10/2020
 * Time : 11:53 PM
 */

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    // 상품 등록 & 수정
    @Transactional
    public Long saveItem(Item item) {
        itemRepository.save(item);
        return item.getId();
    }

    // 상품 목록 조회
    @Transactional
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    // 상품 1개 조회
    @Transactional
    public Item findItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Wrong item_id: <" + id + ">"));
    }
}
