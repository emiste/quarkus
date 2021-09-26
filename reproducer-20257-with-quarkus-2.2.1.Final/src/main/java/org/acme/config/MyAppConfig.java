package org.acme.config;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

import java.util.Optional;

@ConfigMapping(prefix = "myapp")
public interface MyAppConfig {

    @WithName("version")
    String version();
    @WithName("security.isdisabled")
    Optional<Boolean> isSecurityDisabled();

    @WithName("webservice.secure")
    boolean isWebserviceSecure();
}
