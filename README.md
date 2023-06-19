Prerequisite
============
    There are several prerequisite dependencies you should install on your machine prior to starting to work with this project:
    • Need to install Java - Java 11
    • An IDE to write your tests on -Eclipse or IntelliJ
    • Need to Install Maven - Apache Maven

Eclipse users should also install:
============
    • Maven Plugin
    • TestNG Plugin - For reporting

Project components
==================
	•	Page objects are in the directory src/main/java/Page
	•	Test classes are in the directory src/test/java/Test
	•   Configuration class in the diirectory src/test/java/Utils

Implemented Browsers
====================
	•	Chrome
	•	Firefox
	•	Safari	

Execution
=========
	•	Go to project path in terminal For
	•	example: /Users/qamacbookpro/Desktop/latest_prospecta/Bitbucket_docker/test-automation-script
	•	Run 'mvn clean verify' - to run all tests
	•	Run 'mvn clean test -Dsurefire.suiteXmlFiles=build_xmls/list_Page_Search.xml -Denv=QAH' - to run single xml with specific env
    •   Run 'mvn clean verify -Denv=QAH/QAR/SAND' - to run all-suite against env
        You can find the test result in Prospecta\target\surefire-reports\html\index.html or output.html.


