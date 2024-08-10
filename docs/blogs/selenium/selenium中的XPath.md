selenium中的XPath使用方法
===
作为 DOM 树的一部分呈现的任何 HTML 标签或任何 HTML 属性都符合 Xpath 的条件。
通过XPath可以查找任何类型的元素，例如 img、div、span、a、input，可以使用html的所有属性，例如 id、class、value、href、src。


## basic xpath syntax
    //tag_name[@attribute='value']
    // : 代表当前节点
    tag_name：HTML 标签名称。示例 input、div、span 等。
    @attribute：属性，class、id、aria-label 等。
    value : 属性的值

### XPath type
- 绝对XPath,绝对 Xpath 通常称为完整 Xpath，它从 HTML 文档的root开始。Xpath 的绝对值以单斜线 (/) 开头。 不建议将绝对 XPath 用于任何测试自动化，原因是绝对 XPath 从 DOM 结构/树文档的根开始。如果由于应用程序改进或功能交付而在路径之间添加了任何作为子元素的元素，则您的测试自动化代码就会中断。因此，在测试自动化中，相对 Xpath 定位器通常是使用它的最佳方式。
- 相对XPath，与绝对 Xpath 不同，相对 XPath 从 DOM 树的中间开始，并以双斜杠 (//) 开头。由于相对 Xpath 包含较少的顶级 HTML 元素节点依赖关系，因此更加稳定，通常用于测试自动化。相对 XPath 表达式比绝对 XPath 表达式更快，因为它们不依赖于整个文档层次结构。 尽可能使用相对 XPath 表达式以提高效率。

### 如何在 Selenium 中创建动态 XPath？
- Selenium XPath 中的 Contains() 方法通常在元素或属性的值动态更改时使用。

```
  语法：
  //tag_name[contains(@attribute,'partial_text')]
  <button type="button" class="getting started mbg blueocean">getting started</button>
  在上面的代码中，类名是getting start mbg blueocean，mbg单词是动态的，每次加载页面时它都会改变，静态文本是getting start，可以使用contains函数处理类属性，像下面这样。
  //button[contains(@class,'getting started')]
```
- 在 Xpath Selenium 中匹配精确文本的语法，当没有可用的唯一属性，但是有一个唯一的文本时，可以通过text()方法
```
//tag_name[text()='text_value']
```
- XPath 中部分匹配文本的语法
```html
//tag_name[contains(text(),'partial_text')]
```
- 在XPath中使用 or 条件
```
<input name="q" type="text" title="Search">

对于上面内容，如果想要匹配 name 属性或 title 属性，可以使用 OR，如果任何一个为 true，则它匹配该 DOM 元素。

//input[@title='Search' or @name='q']
```
- 在XPath中使用 and 条件
```
如果需要同时满足两个条件，则需要使用AND。例如想匹配title和name

//input[@title='Search' and @name='q']
```
- XPath starts-with(),用于匹配属性值的前缀
```
//tagName[starts-with(@attribute,'start-value')]
<input name="q" type="text" title="Search" id='searchbox-iasdfasdf'>
//input[starts-with(@id,'searchbox')]
```
- XPath ends-with(),语法与starts-with()一样，需要xpath 2.0版本以上支持

### XPath Axes 轴
XPath Axes 的所有方法

```
ancestor 匹配当前节点的所有祖先（父节点、祖父节点等）
ancestor-or-self Ancestor 或 self 用于标识上下文节点以及来自上下文节点的祖先元素。
attribute Xpath中的属性轴选择当前节点的所有属性，例： //input[attribute::name = 'btnK']
child 中的子轴匹配当前节点的所有子节点
descendant 选择 HTML 文档中当前节点的所有后代，包括子节点、孙节点等
descendant-or-self 用于选择当前节点和当前节点本身的所有后代，包括子节点、孙子节点等。
following 选择 DOM 树中当前节点结束标记之后的所有内容
following-sibling 选择 HTML 文档中当前节点之后的所有同级
parent 选择 HTML 文档中当前节点的父节点
preceding 匹配 HTML 文档中当前节点之前出现的所有节点，祖先、属性和命名空间除外
preceding-sibling 前一个兄弟节点用于选择当前节点之前的所有兄弟节点
self Self Axis在写Xpath时很少用到，这个是用来选择当前节点的
namespace

句法：
//tag_name[@attribute_name='attribute_value']//following::tag_name

- 当有多个匹配项时，可以使用 [1] [2] [3] 等索引。这将分别选择第 1 个、第2个和第 3个元素。
- 当没有其他方法选择元素时，建议使用Xpath。例如，如果 id 可用，则 id 优先于 XPath
- 单点（.）用于选择当前节点
- 使用双点 (..) 选择父级。例如，如果想获取 body 标记的父级，可以简单地使用 //body/.
```
## debugging xpath,How to Construct XPath
- f12 打开 devTools
- copy: 在element上 右键 copy xpath,这种方法copy的代码不易读，不建议使用
- 验证xpath: 在elements 页面ctrl + f 写 xpath 语句测试效果

## 参考
https://testsigma.com/blog/xpath-in-selenium/
https://www.w3.org/TR/xpath/#path-abbrev