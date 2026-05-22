# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build Commands

```bash
# Build (skips tests and javadoc for faster builds)
mvn install -Dmaven.test.skip=true -Dmaven.javadoc.skip=true

# Build with tests
mvn install

# Run tests
mvn test

# Clean build artifacts
mvn clean
```

**Requirements:** Java 8+

## Architecture

This is an auto-generated Java SDK for the Pagar.me payment API (version 6.8.17), created by APIMATIC v3.0. The SDK wraps the REST API with a type-safe Java client.

### Core Entry Point

`PagarmeApiSDKClient` is the main client class — a factory that holds controller instances and manages SDK state. Create it via the Builder pattern:

```java
PagarmeApiSDKClient client = new PagarmeApiSDKClient.Builder()
    .basicAuthCredentials(new BasicAuthModel.Builder("username", "password").build())
    .build();
```

### Controller Pattern

The SDK exposes 12 controller domains, each accessible via a getter on the client:
- `getSubscriptionsController()` — Subscription management
- `getOrdersController()` — Order processing
- `getPlansController()` — Pricing plans
- `getInvoicesController()` — Invoice handling
- `getCustomersController()` — Customer data
- `getChargesController()` — Payment charges
- `getRecipientsController()` — Transfer recipients
- `getTokensController()` — Card tokenization
- `getTransactionsController()` — Transaction queries
- `getTransfersController()` — Transfer operations
- `getPayablesController()` — Payable amounts
- `getBalanceOperationsController()` — Balance operations

Each controller interface (e.g., `SubscriptionsController`) has a default implementation (`DefaultSubscriptionsController`) injected with a shared `GlobalConfiguration`.

### Model Classes

~238 model classes in `src/main/java/me/pagar/api/models/` represent request/response data structures. All models follow `Create<Resource>Request` naming for write operations.

### HTTP Layer

- HTTP clients are configured via `HttpClientConfiguration.Builder`
- OkHttp client adapter (`OkClient`) is used under the hood
- Base URL: `https://api.pagar.me/core/v5` (production)

### Authentication

Basic Authentication is the only supported scheme. Credentials are set via `BasicAuthModel` in the client builder.

## Key Files

- `src/main/java/me/pagar/api/PagarmeApiSDKClient.java` — Main client entry point
- `src/main/java/me/pagar/api/controllers/BaseController.java` — Base class for all controllers
- `src/main/java/me/pagar/api/Configuration.java` — SDK configuration interface
- `src/main/java/me/pagar/api/ApiHelper.java` — Utility methods for JSON serialization/deserialization