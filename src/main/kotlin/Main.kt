import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.MainScreen

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        MainScreen()
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
