package natrem.test.learning_commons_configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.configuration.HierarchicalConfiguration;

public class CompositeOutput implements Output {

    private final List<Output> outputs = new ArrayList<Output>();
    
    public void addOutput(Output output) {
        outputs.add(output);
    }
    
    public List<Output> getOutputs() {
        return outputs;
    }

    public Collection<String> getKeys() {
        List<String> result = new ArrayList<String>();
        for (Output output : outputs) {
            result.addAll(output.getKeys());
        }
        return result;
    }
    
    public void configureOutput(HierarchicalConfiguration configuration) {
        addConcreteOutput1FromConfiguration(configuration);
        addConcreteOutput2FromConfiguration(configuration);
    }

    private void addConcreteOutput1FromConfiguration(
            HierarchicalConfiguration configuration) {
        List<HierarchicalConfiguration> concreteAConfigs = configuration.configurationsAt("concreteA");
        for (HierarchicalConfiguration concreteConfig : concreteAConfigs) {
            ConcreteOutputA output = new ConcreteOutputA();
            output.setConfiguration(concreteConfig);
            addOutput(output);
        }
    }
    
    private void addConcreteOutput2FromConfiguration(
            HierarchicalConfiguration configuration) {
        List<HierarchicalConfiguration> concreteBConfigs = configuration.configurationsAt("concreteB");
        for (HierarchicalConfiguration concreteConfig : concreteBConfigs) {
            ConcreteOutputB output = new ConcreteOutputB();
            output.setConfiguration(concreteConfig);
            addOutput(output);
        }
    }
}
