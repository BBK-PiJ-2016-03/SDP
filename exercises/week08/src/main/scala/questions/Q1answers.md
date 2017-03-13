###Briefly describe the Strategy Design Pattern?

The Strategy Pattern uses dependency injection to swap out classes which
apply different implementations of a/some specified method(s). 

For example, a calculator may have a class injected that implements a
calculate method. Changing the class injected would modify the behaviour,
an add class would perform a different calculation to a subtract or divide
class.

###When is it appropriate to use the Strategy Design Pattern?

When it is desirable to provide an easy method of changing the behaviour
of the class or the implementation, for example to switch parsers to deal
with different data formats e.g. JSON, XML etc.

This needs to be weighed against the need for the functionality. In eXtreme
Programming, the minimum viable implementation would be employed and the
strategy pattern would only be refactored in if changing implementation 
became required.