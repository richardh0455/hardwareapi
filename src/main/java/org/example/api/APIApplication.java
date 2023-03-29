package org.example.api;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.example.api.config.APIConfiguration;
import org.example.api.health.HealthCheck;

public class APIApplication extends Application<APIConfiguration> {
    public static void main(String[] args) throws Exception {
        new APIApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<APIConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(APIConfiguration configuration, Environment environment) throws Exception {
        environment.healthChecks().register("health", new HealthCheck());


        //TODO:: Implement oAuth2.0 Filter.
        // Can probably do a simple Basic Auth flow but
        // more interesting would be a Password Grant or Authroization Code Grant
        //Dropwizard also allows us to implement user roles so we can limit which
        // endpoint a User has access to.
        /*environment.jersey().register(new AuthDynamicFeature(
                new OAuthCredentialAuthFilter.Builder<AuthUser>()
                        //TODO:: Implement Authenticator/Authorizer
                        //.setAuthenticator(new ExampleOAuthAuthenticator())
                        //.setAuthorizer(new ExampleAuthorizer())
                        .setPrefix("Bearer")
                        .buildAuthFilter()));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        //If you want to use @Auth to inject a custom Principal type into your resource
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(AuthUser.class));
        */

    }
}