package api.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:api.properties"
})
public interface AuthConfig extends Config {

    String token();
}