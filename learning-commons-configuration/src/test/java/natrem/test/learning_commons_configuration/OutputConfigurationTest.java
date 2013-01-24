package natrem.test.learning_commons_configuration;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.junit.Before;
import org.junit.Test;

public class OutputConfigurationTest {

    private HierarchicalConfiguration configuration;
    
    @Before
    public void setUp() throws ConfigurationException {
        configuration = new XMLConfiguration("output-config.xml");
    }
    
    @Test
    public void should_contain_two_concreteOutput1_configurations() throws Exception {
        List<HierarchicalConfiguration> subConfigs = configuration.configurationsAt("outputs.concreteA");
        assertEquals(2, subConfigs.size());
        assertEquals("concreteA-1", subConfigs.get(0).getString("name"));
        assertEquals("concreteA-2", subConfigs.get(1).getString("name"));
    }
    
    @Test
    public void should_contain_three_concreteOutputB_configurations() throws Exception {
        List<HierarchicalConfiguration> concreteBConfigs = configuration.configurationsAt("outputs.concreteB");
        assertEquals(3, concreteBConfigs.size());
        assertEquals("concreteB-1", concreteBConfigs.get(0).getString("name"));
        assertEquals("concreteB-2", concreteBConfigs.get(1).getString("name"));
        assertEquals("concreteB-3", concreteBConfigs.get(2).getString("name"));
    }
}
