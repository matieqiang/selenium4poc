Smart Ways to Use XPath in Selenium
===

table of contents

- basic xpath syntax
  - What is Absolute Xpath?
  - Why Absolute Xpath is Not Recommended for Selenium Test Automation?
  - What is Relative Xpath?
- debugging xpath,How to Construct XPath Using Chrome Browser DevTools Window?
- How to Create Dynamic XPath in Selenium?
- How to Write XPath for Different Types of HTML Tags and Attributes?
- How to Write XPath Contains() Function in Selenium Web Driver?
- Using Contains() in Xpath for Class Attribute
- XPath Contains Functions for Attributes.
- XPath Matching Text Elements
- How to Match Exact Text in XPath?
- Syntax for Matching Exact Text in Xpath Selenium
- Partial Match of Text Content in Xpath
  - Syntax for Partial Matching Text in XPath
- Using Conditions in XPath
  - OR Condition in Xpath
  - AND Condition in XPath
- Starts-With in Xpath
  - XPath Starts-with Syntax:
- XPath Axes
  - List of XPath Axes methods
- How to Write Codeless Automation Scripts Using Testsigma
- What are the different ways to find XPath in Selenium?
- How many ways can you find XPath in Selenium?
- Which of the following are valid methods used in XPath?
- Why do we use XPath in Selenium?
- Which is the fastest XPath?
- Suggested Readings

## basic xpath syntax
    //tag_name[@attribute='value']
    // : 代表当前节点
    tag_name：HTML 标签名称。示例 input、div、span 等。
    @attribute：属性，class、id、aria-label 等。
    value : 属性的值

### xpath type
- 绝对xpath,不推荐用与selenium,  
相对xpath
## debugging xpath,How to Construct XPath
- f12 打开 devTools
- copy: 在element上 右键 copy xpath,这种方法copy的代码不易读，不建议使用
- 验证xpath: 在elements 页面ctrl + f 写 xpath 语句测试效果

## 参考
https://testsigma.com/blog/xpath-in-selenium/#How_to_Construct_XPath_Using_Chrome_Browser_DevTools_Window