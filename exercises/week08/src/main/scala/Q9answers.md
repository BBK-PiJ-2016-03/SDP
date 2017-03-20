### When should one make use of the Bridge Design Pattern? ###
When you wish to decouple abstraction from implementation via the 
use of composition. A good example would be coloured shapes. It is
desirable to, instead of producing a class for each shape and colour
combination, to instead implement colour as a composed property of the
shape. This way, the colour can be varied independently of the shape,
but your abstraction is a coloured shape.