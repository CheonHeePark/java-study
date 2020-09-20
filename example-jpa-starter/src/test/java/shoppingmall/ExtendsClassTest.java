package shoppingmall;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import shoppingmall.domain.Address;
import shoppingmall.domain.Member;
import shoppingmall.domain.MemberRepository;
import shoppingmall.domain.item.Book;
import shoppingmall.domain.item.Item;
import shoppingmall.domain.item.ItemRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 14/09/2020
 * Time : 12:40 AM
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ExtendsClassTest {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void bookItemTest() {
        Book book = new Book();
        book.setName("Java_Programming");
        book.setPrice(10000);
        book.setAuthor("Chpark");
        book.setIsbn("IS19129293");

        itemRepository.save(book);

        List<Item> items = itemRepository.findAll();
        Book findBook = (Book)items.get(0);
        Assert.assertSame(book, findBook);
        Assert.assertTrue(findBook instanceof Book);
        Assert.assertEquals(findBook.getName(), book.getName());
        System.out.println("FindBook author: " + findBook.getAuthor());
    }

    @Test
    public void baseTimeEntityTest() {
        Member member = createMember("chpark", "seoul", "olimpic", "01001");
        memberRepository.save(member);

        List<Member> members = memberRepository.findByName("chpark");
        Assert.assertNotNull(members);
        Member findMember = members.get(0);
        LocalDateTime createdTime = findMember.getCreatedDate();
        LocalDateTime modifiedTime = findMember.getLastModifiedDate();
        Assert.assertNotNull(createdTime);
        Assert.assertNotNull(modifiedTime);

        Assert.assertSame(member, findMember);

        System.out.println("이름 : " + findMember.getName());
        System.out.println("생성일: " + createdTime);
        System.out.println("수정일: " + modifiedTime);
    }

    private Member createMember(String name, String city, String street, String zipcode) {
        Member m = new Member();
        m.setName(name);
        /* Address Entity추가로 인해 테스트 방식 변경
        m.setCity(city);
        m.setStreet(street);
        m.setZipcode(zipcode);
        */
        Address address = new Address();
        address.setCity(city);
        address.setStreet(street);
        address.setZipcode(zipcode);
        m.setAddress(address);
        return m;
    }
}
