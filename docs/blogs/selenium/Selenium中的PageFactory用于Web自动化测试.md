Selenium中的PageFactory用于Web自动化测试.md
===
原文： https://www.lambdatest.com/blog/page-factory-in-selenium/
在敏捷、快节奏的业务环境中，自动化测试已成为绝对必要的，并且非常注重加快上市时间。然而，就自动化而言，Selenium自动化测试在测试覆盖率和浏览器覆盖率方面仍然获得了最大的好处。

随着产品开发的进展，自动化测试人员也处于战备状态，以确保测试场景与产品中实现的功能一致。例如，如果在不考虑可扩展性和可维护性的情况下实施测试，则 Web 应用程序 UI 中的最小更改都会更改Selenium 测试自动化脚本。

## notes
1. 更大的挑战是让测试实现与测试脚本中使用的 Web 元素“更加分离”。
2. Selenium 中的页面对象模型，也称为 POM，是 Selenium 中流行的设计模式，用于创建用于存储 WebElement 的对象存储库。

## 1. Selenium 中的页面工厂是什么
- Selenium 中的页面工厂是 WebDriver 页面对象模型 (POM) 的高效内置实现，在优化方面超越了传统 POM。
作为页面对象的扩展，页面工厂通过提供专用类来简化 POM 的使用。
通过利用 Selenium 中的 Page Factory 类，测试人员可以简化与 Web 元素的交互，使其成为提高页面对象使用效率和简单性的催化剂。

可以肯定的是，Page Factory 是通过 Selenium 中的 Page Factory 类启用的 POM 组合。下图展示了页面对象模型（POM）和页面工厂的顶层区别：
![](https://www.lambdatest.com/blog/wp-content/uploads/2021/10/Page-Factory-in-Selenium-2.png)
尽管 Selenium 中的页面工厂可以以多种方式使用，但它确实有助于提高测试实现的可维护性和可重用性。

在这篇关于 Selenium Page Factory 教程的博客中，我们深入研究了 Selenium 中的 Page Factory，它通过Selenium WebDriver中的工厂类使页面对象的使用变得更加简单和容易。Selenium 中的页面工厂可以被认为是 Selenium WebDriver 的优化页面对象模型 (POM)。
让我们看看什么是 Selenium 中的页面工厂，并深入探讨 Selenium 测试中页面工厂和页面对象模型之间的区别。



# 其他参考：
- Selenium WebDriver 中的页面工厂和页面对象模型: https://testsigma.com/blog/page-object-model-in-selenium/
- Selenium 中的页面工厂：您需要了解的一切 https://www.testim.io/blog/page-factory-in-selenium/
- https://www.lambdatest.com/blog/selenium-webdriver-tutorial-with-examples/