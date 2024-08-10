selenium中的wait
===
- see: https://selenium-python.readthedocs.io/waits.html
- see: https://cloud.tencent.com/developer/article/1503339

## 隐式等待
隐式等待是一个全局设置，适用于 Selenium 脚本中的所有元素。如果未找到该元素，它会等待指定的时间，然后引发异常。我们可以为每个会话设置一次等待时间，并且以后无法更改。默认值为0。

我们可以使用以下语句将隐式等待设置为 10 秒。我们应该在初始化WebDriver实例后立即设置隐式等待：

通过隐式等待，我们不需要在测试中显式等待任何内容。



## 显式等待
显式等待是一种更灵活的等待，它允许我们在继续测试执行之前等待满足特定条件。ExpectedConditions类提供了许多可用于检查预期条件的方法
    
    elementToBeClickable()
    invisibilityOf()
    presenceOfElementLocated()
    textToBePresentInElement()
    visibilityOf()

## FluentWait
FluentWait是另一种类型的显式等待，它允许对等待机制进行更细粒度的控制。它使我们能够定义预期条件和轮询机制来检查是否满足特定条件。
我们可以再次调整之前的测试用例并引入流畅的等待。流畅等待基本上是显式等待，因此我们只需调整Wait实例即可。我们指定轮询频率：

```
void givenPage_whenNavigatingWithFluentWait_thenOK() {

    Wait<WebDriver> wait = new FluentWait<>(driver)
    .withTimeout(Duration.ofSeconds(TIMEOUT))
    .pollingEvery(Duration.ofMillis(POLL_FREQUENCY));
  
    final String expected = "About Baeldung";
    driver.navigate().to("https://www.baeldung.com/");

    driver.findElement(LOCATOR_ABOUT).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(LOCATOR_ABOUT_BAELDUNG));

    driver.findElement(LOCATOR_ABOUT_BAELDUNG).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(LOCATOR_ABOUT_HEADER));

    final String actual = driver.findElement(LOCATOR_ABOUT_HEADER).getText();
    assertEquals(expected, actual);
}
```
## 隐式等待与显式等待的差异
隐式等待和显式等待用于等待元素出现在页面上。然而，它们之间也存在一些差异：

    超时：隐式等待为整个测试运行时间设置默认超时，而显式等待为特定条件设置超时。
    条件：隐式等待等待元素出现在页面上，而显式等待则等待特定条件，例如元素存在或元素可单击。
    范围：隐式等待适用于全局，而显式等待适用于本地特定元素。
    异常：当WebDriver在指定超时内找不到元素时，隐式等待会抛出NoSuchElementException，显式等待将抛出TimeoutException 。

当我们想要等待一定时间以使元素出现在页面上时，隐式等待很有用。但是，如果我们需要等待特定条件，则显式等待是更好的选择。

## 最佳实践
在 Selenium 中使用等待时，需要记住一些最佳实践：

始终使用等待：等待元素加载是自动化测试中的关键步骤。
- 使用显式等待而不是隐式等待：如果无法找到元素，隐式等待可能会导致我们的测试花费超过必要的时间而失败。显式且流畅的等待更好，因为它们允许我们在进一步处理之前等待特定条件发生。
- 必要时使用流畅等待：当我们需要重复验证特定条件直到其变为真时，我们应该使用流畅等待，因为它们对等待机制提供了更好的控制。
- 使用合理的等待时间：等待时间太短可能会导致漏报，而等待时间太长可能会不必要地增加测试的总执行时间。
- 使用ExpectedConditions：当使用显式或流畅等待时，必须使用ExpectedConditions类来定义我们要等待的条件。通过这样做，我们可以确保我们的测试等待适当的条件，如果不满足条件，则快速失败

## StaleElementReferenceException
StaleElementReferenceException是当先前定位的元素不再可用时发生的问题。

当我们找到元素后 DOM 发生变化时，例如，当等待元素的指定条件为 true 时，就会发生这种情况。

为了解决StaleElementReferenceException，我们需要在发生此异常时重新定位元素。每次发生SERE (StaleElementReferenceException)时，我们都会捕获异常，重新定位元素并再次重试该步骤。因为我们不能确定重新加载可以解决问题，所以我们需要在几次尝试后停止重试：
```

boolean stale = true;
int retries = 0;
while(stale && retries < 5) {
    try {
        element.click();
        stale = false;
    } catch (StaleElementReferenceException ex) {
        retries++;
    }
}
if (stale) {
    throw new Exception("Element is still stale after 5 attempts");
}
```

由于此解决方案在各处实施时不方便，因此我们可以包装WebElement和WebDriver并在内部处理StaleElementReferenceException。

通过这种方法，我们不需要在测试代码中处理StaleElementReferenceExceptions 。我们必须包装WebDriver才能与包装的WebElement一起使用。WebElement中所有可能抛出StaleElementReferenceException 的方法都可以进行调整。