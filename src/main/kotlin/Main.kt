import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.MainScreen

@Composable
@Preview
fun App() {
    MaterialTheme(
        colors = Colors(
            primary = CoffeeTheme.primary,
            onPrimary = Color.White,
            background = CoffeeTheme.background,
            error = Color.Red,
            isLight = false,
            onBackground = Color.Black,
            onError = Color.White,
            secondary = CoffeeTheme.secondary,
            onSecondary = Color.White,
            surface = CoffeeTheme.background,
            onSurface = Color.Black,
            primaryVariant = CoffeeTheme.primary,
            secondaryVariant = CoffeeTheme.secondary
        )
    ) {
        MainScreen()
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "MasterCheff",
        icon = painterResource("coffee-cup.png"),
        undecorated = false
    ) {
        App()
    }
}
