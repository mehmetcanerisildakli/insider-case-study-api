# INSIDER TEST AUTOMATION CASE STUDY API

It is an automation project created for Insider company. It has 2 tests with the following steps

## Steps

- Using “pet” endpoints from [Swagger Petstore](https://petstore.swagger.io/)  write CRUD operations API
tests with positive and negative scenarios.

## Installation

Use git command

```bash
https://github.com/mehmetcanerisildakli/insider-case-study-api.git
```

## Usage
Check insider.xml file; inside *src/test/java/tests* and run the file
```
<suite name="testSuite">
    <tests name="insiderAPITests">
        <test name="insiderAPICase">
            <classes>
                <class name="tests.InsiderRest"> </class>
            </classes>
        </test>
    </tests>
</suite>
```

## Technology

* Java
* Rest Assured
* Maven
* TestNG

## License
[MIT](https://choosealicense.com/licenses/mit/)
