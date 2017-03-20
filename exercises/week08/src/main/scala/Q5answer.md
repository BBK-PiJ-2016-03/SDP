### Comment on this statement with reference to modularity and construction bloat.  ###
    “In general, the details of object construction, such as instantiating and initialising the 
    components that comprise the object, are kept within the object, often as part of its 
    constructor.”

Modularity can be achieved though swapping out composed objects via dependency injection, but this
extracts the instantiation of the dependency outside of the class. If such component instantiation
remains within the class, this will lead to a reduction on the modularity of the object and also
serve to increase both the complexity and size of the class in addition to violating the single
responsibility principle.

While many smaller classes may keep component initialisation inside the class, externalising such
construction serves to better meet a number of solid principles including:

* Single Responsibility Principle
* Open Closed Principle
* Dependency inversion Principle
