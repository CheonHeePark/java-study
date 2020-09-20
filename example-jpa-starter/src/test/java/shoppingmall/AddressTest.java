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
 * Date : 21/09/2020
 * Time : 12:06 AM
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AddressTest {
    private static final String NAME    = "Chpark";
    private static final String CITY    = "Suwon";
    private static final String STREET  = "Bongyoung-ro";
    private static final String ZIPCODE = "00001";

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private DeliveryRepository deliveryRepository;

    private Address myAddress;

    @Before
    public void setup() {
        myAddress = new Address();
        myAddress.setCity(CITY);
        myAddress.setStreet(STREET);
        myAddress.setZipcode(ZIPCODE);
    }

    @Test
    public void MemberAddressTest() {
        Member member = new Member();
        member.setName(NAME);
        member.setAddress(myAddress);
        Member savedMember = memberRepository.save(member);
        Assert.assertEquals(savedMember.getName(), NAME);
        Assert.assertEquals(savedMember.getAddress().getCity(), CITY);
        Assert.assertEquals(savedMember.getAddress().getStreet(), STREET);
        Assert.assertEquals(savedMember.getAddress().getZipcode(), ZIPCODE);
    }

    @Test
    public void deliveryAddressTest() {
        Delivery delivery = new Delivery();
        delivery.setStatus(DeliveryStatus.READY);
        delivery.setAddress(myAddress);
        Delivery savedDelivery = deliveryRepository.save(delivery);
        Assert.assertEquals(savedDelivery.getStatus(), DeliveryStatus.READY);
        Assert.assertEquals(savedDelivery.getAddress().getCity(), CITY);
        Assert.assertEquals(savedDelivery.getAddress().getStreet(), STREET);
        Assert.assertEquals(savedDelivery.getAddress().getZipcode(), ZIPCODE);
    }
}
