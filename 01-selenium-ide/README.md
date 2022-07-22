## Selenium IDE

Selenium IDE is a plugin for Firefox. 

It is very useful for bootstrapping tests. It allows you to interact with the browser, and whilst you do so it records the commands.

The resulting test can be exported into Java. This is not a recommended approach, but the code it generates can always be optimised.

For more info see the [exporting section](#exporting-to-java-code)

### Prerequisites

For this tutorial:

  * Install Firefox
  * Install [Selenium IDE](https://addons.mozilla.org/en-GB/firefox/addon/selenium-ide/)

Selenium IDE should now be available as an icon in the top right of your browser tab.

### Record and run

To create a new test.

  * Open up a new website to hack. There is a good list [here](https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/), I would suggest: [this one](https://automationintesting.online/).

  * Open Selenium IDE and select to create a new test.

  * Click the recording button

  * Perform interactions

The UI should be intuitive and once your test is complete, you can save it and run it.

N.B. The test execution speed timer icon at the top can be used to control the speed of the test.

### Adding assertions

In your test plan, right click and choose `Insert new command`.

You can use `assert` commands for checks which will terminate the test upon failure, and `verify` commands for checks which are "soft" and allow it to continue.

You must set the target of the assertion, but the IDE allows you to determine this by clicking the `Select target in page` icon.

### Exporting to Java code 

In the leftmost sidebar, you can see the names of the tests. 

Hover the mouse over the name of the test to export, and you will see a vertical elipsis.

Click this and choose `Export`

