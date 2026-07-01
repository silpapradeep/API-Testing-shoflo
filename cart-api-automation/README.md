# Cart API Automation - FakeStore API

## Framework Choice
This automation suite is built using:

- Java
- Rest Assured
- TestNG
- Maven

## Why This Framework?
- Rest Assured provides simple and readable API automation.
- TestNG supports assertions, grouping, and data-driven testing.
- Maven manages dependencies efficiently.

## Test Coverage

### Positive Test Cases
- GET all carts
- GET cart by ID
- Create cart
- Update cart
- Delete cart
- Login authentication

### Negative Test Cases
- Invalid cart ID
- Invalid payload
- Invalid login credentials

### Schema Validation
- Cart response schema validation using JSON Schema Validator.

### Data Driven Testing
- Same cart creation scenario executed for multiple product IDs:
  - Product ID 1
  - Product ID 5
  - Product ID 10

## Senior Bonus - Contract Testing
Schema validation ensures response contract remains stable.
If API response structure changes, tests fail immediately.

## Extension Plan
Future improvements:
- Parallel execution using TestNG XML
- Allure/Extent reporting
- CI/CD integration using Jenkins or GitHub Actions
- API request/response logging enhancements

## AI Usage
AI assistance was used to:
- Design test scenarios
- Improve negative test coverage
- Implement schema validation
- Accelerate automation development