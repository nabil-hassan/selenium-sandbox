## Selenium Java

This section discusses how to write test cases in Selenium.

Make sure to read [the Selenium IDE section](../01-selenium-ide).

All the information in this section is encapsulated into separate tests, which demonstrate the various concepts 
of using the Selenium Web Driver.

## Contents

  * [Basic Selenium Test Structure](src/test/java/net/nh/t1/BasicSeleniumTestStructureTest.java) - outlines how to lay out a test class.
  * [Element Locators](src/test/java/net/nh/t2/ElementLocatorsTest.java) - details how to use the various element locator expressions.

## Important!!!!!

N.B. Selenium requires a separate driver for each browser to be downloaded.

Please follow these instructions:

 * Download and install Firefox and determine its version

 * Download the WebDriver Zip File matching with your Firefox Version and apple chip from: [here](https://github.com/mozilla/geckodriver/releases).

 * Unpack the zip file

 * In your tests, replace the system property with the correct path to the driver.

```java
private static WebDriver driver;

@BeforeAll
static void setupAll() {
    System.setProperty("webdriver.gecko.driver", "/Users/ukcco1nha/Projects/selenium-drivers/geckodriver");
    driver = new FirefoxDriver();
}
```

## Opening a page and checking the title

Use webDriver.get() to retrieve the 

```java
// open a new browser window at the url
webDriver.get(url);

// retrieve the title
webDriver.getTitle();
```

## Headless Mode

Different drivers set headless mode in different ways. 

Refer to Google for more help.

```java
@BeforeAll
static void setupWebDriver() {
    System.setProperty("webdriver.gecko.driver", "/Users/ukcco1nha/Projects/selenium-drivers/geckodriver");

    var firefoxOptions = new FirefoxOptions().setHeadless(true);
    webDriver = new FirefoxDriver(firefoxOptions);
}
```

## Locating Elements

To simplify writing the element locating code, you can use certain tools:

* Use of Selenium IDE and its ability to export Java tests as described in: [the previous section](../01-selenium-ide/README.md).

* Right click and use inspect element in web browser and either use name/id, or copy the CSS selector and use `findElement(By.cssSelector())`.

Now, within your Selenium tests will need to identify and select elements using `webDriver.findElement(By by)`.

N.B. `findElement` returns a `NoSuchElementException` if elements are not found. 

You can either handle this with a try/catch, or use `findElements()` which will return an empty array if the element does not exist. 
Thus, you can alternatively use an assertion such as the below to confirm the element's existence:

```java
var successMessageLookup = webDriver.findElements(By.cssSelector("div.col-sm-5:nth-child(2) > div:nth-child(1) > h2:nth-child(1)"));
assertFalse(successMessageLookup.isEmpty(), "Unable to find confirmation message.");
```

### Location expressions

The by argument is usually one of the instances shown below.

It is recommended to prefer `.byName()` and `byId()` since they should return a single unique result, and __avoid using X-Path__ 
because it is coupled to webpage structure, and will break if the structure of the page changes  

N.B. findElement returns a `WebElement` object which also has a .findElement() method, thus allowing you to find child elements.

  * `By.id()` or `By.name()` - this is the most straightforward approach using the elements id or name attribute:

```java
webDriver.findElement(By.id("name"));
```

 * `By.className()` - this uses the CSS class name, but can only be used if the element has a single class, and is the only element with that class:

```java
webDriver.findElement(By.className("myCLass"));
```

 * `By.cssSelector()` - this is used when the element does not have an id or name attribute, and cannot be located by .className:

```java
webDriver.findElement(By.cssSelector("#collapseBanner > div > div:nth-child(3) > div.col-2.text-center > button"))
```

* `By.xpath()` - find element based on xpath expression - xpath models the page as a tree and allows you to find elements based on their position in the tree:

```java
webDriver.findElement(By.xpath("/html/body/div/div/div/div[4]/div/div/div[3]/h3"));
```

* `By.linkText()` - this is used for `<a>` elements - it returns any anchors whose inner text matches the specified text:

```shell
webDriver.findElement(By.linkText("Mark Winteringham"));
```

## Entering Input

The findElement method returns a `WebElement` object, which has the following methods for interaction:

  * `.click()` - used for form submission/button lick

```java
webDriver.findElement(By.id("submitBtn")).click();
```

  * `.sendKeys()` - used to enter input

```java
webDriver.findElement(By.id("name")).sendKeys("Nabil Hassan");
```

  * `clear()` - removes any input entered in a form element:

```java
webDriver.findElement(By.id("age")).clear();
```

  * `submit()` - if the element is a form, or a form element, this will submit it:

```java
webDriver.findElement(By.id("submitBtn")).submit();
```

## Checking Element State

There are a number of methods that can be used to check element state:

  * `getAttribute()` - retrieve DOM element attribute value - this can be used to return the value of a form input element too!!!!

```java
webDriver.findElement(By.id("comments")).getAttribute("value")); // retrieve input element value

webDriver.findElement(By.id("submitBtn")).getAttribute("data-score"); // retrieve data score attribute
```

  * `getText()` - used to retrieve the value of text elements such as H2 and P:

```java
webDriver.findElement(By.id("welcomeMessage")).getText(); 
```

  * `getCSSValue()` - get the value of a CSS attribute:

```java
webDriver.findElement(By.id("name")).getCssValue("color")
```

  * `isSelected()` - returns true if the element has been selected:

```java
webDriver.findElement(By.id("myInput")).isSelected();
```

  * `isEnabled()` - returns true unless the web element is a disabled formElement:

```java
webDriver.findElement(By.id("consent")).isEnabled();
```

* `isDisplayed()` - returns true unless the web element is a disabled formElement:

```java
webDriver.findElement(By.id("consent")).isEnabled();
```