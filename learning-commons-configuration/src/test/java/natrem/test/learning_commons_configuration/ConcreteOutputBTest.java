package natrem.test.learning_commons_configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import natrem.test.learning_commons_configuration.ConcreteOutputA;

import org.apache.commons.configuration.BaseConfiguration;
import org.apache.commons.configuration.Configuration;
import org.junit.Before;
import org.junit.Test;

public class ConcreteOutputBTest {

    private Configuration configuration;
    private ConcreteOutputA empty_output = new ConcreteOutputA();
    private ConcreteOutputA configured_output = new ConcreteOutputA();

    @Before
    public void setUp() throws Exception {
        configuration = new BaseConfiguration();
        configuration.addProperty("name", "concreteB");
        configuration.addProperty("user", "me");
        
        configured_output.setConfiguration(configuration);
    }

    @Test
    public void should_get_no_property_by_default() throws Exception {
        assertTrue(empty_output.getKeys().isEmpty());
    }
    
    @Test
    public void should_get_two_properties_when_configured() throws Exception {
        assertEquals(2, configured_output.getKeys().size());
    }

    @Test
    public void should_contains_configured_properties() throws Exception {
        assertTrue(configured_output.getKeys().contains("name"));
        assertTrue(configured_output.getKeys().contains("user"));
    }

}
