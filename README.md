# Babbo Natale is again among us
#### Video Demo:  https://www.youtube.com/watch?v=AulA-1d5m0M
#### Description:

# Babbo Natale is again among us
#### Video Demo:  https://www.youtube.com/watch?v=AulA-1d5m0M
#### Description:


This is the final Project of CS50.

The application is written in Java and its function is to represent Santa Clause's board with which he can deliver presents to all kids of the world.

The main structure of the project is based on MVC pattern which best suits the task.
MVC goes well with CRUD operations because you have objects that are constantly
created, read, updated and deleted and, in order to handle this, you need to have
a pattern that keeps everything separated: main.java.model, view and controller.
The main.java.model is the part that contains data structures, the controller is the part in which it's implemented the logic of the program and finally the view is the way you want data to appear on screen or output in general.

Utils Classes have been used for reading files and formatting strings; this approach was adopted for project modularity and reusability.

Another important thing to punctualize is the use of a main.java.model object that contains abstract logic as well.
This could be for example the Order class which contains a setDeliveryStatus method which is for
handling status update. And as you can see from this code:

```java
    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        if((DeliveryStatus.IN_PREPARATION.name().equals(deliveryStatus.name()) && DeliveryStatus.NOT_PREPARED.name().equals(this.deliveryStatus.name()))
           || (DeliveryStatus.IN_DELIVERY.name().equals(deliveryStatus.name()) && DeliveryStatus.IN_PREPARATION.name().equals(this.deliveryStatus.name()))
           || (DeliveryStatus.DELIVERED.name().equals(deliveryStatus.name()) && DeliveryStatus.IN_DELIVERY.name().equals(this.deliveryStatus.name()))
        ) {
            this.deliveryStatus = deliveryStatus;
        }
    }
```
you're telling your main.java.model to update itself only if certain conditions are met.
So, in a sense also main.java.model can have logic, but it needs to impact the object itself not other objects.
This logic can be seen as a graph so for sure it's an abstract logic turned into practice.




I'd like to Thank Professor David for the way he trasmits to the students the basics of programming, really well done!


And I thank you all CS50 for letting me be participant of this amazing course.

