/*
 * PagarmeApiSDKLib
 */
package me.pagar.api.controllers;

import me.pagar.api.exceptions.ApiException;
import me.pagar.api.models.HealthResponse;
import java.io.IOException;

/**
 * Controller interface for health check operations.
 */
public interface HealthCheckController {

    /**
     * Calls the /health endpoint on the mock server to verify connectivity.
     * @return Health check response
     * @throws ApiException If error response is received from server
     * @throws IOException If a network problem occurs
     */
    HealthResponse getHealth() throws ApiException, IOException;
}