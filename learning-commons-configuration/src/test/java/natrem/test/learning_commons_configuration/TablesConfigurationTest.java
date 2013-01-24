package natrem.test.learning_commons_configuration;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.junit.Test;

public class TablesConfigurationTest {

    private Configuration loadConfig() throws ConfigurationException {
        Configuration configuration = new XMLConfiguration("tables.xml");
        return configuration;
    }
    
    @Test
    public void should_load_file() throws Exception {
        Object prop = loadConfig().getProperty("tables.table.name");
        assertThat(prop, is(Collection.class));
        if(prop instanceof Collection)
        {
                System.out.println("Number of tables: " + ((Collection<?>) prop).size());
                assertEquals(2, ((Collection<?>)prop).size());
        }

    }
 
    @Test
    public void should_load_table_names() throws Exception {
        Configuration config = loadConfig();
        List<Object> tableNames = config.getList("tables.table.name");
        System.out.println(tableNames.size());
        assertEquals(2, tableNames.size());
    }
    
    @Test
    public void should_load_tables() throws Exception {
        List<Object> tables = loadConfig().getList("tables.table");
        System.out.println(tables.size());
    }
}
