package spring.cloud.stargate.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author chanwook
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ClientTestApp.class})
public class InitConfigTest {

    @Autowired
    ProductClient client;

    @Test
    public void injection() throws Exception {
        assertThat(client, notNullValue());
    }

    @Test
    public void writeConfig() throws Exception {
        // 일단 injection만 되게!
//        final Product p = client.getOne("p001");
//        assertThat(p, notNullValue());
    }
}
