# Exercise 3 - Individual (M7_ACTIVITY3)

- Modify your **M7_ACTIVITY1** and refactor the contents of **Main.java**. 
- Create a **MovieController, MovieService** and put them into different **packages**.
- **MovieController** has a dependency on **MovieService** and should call the service methods for business logic. It should also have the method **void registerRoutes()** containing all the routes.
- **MovieService** should call the **MovieRepository** methods. (And instantiate the EntityManager)
- Your Main.java should just contain the **port** and the instantiation of **MovieService** and **MovieController** only. 
- Call MovieController.registerRoutes() in Main.java
