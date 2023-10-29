# Navigation in Jetpack compose

The main navigation approach in Jetpack compose.
1. Navigation arguments
2. Using a shared ViewModel
3. Sharing a stateful dependency
4. Using a composition local of jetpack compose
5. Using persistent storage

Navigation arguments advantages:
* Simple implementation
* Values passed in NavArgment will survive process dead by default.

Navigation arguments disadvantages:
* Not suitable to share complex data
* Not convenient for sharing data between multiple screens
* Passed value will be stateless and cannot be change dynamically 

