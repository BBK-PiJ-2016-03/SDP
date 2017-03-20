### (a) What is the Composite Pattern? ###
The composite pattern is a design pattern that allows you to treat
individual elements the same as collections / composites of elements.
### (b) Under what conditions would you use a Composite Design Pattern?  ###
When you wished to perform an action without regard for whether this was
being performed on an individual or composite. An example could be sending
email. A leaf would be an individual address, whereas a composite could
be a group of addresses. You could call 'send' on any combination of
these and expect the mail to be sent to each node in the tree hierarchy.
### (c) What are the four participants of the Composite Design Pattern?  ###
The client, a leaf, a composite and component interface