package shoppingmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 08/09/2020
 * Time : 12:42 AM
 */
@EnableJpaAuditing
@SpringBootApplication
public class ShoppingMallApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShoppingMallApplication.class, args) ;
    }
}
