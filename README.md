# ApplitoolsCrossBrowserHackathon
This is my submission for Applitools hackathon for performing cross browser testing in traditional way as well as using Applitools Ultra Fast Grid.  

In **Traditional approach**, each test runs in **Parallel** & checks the scenarios in different browsers & viewports simultaneously, saving a lot of time(although still not comparable and accurate as the Applitools Ultrafast Grid). This solution makes use of ***Selenium along with Java, TestNG & Maven***. 

**Modern Approach** makes use of the ***Ultrafast Grid*** where only 1 browser is instantiated on the local machine and all the processing(across all the browsers & viewports) is done behind the scenes(in parallel). This approach is super easy to code, super fast to execute & provides amazing reliability for your tests which you get by putting in a minimal effort.


# About the Hackathon

The 1st  [version of the app (V1)](https://demo.applitools.com/gridHackathonV1.html)  is already built and is “bug-free”. Your developers are now coming up with a newer version,  [version (V2) of the app](https://demo.applitools.com/gridHackathonV2.html), and assume that it’s full of bugs.

The challenge is to build the automation suite for the first version of the app and use it to find bugs in the second version (V2) of the app. You need to automate three (3) main tasks across seven (7) different combinations of browsers and screen resolutions (viewports). Further, you need to automate the tasks in both the traditional approach and the Modern approach through Visual AI, for both V1 and V2 versions of the app. "Traditional approach”, means without using Applitools Visual AI. 

Read More about it [Here](https://applitools.com/cross-browser-testing-hackathon-v20-1-instructions)

## Setup & Usage
Follow below steps in order to setup project and execute the test(s).

-   Clone  the [repo](https://github.com/narulacool/ApplitoolsCrossBrowserHackathon.git) or Download Zip and import as Maven project in preferred IDE
-   Make sure you've maven configured in your machine and then run below maven commands to run the desired tests
- For executing Traditional Tests on V1 App
	- `mvn test -Dsurefire.suiteXmlFiles=Traditional-V1.xml`
- For executing Traditional Tests on V2 App
	- `mvn test -Dsurefire.suiteXmlFiles=Traditional-V2.xml`
- For executing Modern Tests on V1 App
	- `mvn test -Dsurefire.suiteXmlFiles=Modern-V1.xml`
- For executing Modern Tests on V2 App
	- `mvn test -Dsurefire.suiteXmlFiles=Modern-V2.xml`

## Challenges Faced - Solved

 - Since the tests focused on cross browser visual checks, I implemented a ***Java based Image checker*** solution taking some cues from [here](http://mundrisoft.com/tech-bytes/compare-images-using-java/)
 - To cover the visual aspects such as the ***colour of the text or the background colour***, I implemented some java functions for fetching the CSS values using Selenium for different elements wherever required.
 - For the traditional approach the **viewport size** for Tablet(768x700) given in instructions was launching the site in Mobile view using selenium. This was due to width calculation being done differently in Selenium. Selenium treats the provided window size width as window's outer width. To solve this I used 850x700 as the size for Tablet.
 - Each **Test is launched in parallel on the 7 viewport-browser combinations** by making use of *TestNG's* data provider with parallel=true attribute. This saves time over sequential execution.
 - Since the **footer & header** was same across the pages, I made **page object files of these components** and **reused the functions across the pages & Tests**. However when I started this I got to know that the Id's of these elements are different on both homepage & product details page. So I switched to using xpaths wherever necessary instead of using ID. This is a little deviation from the hackathon guidelines of using ID's but I had to do it for reusability purpose. I hope this is fine.
 - To avoid failures due to any missing dependencies, have kept all selenium drivers in the project's "src/test/resources/" folder. All the baseline images for Java based comparison are kept in "src/test/resources/images"
 - Since the tests focused on cross browser visual checks, I also evaluated [Ashot](https://github.com/pazone/ashot) utility for taking full page screenshots & comparing the V1 & V2 versions. It provides basic image comparison techniques but the code needed to be tweaked for different browsers & viewport & seemed flaky for advanced usages. I went ahead deciding not to use it because of the limitations & since that did not fit the purpose of this hackathon. 

## Author

 - Tarun Narula 
 

> Find me on [Linkedin](https://www.linkedin.com/in/tarun-narula-28530950/) | [Twitter](https://twitter.com/narula_cool)


