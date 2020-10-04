# Dropbox_automation
Personal project, created from scratch.
Includes UI as well as RestAPI automation testing for the Dropbox website.

Stack: Selenium WebDriver, Java 11, Maven, Cucumber, POM, RestAssured.

Three-layer project: 
1. Easy to read Cucumber scenarios, written in simple English language
2. Step Definitions: a mid-layer that beginners in coding can understand
3. Page Objects, Configurations, etc, where all the magic actually happens :)

For the security purposes, login.yml has been git ignored, but can be added to /src/test/resources/data/.<br>
The format is the following:<br>
email: ""<br>
password: "" <br>
googlePassword: ""<br>
wrongPassword: ""


Issues I've encountered so far:
- Project configuration did not glue the "support" from the beginning, had to add it manually
- Attach file button is made with div tag, figuring out how to deal with that using WebDriver
- Learning whatever it takes to make hidden web elements visible: z-index and other css properties, inheritance, etc.

Due to the fact that Dropbox recently added captcha to their login page, only "sign in with google" option is currently working.
