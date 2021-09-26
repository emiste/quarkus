package org.acme.security;


import org.acme.config.MyAppConfig;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;


/**
 * A Servlet filter class for authorizing requests.
 * The role of this filter class is to set a
 * {@link javax.ws.rs.core.SecurityContext} in the
 * {@link ContainerRequestContext}
 */
@OAuthSecurity
@Provider
@Priority(Priorities.AUTHENTICATION)
public class SecurityContextFilter implements ContainerRequestFilter {

    @Inject
    MyAppConfig config;

    public SecurityContextFilter() {

    }

    public ContainerRequestFilter getRequestFilter() {
        return this;
    }

    public ContainerResponseFilter getResponseFilter() {
        return null;
    }

    @Override
    public void filter(ContainerRequestContext request) {
        String method = request.getMethod();
        if (method == HttpMethod.OPTIONS || !config.isWebserviceSecure())
            return;
        if (!config.isSecurityDisabled().isEmpty() && config.isSecurityDisabled().get()) {
            return;
        }


    }

}