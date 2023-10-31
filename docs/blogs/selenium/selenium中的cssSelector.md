selenium中的cssSelector
===
see: https://devqa.io/selenium-css-selectors/

## CSS Selectors by Attribute
Let’s imagine we have a tag with the following attributes [id, class, name, value]

    <input type="text" id="fistname" name="first_name" class="myForm">
The generic way to locate elements by attribute is:

    css = element_name[<attribute_name>='<value>']
Example:

    WebElement firstName = driver.findElement(By.cssSelector("input[name='first_name']"));

### Id Attribute
In CSS, we can use # notation to select the id attribute of an element:

Example:

    driver.findElement(By.cssSelector("input#firstname"));
    
    //or
    
    driver.findElement(By.cssSelector("#firstname"));
### Class Attribute
The same principle can be used to locate elements by their class attribute.

We use the . notation.

    driver.findElement(By.cssSelector("input.myForm"));
    
    //or
    
    driver.findElement(By.cssSelector(".myForm"));
Note: Take extra care when using the . notation as there could be many web elements on the HTML source with the same class attribute.
### Multiple Attributes
Sometimes there is a need to be more specific with the selection criteria in order to locate the correct element.
    
    <div class="ajax_enabled" style="display:block">
The value of the display could either be “none” or “block” depending on the ajax call. In this situation, we have to locate the element by both class and style.

Example:
    
    driver.findElement(By.cssSelector("div[class='ajax_enabled'] [style='display:block']"));
### Attribute NOT contain a specific value
In WebDriver, how do you find elements whose attribute contain values which you don’t want to select? This CSS selector example shows how NOT to select by specific attribute value

Suppose you have many elements which share the same attribute and attribute value, but some of those elements have other variables appended to the value. e.g:

    <div class="day past calendar-day-2017-02-13 calendar-dow-1 unavailable">
    <div class="day today calendar-day-2017-02-14 calendar-dow-2 unavailable">
    <div class="day calendar-day-2017-02-15 calendar-dow-3">
    <div class="day calendar-day-2017-02-16 calendar-dow-4">
In the above snippet, we want to select an available day (i.e. the two last div elements)

As can be seen, all four divs contain “calendar-day-“ but the first two also contain “unavailable” which we don’t want.

The CSS selector for Not selecting the first two divs is
    
    driver.findElement(By.cssSelector("div[class*=calendar-day-]:not([class*='unavailable'])"));"
### Locating Child Element
    <div id="logo">
        <img src="./logo.png" />
    </div>
To locate the image tag, we use:
    
    driver.findElement(By.cssSelector("div#logo img"));
### Multiple Child Elements
There are occasions when there are multiple child elements within the same parent element such as list elements
    
    <ul id="fruit">
        <li>Apple</li>
        <li>Orange</li>
        <li>Banana</li>
    </ul>
As can be seen, the individual list elements don’t have any id associated with them. To locate the element with text ‘Orange’, we have to use nth-of-type.

Example:
    
    driver.findElement(By.cssSelector("ul#fruit li:nth-of-type(2)"));
Likewise, to select the last child element, i.e. ‘Banana’, we use:
    
    driver.findElement(By.cssSelector("ul#fruit li:last-child"));


## Dynamically Generated Ids
We can use string matchers to locate elements with dynamically generated Ids.

In this example, all the three div elements contain the word ‘random’.
    
    <div id="123_randomId">
    <div id="randomId_456">
    <div id="123_pattern_randomId">
Attribute Starts with
To select the first div element, we would use ^= which means ‘starts with’:

    driver.findElement(By.cssSelector("div[id^='123']"));
Attribute Ends with
To select the second div element, we would use $= which means ‘ends with’:

    driver.findElement(By.cssSelector("div[id$='456']"));
Attribute Contains
To select the last div element we would use *= which means ‘sub-string’

    driver.findElement(By.cssSelector("div[id*='_pattern_']"));
We can also use the contains

    driver.findElement(By.cssSelector("div:contains('_pattern_')"));