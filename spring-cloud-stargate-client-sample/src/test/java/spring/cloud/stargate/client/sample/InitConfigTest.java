package spring.cloud.stargate.client.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.cloud.stargate.client.sample.product.Product;
import spring.cloud.stargate.client.sample.product.ProductClient;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author chanwook
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ClientSampleApp.class})
public class InitConfigTest {

    @Autowired
    ProductClient client;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void injection() throws Exception {
        assertThat(client, notNullValue());
        assertThat(applicationContext.getBean("productClient"), notNullValue());
    }

    @Test
    public void writeConfig() throws Exception {
        // 일단 injection만 되게!
        final Product p = client.getOne("p001");
        assertThat(p, notNullValue());
    }
}
