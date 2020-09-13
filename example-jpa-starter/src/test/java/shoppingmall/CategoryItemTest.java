package shoppingmall;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import shoppingmall.domain.Category;
import shoppingmall.domain.CategoryRepository;
import shoppingmall.domain.item.Book;
import shoppingmall.domain.item.Item;
import shoppingmall.domain.item.ItemRepository;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 11/09/2020
 * Time : 1:38 AM
 */

// 카테고리와 아이템 CRUD TEST 및 다대다 연관관계 테스트
@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryItemTest {
    private enum CategoryNames {
        Books,
        IT_Books,
        Baby_Books
    }
    private enum ItemNams {
        Good_Daddy,
        Effective_Java
    }

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ItemRepository itemRepository;

    private Category categoryBook;
    private Category categoryITBook;
    private Category categoryBabyBook;
    private Item effectiveJava;
    private Item goodDaddy;

    private int categoryCount;


    @Before
    public void init() {
        categoryCount = 0;
        categoryBook = new Category();
        categoryBook.setName(String.valueOf(CategoryNames.Books));
        categoryITBook = new Category();
        categoryITBook.setName(String.valueOf(CategoryNames.IT_Books));
        categoryBabyBook = new Category();
        categoryBabyBook.setName(String.valueOf(CategoryNames.Baby_Books));

        // Item -> Book, Movie, Album 등 세부 클래스로 확장하였고, lombok의 Builder를 제거하고 Setter 패턴으로 임시 변경
        effectiveJava = new Book();
        effectiveJava.setName(String.valueOf(ItemNams.Effective_Java));
        effectiveJava.setPrice(3 * 10000);
        effectiveJava.setStockQuantity(10);
        goodDaddy = new Book();
        goodDaddy.setName(String.valueOf(ItemNams.Good_Daddy));
        goodDaddy.setPrice(20 * 10000);
        goodDaddy.setStockQuantity(3);
    }

    @Test
    public void saveCategoryTest() {
        Category savedCategoryBook = createCategory(categoryBook);
        // 카테고리 1개 추가했으므로, 영속성 컨텍스트에 저장된 카운트 비교
        checkCategoryCount(++categoryCount);
        checkCategoryName(savedCategoryBook, String.valueOf(CategoryNames.Books));

        Category savedCategoryITBook = createCategory(categoryITBook);
        // 카테고리 1개 추가했으므로, 영속성 컨텍스트에 저장된 카운트 비교
        checkCategoryCount(++categoryCount);
        checkCategoryName(savedCategoryITBook, String.valueOf(CategoryNames.IT_Books));

        Category savedCategoryBabyBook = createCategory(categoryBabyBook);
        // 카테고리 1개 추가했으므로, 영속성 컨텍스트에 저장된 카운트 비교
        checkCategoryCount(++categoryCount);
        checkCategoryName(savedCategoryBabyBook, String.valueOf(CategoryNames.Baby_Books));

        categoryBook.addChildCategory(categoryITBook);
        categoryBook.addChildCategory(categoryBabyBook);
        // 카테고리 변경만 했으므로, 영속성 컨텍스트에 저장된 카운트 비교 (DirtyChecking으로 인해 자동으로 업데이트됨)
        checkCategoryCount(categoryCount);

        Assert.assertTrue(savedCategoryBook.getChilds().contains(categoryITBook));
        Assert.assertTrue(savedCategoryBook.getChilds().contains(categoryBabyBook));

        // 하위 카테고리 출력
        printChildCategorys(savedCategoryBook);
    }

    @Test
    public void saveItemTest() {
        Item savedItemEffectiveJava = createItem(effectiveJava);
        checkItemName(savedItemEffectiveJava, String.valueOf(ItemNams.Effective_Java));
        Item savedItemGoodDaddy = createItem(goodDaddy);
        checkItemName(savedItemGoodDaddy, String.valueOf(ItemNams.Good_Daddy));
        checkItemCount(2);
    }

    @Test
    public void categoryAndItemMappingTest() {
        // 카테고리&아이템 과 카테고리_아이템은 부모 자식 관계라 할 수 있다.
        // 따라서 부모를 먼저 생성해준다.

        // 카테고리 생성
        Category savedCategoryBook = createCategory(categoryBook);
        checkCategoryCount(++categoryCount);
        Category savedCategoryITBook = createCategory(categoryITBook);
        checkCategoryCount(++categoryCount);
        Category savedCategoryBabyBook = createCategory(categoryBabyBook);
        checkCategoryCount(++categoryCount);
        // 아이템 생성
        Item savedItemEffectiveJava = createItem(effectiveJava);
        Item savedItemGoodDaddy = createItem(goodDaddy);

        // 연관관계의 주인이 CATEGORY_ID이므로, 카테고리 엔티티에 아이템 엔티티를 추가한다.
        savedCategoryITBook.addItem(savedItemEffectiveJava);
        savedCategoryBabyBook.addItem(savedItemGoodDaddy);

        // 자식 카테고리들을 부모카테고리에 하위카테고리로 추가한다.
        savedCategoryBook.addChildCategory(savedCategoryITBook);
        savedCategoryBook.addChildCategory(savedCategoryBabyBook);
        checkCategoryCount(categoryCount);

        Assert.assertTrue(findItemFromCategory(savedCategoryBook, savedItemGoodDaddy));
        Assert.assertTrue(findItemFromCategory(savedCategoryBook, savedItemEffectiveJava));
    }

    private Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    private void checkCategoryCount(int count) {
        Assert.assertEquals(categoryRepository.count(), count);
    }

    private void checkCategoryName(Category category, String machingName) {
        Assert.assertEquals(category.getName(), machingName);
    }

    private void printChildCategorys(Category parentCategory) {
        for (Category child : parentCategory.getChilds()) {
            System.out.println("부모 카테고리: " + parentCategory.getName() + ", 자식 카테고리: " + child.getName());
        }
    }

    private Item createItem(Item item) {
        return itemRepository.save(item);
    }

    private void checkItemName(Item item, String machingName) {
        Assert.assertEquals(item.getName(), machingName);
    }
    private void checkItemCount(int count) {
        Assert.assertEquals(itemRepository.count(), count);
    }

    private boolean findItemFromCategory(Category category, Item findItem) {
       for (Category child : category.getChilds()) {
           if (!child.getChilds().isEmpty()) {
               findItemFromCategory(child, findItem);
           } else {
               for (Item item : child.getItems()) {
                   System.out.println("찾을 아이템: " + findItem.getName() + ", 현재 아이템: " + item.getName());
                   if (findItem.getName().equals(item.getName())) return true;
               }
           }
       }
       return false;
    }
}
