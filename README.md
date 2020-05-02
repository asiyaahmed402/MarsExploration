# Project Template

***Mars Pioneer Xi:*** Mars Exploration

## Mission Statement 
Mars Pioneer xi  is a NASA mission to study the deep interiors of the planet, investigate key questions about potential life, return samples of Martian rocks and soil back to earth, search for evidence of atmospheric gasses that could be signatures of active biological or geological process

***Fields:*** Langley Research Center, Goddard Space Flight Center, Canberra Deep Space
***Key Players:*** Blue Moon, SpaceX, Lockheed Martin, Spirit AeroSystem
***Manufactures:*** Rockwell Automation, Martin Marietta (ET) Boeing, OHB SE
***University Partners:*** MIT, Stanford, UCLA, Carnegie Mellon

## Design Patterns 

### Builder Pattern and Goals
The Builder Design Pattern is used in this project to build the space shuttle. Builder class ensures that the specs are defined during the creation process of the shuttle
Builder will ultimately help the ShuttleManufacturer class have detailed information like the parts of the shuttle. The parts so far are: command center, electrical power (system), navigation system, thermal system
***Goal:*** Flexibility: The intent of the Builder design pattern is to separate the construction of a complex object from its representation.
***Specification:*** model name, id, refueling rate, weight, speed, shuttle parts, engine thrust

### State Pattern and Goals
The State Design Pattern is used in this project to allow the space shuttle parts to alter their behavior (health status) when their internal states change
***Shuttle Part States:*** Healthy, Caution and Warning(CW), and Critical Alert. 
***Goal:*** Avoiding duplicate code
The warning system evaluates the health status of the various parts of the shuttle, prints the results of that evaluation, and performs maintenance. 

### Strategy Pattern and Goals
With the advancement of space exploration, the concept of fueling stations in outer space is no longer something dreamed up by sci-fi authors. This program includes two fueling options; Exxon Galactic Station and Deimos Station. As the name suggests, Deimos Station will be located on Mar’s moon; Deimos. Exxon Galactic Station will orbit the earth. 
Strategy Pattern is used to implement interchangeable fueling options for the Mars Pioneer Xi mission which makes it flexible. 
***Goals:*** Flexibility and Reusability. 

### Observer Pattern and Goals
***Goals:*** flexibility, avoiding duplicate code, reusability
The Observer Pattern is used to notify NASA Field Centers of space exploration missions. When receiving an exploration mission, the fields will receive information  on the mission and will be assigned to it
***Field Centers:*** Canberra Deep Space, Goddard Flight Center, Langley Research Center 
***Space Exploration:*** Algae Biofuel, Extraterrestrial Life, Fly By, Space Probe
I can always add more field center classes if the program were to grow and more fields become involved. 

## Improvement and Future Features
Add different types of test scenarios, not just ones that only test the warning system (health status) of the various parts of the space shuttle
Make use of the adapter pattern in case 3rd party applications want to access this application 
***Future Feature:*** The warning system should have a manual that comes with it, the manual will of course be more complex than the warning system. Have the warning system play as a “factory” that produces different parts of the manual. 




# How to compile the project

We use Apache Maven to compile and run this project. 

You need to install Apache Maven (https://maven.apache.org/)  on your system. 

Type on the command line: 

```bash
mvn clean compile
```

# How to create a binary runnable package 


```bash
mvn clean compile assembly:single
```


# How to run

```bash
mvn -q clean compile exec:java -Dexec.executable="edu.bu.met.cs665.Main" -Dlog4j.configuration="file:log4j.properties"
```

We recommand the above command for running the project. 

Alternativly, you can run the following command. It will generate a single jar file with all of the dependencies. 

```bash
mvn clean compile assembly:single

java -Dlog4j.configuration=file:log4j.properties -classpath ./target/JavaProjectTemplate-1.0-SNAPSHOT-jar-with-dependencies.jar  edu.bu.met.cs665.Main
```


# Run all the unit test classes.


```bash
mvn clean compile test

```

# Using Findbugs 

To see bug detail using the Findbugs GUI, use the following command "mvn findbugs:gui"

Or you can create a XML report by using  


```bash
mvn findbugs:gui 
```

or 


```bash
mvn findbugs:findbugs
```


For more info about FindBugs see 

http://findbugs.sourceforge.net/

And about Maven Findbug plugin see 
https://gleclaire.github.io/findbugs-maven-plugin/index.html


You can install Findbugs Eclipse Plugin 

http://findbugs.sourceforge.net/manual/eclipse.html



SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


# Run Checkstyle 

CheckStyle code styling configuration files are in config/ directory. Maven checkstyle plugin is set to use google code style. 
You can change it to other styles like sun checkstyle. 

To analyze this example using CheckStyle run 

```bash
mvn checkstyle:check
```

This will generate a report in XML format


```bash
target/checkstyle-checker.xml
target/checkstyle-result.xml
```

and the following command will generate a report in HTML format that you can open it using a Web browser. 

```bash
mvn checkstyle:checkstyle
```

```bash
target/site/checkstyle.html
```


# Generate  coveralls:report 

You can find more info about coveralls 

https://coveralls.io/

```bash
mvn -DrepoToken=YOUR-REPO-TOCKEN-ON-COVERALLS  cobertura:cobertura coveralls:report
```


