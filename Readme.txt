Prerequisite
============
There are several prerequisite dependencies you should install on your machine prior to starting to work with this project:
1. Need to install Java - Java 11
2. An IDE to write your tests on -Eclipse or IntelliJ
3. Need to Install Maven - Apache Maven

Eclipse users should also install:
	1	Maven Plugin
	2	TestNG Plugin - For reporting

Project components
==================
	•	Page objects are in the directory src/main/java/Page
	•	Test classes are in the the directory src/test/java/Test
	.   Configuration class in the diirectory src/test/java/Utils

Implemented Browsers
====================
	•	Chrome
	•	Firefox
	•	Safari	

Execution
=========
	•	Go to project path in terminal For
	•	example: /Users/qamacbookpro/Desktop/latest_prospecta/docker_hybrid_bitbucket/sub_hybrid_ui_docker/hybrid_ui_docker
	•	Run mvn clean verify
	•	Run mvn compile
	•	Run mvn test
You can find the test result in Prospecta\target\surefire-reports\index.html.

