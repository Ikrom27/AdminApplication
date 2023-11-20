import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.CoffeeHouseDB
import ui.MainScreen

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

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
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
