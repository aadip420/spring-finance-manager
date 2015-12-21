### Source Access ###
There should be one tag per article released.

```
svn checkout http://spring-finance-manager.googlecode.com/svn/tags/FinanceManager-0.X/
```

(X should correspond to the version you wish to download)

Of course this assumes that you have a SVN client installed. Alternatively you can just download the project sources from the download section of the 'Project Home' Web site.

### Compile and build project ###
Then in a next step you need to compile or install the application via maven:

```
cd FinanceManager-0.X
mvn install
```

This assumes you have maven 2.0.9 or higher installed.

### Test the project ###
To run the tests separately, you can run:

```
mvn test
```

### Build Eclipse project artifacts ###
Finally, if you would like to import the project into Eclipse, IntelliJ, or NetBeans, you need to install the relevant plugin in the project pom.xml. By default, the pom contains the maven plugin for Eclipse:

```
mvn clean eclipse:clean eclipse:eclipse
```

### Run Application ###
I have tested the application on [Apache Tomcat](http://tomcat.apache.org/) version 6.0.18.