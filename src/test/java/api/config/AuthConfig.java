package api.config;

import org.aeonbits.owner.Config;

@Config.Sources({
})
public interface AuthConfig extends Config {

    String token();
}