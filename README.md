### Hexagonal Architecture in Kotlin Spring boot

Alistair Cockburn developed hexagonal architecture, or ports and adapters architecture, and used it for designing software applications. We insert inputs and outputs at the edge of our design with hexagonal architecture. It allows us to isolate the central logic of the application. Since our inputs and outputs are on edge, we can switch their handlers without affecting our core code.

The sides of the hexagonal architecture represent ports in the model. Rather than using a circle to show specific information regarding the ports, Cockburn chose this flat-sided shape. Below is an example interpretation of a hexagonal architecture diagram:


The model is balanced with many external services on the left and others on the right. The hexagonal architecture was developed as a model for structuring many application parts and created to handle I/O. I/O is on the model's external area. The grey area is where you will see the adapters, the hexagon's sides are the ports, and the middle is where the application and domain are found. The business/application/domain logic lives in the core, and there are no specifications.
  
### Benefits Over Traditional Layered Architecture
The hexagonal architecture was a departure from the traditional layered architecture. One of the significant differences with hexagonal architecture is that the user interface can be replaced. Using hexagonal architecture instead of layered architecture can be helpful due to its many benefits, such as:
  
• Maintainability: Our applications are highly regarded and trusted because of changes in one area's components.
• Flexibility: Quickly toggle between different applications; without changing source code, you can produce new adapters.
• Simple testing: Easily test in isolation as the code is separated from the implementation information of the outside.
• Agnostic: You can develop the inner core before building external services as the application is independent of exterior areas.
  
However, the hexagonal architecture does have a few flaws. A few of them are:
  
• Decoupling: Intermediate classes could affect the overall performance of our application.
• Debugging: Adapters can often be challenging to understand and debug.
• Complex: Hexagonal architecture can be confusing as it can be challenging to decide what elements should go on the outside.