## Strategy Pattern

The strategy pattern is a behaviour design patten, it allows selecting algorithms during at runtime.
Useful when you want ro provide multiple ways to accomplish a task. 
The pattern let algorithm very independently of clients that use it, it converts the generalization
of template method to composite or aggregation.
It allows the algorithm to very frequently and is a very good alternate solution to sub-classing. 

One of the example of this patterns in jdk is Collections.sort() method that takes comparator parameter 
with different implementation of comparator interface. 

At the Strategy pattern the following component are participating:
* The _Strategy_, an abstraction (interface) of the strategies via an interface or an abstract class. 
* The _ConcreteStrategy(ies)_, the strategy(ies) implementation(s) that contain algorithms specific implementation.
* The _Context_, the class which uses the strategy. 

```
                                                             +--------------------+
                                                            .'      <<Class>>     |
                              +--------------------+     .-' |  ConcreteStrategy1 |
                              |    <<interface>>   |   .'    +--------------------+
+--------------+     refers   |      Strategy      |<-'                .
|   Context    |-------------@+--------------------+<.                 .   N implementations
+--------------+              |       apply()      |  `.               .
                              +--------------------+    `-.  +--------------------+
                                                           `.|      <<Class>>     |
                                                             |  ConcreteStrategyN |
                                                             +--------------------+
```

### Test Case

In our scenario, there is an employer that is going to hire some people, the candidate, for a job position.
Each candidate holds some degree which will be evaluated by the employer in order to select the appropriate
candidate for the job. The selection algorithm may very, for example could be the degree's relevance with the fields
of the offering job positions, the grade of the degree, the number of the degree or mix of the above. 

In our case two hiring case strategies will be used:
* Context  ---> Employer( the employer).
* Strategy ---> HiringStrategy (hiring strategy common api)
* ConcreteStrategy1 ---> DegreeRelevantHiringStrategy (relevant Degree)
* ConcreteStrategy2 ---> GradeHiringStrategy (relevant Grade)

### Discussion

The Strategy pattern implementation using lambdas differs from the old approach in how the various strategies
are implemented. At the old approach, the strategies are implemented via classes (or anonymous classes) whereas
using lambdas the strategies are implemented with lambdas. Rather than creating a hierarchy of classes to
support the strategy pattern we can now create a library of lambda functions or static methods (used as method
references) to apply the respective strategy.

```
                                                              +------------+
                                                            .'|   lambda1  |
                              +--------------------+     .-'  +------------+
                              |    <<interface>>   |   .'           .
+--------------+    refers    |      Strategy      |<-'             . N lambdas
|   Context    |-------------@+--------------------+<.              .
+--------------+              |       apply()      |  `.
                              +--------------------+    `-.  +------------+
                                                           `.|   lambdaN  |
                                                             +------------+
```
