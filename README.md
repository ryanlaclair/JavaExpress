# JavaExpress

A Java web application framework based on [ExpressJS](https://expressjs.com/).

### Building

JavaExpress uses [Maven](https://maven.apache.org/) to manage dependencies and build. After cloning this repository, to build a JAR file simply run:

```
mvn package
```

To install the package to your local repository for use as a dependency in other Maven projects, run:

```
mvn install
```

After this installation, you are ready to use JavaExpress in your Maven projects. In the `pom.xml` file for your project, just include JavaExpress as a dependency:

```
<dependency>
    <groupId>org.javaexpress</groupId>
    <artifactId>JavaExpress</artifactId>
    <version>0.1</version>
</dependency>
```

### Demo Application

For a basic demo application built with the JavaExpress web-application framework, see [DemoJavaExpress](https://github.com/ryanlaclair/DemoJavaExpress).
