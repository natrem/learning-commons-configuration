package natrem.test.learning_commons_configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;

import natrem.test.learning_commons_configuration.CompositeOutput;

import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.HierarchicalConfiguration.Node;
import org.junit.Before;
import org.junit.Test;

public class CompositeOutputTest {

    private CompositeOutput output;
    private HierarchicalConfiguration configuration;

    private Node concreteA1;
    private Node concreteA2;
    private Node concreteB1;
    private Node concreteB2;
    private Node concreteB3;

    @Before
    public void setUp() throws Exception {
        output = new CompositeOutput();
        configuration = new HierarchicalConfiguration();
        
        // create nodes
        concreteA1 = createNodeConcreteA("concreteA-1", "somewhere");
        concreteA2 = createNodeConcreteA("concreteA-2", "elsewhere");

        concreteB1 = createNodeConcreteB("concreteB-1", "me");
        concreteB2 = createNodeConcreteB("concreteB-2", "you");
        concreteB3 = createNodeConcreteB("concreteB-3", "them");
    }

    private Node createNodeConcreteA(String name, String url) {
        Node concreteAName = new Node("name", name);
        Node concreteAUrl = new Node("url", url);
        Node nodeA = new Node("concreteA");
        nodeA.addChild(concreteAName);
        nodeA.addChild(concreteAUrl);
        return nodeA;
    }

    private Node createNodeConcreteB(String name, String user) {
        Node concreteBName = new Node("name", name);
        Node concreteBUser = new Node("user", user);
        Node nodeA = new Node("concreteB");
        nodeA.addChild(concreteBName);
        nodeA.addChild(concreteBUser);
        return nodeA;
    }

    @Test
    public void should_get_no_property_by_default() throws Exception {
        assertTrue(output.getKeys().isEmpty());
    }

    @Test
    public void should_add_a_concreteOutputA() throws Exception {
        configuration.addNodes(null, Collections.singleton(concreteA1));
        output.configureOutput(configuration);
        assertEquals(1, output.getOutputs().size());
    }
    
    @Test
    public void should_configure_added_outputA() throws Exception {
        configuration.addNodes(null, Collections.singleton(concreteA1));
        output.configureOutput(configuration);
        assertEquals(2, output.getKeys().size());
        assertTrue(output.getKeys().contains("name"));
        assertTrue(output.getKeys().contains("url"));
    }

    @Test
    public void should_add_several_concreteOutputA() throws Exception {
        configuration.addNodes(null, Arrays.asList(concreteA1, concreteA2));
        output.configureOutput(configuration);
        assertEquals(2, output.getOutputs().size());
    }

    @Test
    public void should_add_a_concreteOutputB() throws Exception {
        configuration.addNodes(null, Collections.singleton(concreteB1));
        output.configureOutput(configuration);
        assertEquals(1, output.getOutputs().size());
    }

    @Test
    public void should_configure_added_outputB() throws Exception {
        configuration.addNodes(null, Collections.singleton(concreteB1));
        output.configureOutput(configuration);
        assertEquals(2, output.getKeys().size());
        assertTrue(output.getKeys().contains("name"));
        assertTrue(output.getKeys().contains("user"));
    }

    @Test
    public void should_add_several_concreteOutputB() throws Exception {
        configuration.addNodes(null, Arrays.asList(concreteB1, concreteB2, concreteB3));
        output.configureOutput(configuration);
        assertEquals(3, output.getOutputs().size());
    }

}
