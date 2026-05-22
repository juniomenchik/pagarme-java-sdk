/*
 * PagarmeApiSDKLib
 */
package me.pagar.api.controllers;

import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import me.pagar.api.ApiHelper;
import me.pagar.api.Server;
import me.pagar.api.exceptions.ApiException;
import me.pagar.api.http.request.HttpMethod;
import me.pagar.api.models.HealthResponse;

/**
 * Default implementation of HealthCheckController.
 */
public final class DefaultHealthCheckController extends BaseController implements HealthCheckController {

    public DefaultHealthCheckController(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    @Override
    public HealthResponse getHealth() throws ApiException, IOException {
        ApiCall<HealthResponse, ApiException> call = new ApiCall.Builder<HealthResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/health")
                        .httpMethod(HttpMethod.GET)
                        .withAuth(auth -> auth.add("httpBasic")))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, HealthResponse.class))
                        .nullify404(false)
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();

        return call.execute();
    }
}