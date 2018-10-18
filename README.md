# Description

An example project based on the [greenfoot-runner](https://github.com/benoitheinrich/greenfoot-runner) project.

This project shows an extension of the hedghogs project that can be edited and run inside IntelliJ IDEA (or probably any IDE).

The project bundles the **libs/greenfoot-runner-dist-3.0.4-SNAPSHOT.jar** file that was generated from the greenfoot-runner.

You can fork this project and update files as you wish.

# Disclamer

This project isn't supported by any greenfoot team's member and is a personal attempt to allow my son to use IntelliJ 
IDEA to make his learning easier.

# Running your project in intellij

If you use IntelliJ IDEA as your IDE, then the easiest way is to open the [`Runner`](https://github.com/benoitheinrich/greenfoot-runner-example/blob/master/src/main/java/bh/greenfoot/runner/Runner.java) 
class and to run it as an **Application**. 

# Distributing your application

If you want to build your own jar with your project and distribute it, you can use the following command:
```
gradle dist
```

This will build a jar file in the `build/libs/greenfoot-runner-example-dist-1.0-SNAPSHOT.jar` directory.

You can then run this file by using the command:
```
java -jar build/libs/greenfoot-runner-example-dist-1.0-SNAPSHOT.jar
```

