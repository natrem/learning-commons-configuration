package natrem.test.learning_commons_configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.configuration.BaseConfiguration;
import org.apache.commons.configuration.Configuration;

public class ConcreteOutputA implements Output {

    private Configuration configuration = new BaseConfiguration();

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public Collection<String> getKeys() {
        Collection<String> result = new ArrayList<String>();

        for (Iterator<String> it = configuration.getKeys();it.hasNext();) {
            result.add(it.next());
        }
        
        return result;
    }

}
