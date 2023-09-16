# Out and About Events for Men

## Stack

* Jetpack Compose

## TODO

* Dependency injection (Dagger, Hilt, Koin)
* Feature toggles
* Theme switching
* Build service
* Caching user favorites
* Event list item
* Event list/Event grid switching
* Event grid for landscape on handset
* Event list and detail panes for foldables or larger screens
* Event detail
* Nested navigation graph (IN PROGRESS)
* Combing flows?
* Images
  * Coil placeholders images for error and loading states
* Modularize ui components, domain layer etc

## Coding conventions

Method parameters are ordered alphabetically, starting with required
non-lambda params, followed by optional non-lambda params (modifier must  
be first in this list), followed by required lambda params, followed by  
optional lambda params.

Source: https://android.googlesource.com/platform/frameworks/support/+/androidx-main/compose/docs/compose-api-guidelines.md

Example:

```kotlin
@Composable
fun MyComposable(
    currentTitle: String,
    isDarkMode: Boolean,
    modifier: Modifier = Modifier,
    myString: String? = null,
    shouldIntegrate: Boolean = false,
    nonOptionalLambda: () -> Unit,
    optionalLambda: (() -> 
@Composable
fun MyComposable(
    currentTitle: String,
    isDarkMode: Boolean,
    modifier: Modifier = Modifier,
    myString: String? = null,
    shouldIntegrate: Boolean = false,
    nonOptionalLambda: () -> Unit,
    optionalLambda: (() -> Unit)?= null
) {
    //... 
@Composable
fun MyComposable(
    currentTitle: String,
    isDarkMode: Boolean,
    modifier: Modifier = Modifier,
    myString: String? = null,
    shouldIntegrate: Boolean = false,
    nonOptionalLambda: () -> Unit,
    optionalLambda: (() -> Unit)?= null
) {
    //...
}
```
}
```Unit)?= null
) {
    //... 
@Composable
fun MyComposable(
    currentTitle: String,
    isDarkMode: Boolean,
    modifier: Modifier = Modifier,
    myString: String? = null,
    shouldIntegrate: Boolean = false,
    nonOptionalLambda: () -> Unit,
    optionalLambda: (() -> Unit)?= null
) {
    //...
}
```
}
```