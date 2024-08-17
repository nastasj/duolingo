package api.config;

import org.aeonbits.owner.Config;

public interface ApiConfig extends Config {

    @DefaultValue("https://www.duolingo.com/")
    String baseURI();

    @DefaultValue("1528764897")
    String testUserId();

    @DefaultValue("1531277447")
    String otherTestUserId();
}