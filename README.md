# QA Challenge -- SeleniumWebDriver

This Selenium WebDriver automation project is wiritten in Java, and uses Maven. All the dependencies needed to run this project are in the POM.xml file.

This project uses:
* Selenium Chrome Driver
* TestNG
* OpenCSV
* Apache Commons

Project Structure:
This project is build using Page Object Model and Data-Driven Development. All files accessed by the Test Class is doing using Ralative Path for avoid dependencies with specific folder structure or particular Operating Systems.

Data Source:
The data source used by the test scripts is located in project root folder name as data_source.csv. All test uses the same file in order to run.

Run Test suite:
I used TestNG run configurations for running my Test Clases, for run all the test suite you just need to run "TestSuite.xml" using TestNG run configurations.

After test suite runs it creates a folder called: test-output, inside this folder you will have "QA Challenge" folder were you can find index.html wich is the complete Test Run Report for the test suite if you want to have a simple view of the test cases go to QA Challenge and see "Contact Form.html". It's important to notice that this folder "test-output" only will be created if you have activate in your intelliJ o any IDE the default report options.

