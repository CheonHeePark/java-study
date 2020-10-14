package shoppingmall.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import shoppingmall.domain.item.Book;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 15/10/2020
 * Time : 12:09 AM
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {
    @Autowired
    private ItemService itemService;

    @Test
    public void 상품_등록_테스트() {
        Book book = createBook("chpark", "1000-1234");
        Long bookId = itemService.saveItem(book);

        Book savedBook = (Book)itemService.findItemById(bookId);

        Assert.assertEquals(book.getAuthor(), savedBook.getAuthor());
    }

    @Test
    public void 상품_전체조회_테스트() {
        Book book1 = createBook("chpark", "1000-1234");
        Book book2 = createBook("jmpark", "2000-2234");
        itemService.saveItem(book1);
        itemService.saveItem(book2);

        Assert.assertEquals(itemService.findItems().size(), 2);
    }

    @Test
    public void 상품_수정_테스트() {
        Book book = createBook("chpark", "1000-1234");
        Long savedBookId = itemService.saveItem(book);
        book.setAuthor("jmpark");
        book.setIsbn("1000-1234");
        Long modifiedBookId = itemService.saveItem(book);
        Assert.assertEquals(savedBookId, modifiedBookId);
    }

    private Book createBook(String author, String isbn) {
        Book book = new Book();
        book.setIsbn(isbn);
        book.setAuthor(author);
        return book;
    }
}
