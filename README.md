# SendingMessage-SampleBDD
Sample BDD project to log in, send message, log out for UI testing.
This is a sample BDD project written in Java using Cucumber and Selenium.

##Setup

Install a chromedriver compatible with your current Chrome browser running the the computer. 
This test ran using Chrome Version 84.0.4147.89 and ChromeDriver 84.0.4147.30.
Take note of the path of your ChromeDriver and update setProperty in @Before hooks which can be found in MyStepdefs class.

##Running Test

When running in Intellij IDE, please ensure that:

Cucumber for java plugin is installed and compatible with your IDE

\src\main\resources is marked as Resources Root

\src\main\resources contains the files .feature

\src\main\java is marked as Sources Root

\src\main\java contain the folder for step definitions

The Feature configuration in the run test class contain step definitions as Glue

The pom dependencies have been imported.

