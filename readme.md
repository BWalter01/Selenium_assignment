## Test Suite Description

### Setup

- Initializes a ChromeDriver with specific window size options.
- Maximizes the browser window.

### TestSelenium

1. **Main Page Verification**
    - Instantiates the `MainPage` class.
    - Verifies that the footer text contains "LEGO".

2. **Login**
    - Navigates to the login page.
    - Performs login operation.

3. **Post Login Verification**
    - Waits for the page to load after login.
    - Verifies that the page title contains "Kockashop".

4. **Search**
    - Performs a search operation with the keyword "Csillagromboló".
    - Verifies that the search results contain "Találatok" and "Csillagromboló".

5. **Navigation**
    - Navigates back to the main page.

6. **Cart Page Verification**
    - Navigates to the cart page.
    - Verifies that the body text contains "kosár".
    - Navigates back to the main page.

7. **Wish List Page Verification**
    - Navigates to the wish list page.
    - Verifies that the body text contains "Kedvenceim".
    - Navigates back to the main page.

8. **New Products Page Verification**
    - Navigates to the new products page.
    - Verifies that the body text contains "Újdonságok".
    - Navigates back to the main page.

9. **Hover Test**
    - Verifies that the hover on element is displayed.

10. **Dropdown Test**
    - Verifies that the dropdown reads "Rendeléseim".

11. **Logout**
    - Performs logout operation.

### Teardown

- Closes the browser and quits the driver.