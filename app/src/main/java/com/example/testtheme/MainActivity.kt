package com.example.testtheme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testtheme.ui.theme.TestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
//                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp() {
    val (PageHome, setPageHome) = rememberSaveable { mutableStateOf(false) }
    val (AboutHome, setAboutHome) = rememberSaveable { mutableStateOf(false) }
    if (PageHome) {
        Home(
            onClicked = {
                setPageHome(false)
            },
            title = "Exit " + stringResource(R.string.Home)
        )
    } else if (AboutHome) {
        About(
            onClicked = {
                setAboutHome(false)
            },
            title = "Exit " + stringResource(R.string.About)
        )
    } else {
        NotFound(
            onHome = {
                setPageHome(true)
            },
            onAbout = {
                setAboutHome(true)
            },
            title = "Not found page"
        )
    }
}

@Composable
fun ButtonCustom(onClick: () -> Unit, title: String) {
    Button(
        onClick = { onClick() }
    ) {
        Text(text = "$title")
    }
}

@Composable
fun Home(onClicked: () -> Unit, title: String) {
    ButtonCustom(
        onClick = { onClicked() },
        title = title
    )
}

@Composable
fun About(onClicked: () -> Unit, title: String) {
    ButtonCustom(
        onClick = { onClicked() },
        title = title
    )
}

@Composable
fun NotFound(title: String, onHome: () -> Unit, onAbout: () -> Unit) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = "$title!",
            style = MaterialTheme.typography.h1,
            textAlign = TextAlign.Center,
        )

        Row(
        ) {
            ButtonCustom(
                onClick = { onHome() },
                title = stringResource(R.string.Home)
            )
            Spacer(
                modifier = Modifier
                    .width(10.dp)
            )
            ButtonCustom(
                onClick = { onAbout() },
                title = stringResource(R.string.About)
            )
        }

    }

}


@Preview(showBackground = true)
@Composable
fun LightDefaultPreview() {
    TestTheme(darkTheme = false) {
        MainApp()
    }
}

@Preview(showBackground = true)
@Composable
fun DarkDefaultPreview() {
    TestTheme(darkTheme = true) {
        MainApp()
    }
}