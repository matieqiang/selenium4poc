FAQ
===
## 1. ElementNotInteractableException: element not interactable
虽然找到元素，但无法click，可能是元素被隐藏了

等待元素可交互： 在尝试与元素交互之前，使用适当的等待策略等待元素变得可交互。这可以通过使用 显式等待WebDriverWai 结合条件等待来实现。
确保元素可见： 在操作元素之前，确保它在页面上可见。可以使用 ExpectedConditions.visibilityOfElementLocated 条件来等待元素可见。
检查元素状态： 在尝试与元素交互之前，检查元素是否处于可交互状态，例如是否被禁用。
切换到正确的框架： 如果元素位于<frame>内部，我们需要先切换到该frame内部才可以进行操作。

## 2. ElementClickInterceptedException: element click intercepted: 
### description

    ElementClickInterceptedException: element click intercepted: Element <use xlink:href="#oop-data-connectors" class="svg-use"></use> is not clickable at point (69, 445). Other element would receive the click: <svg data-v-f4207750="" aria-hidden="true" class="icon">...</svg>

### resolve
see: https://stackoverflow.com/questions/11908249/debugging-element-is-not-clickable-at-point-error
    
    This is caused by following 3 types:
    
    1. The element is not visible to click.
    
    Use Actions or JavascriptExecutor for making it to click.
    
    By Actions:
    
    WebElement element = driver.findElement(By("element_path"));
    
    Actions actions = new Actions(driver);
    
    actions.moveToElement(element).click().perform();
    By JavascriptExecutor:
    
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    
    jse.executeScript("scroll(250, 0)"); // if the element is on top.
    
    jse.executeScript("scroll(0, 250)"); // if the element is on bottom.
    or
    
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    
    jse.executeScript("arguments[0].scrollIntoView()", Webelement);
    Then click on the element.
    
    2. The page is getting refreshed before it is clicking the element.
    
    For this, make the page to wait for few seconds.
    
    3. The element is clickable but there is a spinner/overlay on top of it
    
    The below code will wait until the overlay disppears
    
    By loadingImage = By.id("loading image ID");
    
    WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
    
    wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingImage));
    Then click on the element.

## 3. 查找元素
```html

<svg>
    <use xlink:href='#aaa'></use>
</svg>

```

## 4. org.openqa.selenium.StaleElementReferenceException: stale element reference: stale element not found
## 5. org.openqa.selenium.ElementNotInteractableException: Element <use class="svg-use"> could not be scrolled into view
## 6. Caused by: org.openqa.selenium.SessionNotCreatedException: Could not start a new session. Response code 500. Message: unknown error: unrecognized Microsoft Edge version: Chrome/119.0
