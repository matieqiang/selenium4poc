selenium中的Actions类
===
- see: https://testsigma.com/blog/action-class-in-selenium/
- see: https://www.browserstack.com/guide/action-class-in-selenium

要测试应用程序，需要对其执行许多用户操作。要在 Web 应用程序上执行任何操作，例如双击、选择下拉框等，需要 actions 类。本文讨论如何处理Selenium中的Actions类。

## Selenium 中的 Action 类是什么？
Actions 类是 Selenium 提供的用于处理键盘和鼠标事件的功能。
在Selenium WebDriver中，处理这些事件包括在 Selenium 中拖放、使用 control 键单击多个元素等操作。这些操作是使用高级用户交互 API 执行的。它主要由执行这些操作时所需的操作组成。使用以下语法定义和调用操作类：

    Actions action = new Actions(driver);
    action.moveToElement(element).click().perform();

## Actions类的方法
Action 类主要用于鼠标和键盘操作。为了执行此类操作，Selenium提供了各种方法。

Selenium 中的鼠标操作：

    doubleClick()：双击元素
    clickAndHold()：长按鼠标而不松开
    DragAndDrop()：将元素从一个点拖放到另一个点
    moveToElement()：将鼠标指针移动到元素的中心
    contextClick() : 执行鼠标右键单击

Selenium 中的键盘操作：

    sendKeys()：向元素发送一系列键
    keyUp()：执行按键释放
    keyDown()：执行按键而不释放

## 




