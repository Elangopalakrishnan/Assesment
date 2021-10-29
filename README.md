# Assessment
Small Cucumber Project for Web Application Testing


How to Execute?
1. Run the Test
Run your test using mvn install or mvn verify from Terminal, mvn test -Dcucumber.filter.tags="@SmokeTests"
2. Test Result
See the result inside target/MyReports/report.html or target/MyReports/report.json folders that automatically generated after finished the test execution
Open html file in your browser
Or you can create your result https://reports.cucumber.io/reports/<GUID> by setting publish=true in @CucumberOptions in runner class
Some sample of test results

Basic Sample Test Report
![image](https://user-images.githubusercontent.com/26897289/137599382-ae295d37-2a84-4a7c-ab3d-6313ac01aec7.png)

Advanched html report on the cloud
![image](https://user-images.githubusercontent.com/26897289/137601283-e0e7d5ac-919e-483b-af5b-b29ef6e1592a.png)
![image](https://user-images.githubusercontent.com/26897289/137601292-a61942f2-67a1-46e3-859c-2755741eff69.png)


Further Improvements: We can use data provider / Apachi POI when scope of test coverage is increase.
Write common methods class to keep all common methods and call them where ever wanted (like click(), double-clik(), drop-down, actions() etc..)
And Add Plug-ins for extented reporting as per requirement.
