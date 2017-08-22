/**
 *
 */
package gems.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import com.gemstone.gemfire.cache.GemFireCache;

import gems.model.GemTO;

/**
 * @author David Ruiz C
 *
 */
@EnableGemfireRepositories
public class GemfireConfig {

    @Bean
    Properties gemfireProperties() {
        Properties gemfireProperties = new Properties();
        gemfireProperties.setProperty("name", "DataGemFireApplication");
        gemfireProperties.setProperty("mcast-port", "0");
        gemfireProperties.setProperty("log-level", "config");
        return gemfireProperties;
    }

    @Bean
    CacheFactoryBean gemfireCache() {
        CacheFactoryBean gemfireCache = new CacheFactoryBean();
        gemfireCache.setClose(true);
        gemfireCache.setProperties(gemfireProperties());
        return gemfireCache;
    }

    @Bean
    LocalRegionFactoryBean<String, GemTO> helloRegion(final GemFireCache cache) {
        LocalRegionFactoryBean<String, GemTO> helloRegion = new LocalRegionFactoryBean<>();
        helloRegion.setCache(cache);
        helloRegion.setClose(false);
        helloRegion.setName("gems");
        helloRegion.setPersistent(false);
        return helloRegion;
    }

}
