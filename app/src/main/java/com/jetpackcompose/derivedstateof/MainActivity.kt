package com.jetpackcompose.derivedstateof

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jetpackcompose.derivedstateof.ui.theme.JetpackComposeDerivedStateOfTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDerivedStateOfTheme {
                // A surface container using the 'background' color from the theme
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Conversion(SampleData.conversationSample)
                }
            }
        }
    }
}

data class ChatMessage(val author: String, val message: String)

@Composable
fun MessageCard(message: ChatMessage) {
    Row(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "author picture",
            modifier = Modifier
                .size(40.dp)
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColor by animateColorAsState(if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface)

        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = message.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = message.message,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(all = 4.dp)
                )
            }

        }
    }
}

@Composable
fun Conversion(messages: List<ChatMessage>) {
    val lazyListState = rememberLazyListState()

    LazyColumn(
        state = lazyListState
    ) {
        messages.map { item { MessageCard(it) } }
    }

    LaunchedEffect(Unit, block = {
        lazyListState.animateScrollToItem(messages.size - 1)
    })
}
@Preview
@Composable
fun PreviewConversion() {
    Conversion(SampleData.conversationSample)

}

object SampleData {
    // Sample conversation data
    val conversationSample = listOf(
        ChatMessage(
            "Colleague",
            "Test...Test...Test..."
        ),
        ChatMessage(
            "Colleague",
            "List of Android versions:\n" +
                    "Android KitKat (API 19)\n" +
                    "Android Lollipop (API 21)\n" +
                    "Android Marshmallow (API 23)\n" +
                    "Android Nougat (API 24)\n" +
                    "Android Oreo (API 26)\n" +
                    "Android Pie (API 28)\n" +
                    "Android 10 (API 29)\n" +
                    "Android 11 (API 30)\n" +
                    "Android 12 (API 31)\n"
        ),
        ChatMessage(
            "Colleague",
            "I think Kotlin is my favorite programming language.\n" +
                    "It's so much fun!"
        ),
        ChatMessage(
            "Colleague",
            "Searching for alternatives to XML layouts..."
        ),
        ChatMessage(
            "Colleague",
            "Hey, take a look at Jetpack Compose, it's great!\n" +
                    "It's the Android's modern toolkit for building native UI." +
                    "It simplifies and accelerates UI development on Android." +
                    "Less code, powerful tools, and intuitive Kotlin APIs :)"
        ),
        ChatMessage(
            "Colleague",
            "It's available from API 21+ :)"
        ),
        ChatMessage(
            "Colleague",
            "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
        ),
        ChatMessage(
            "Colleague",
            "Android Studio next version's name is Arctic Fox"
        ),
        ChatMessage(
            "Colleague",
            "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
        ),
        ChatMessage(
            "Colleague",
            "I didn't know you can now run the emulator directly from Android Studio"
        ),
        ChatMessage(
            "Colleague",
            "Compose Previews are great to check quickly how a composable layout looks like"
        ),
        ChatMessage(
            "Colleague",
            "Previews are also interactive after enabling the experimental setting"
        ),
        ChatMessage(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
    )
}


@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    JetpackComposeDerivedStateOfTheme {
        Surface {
            MessageCard(ChatMessage("authoer1", "message1"))
        }
    }

}