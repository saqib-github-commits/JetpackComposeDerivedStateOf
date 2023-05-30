package com.jetpackcompose.derivedstateof

import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.RowScopeInstance.weight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

@Composable
fun ConversationScreen() {
    val lazyListState = rememberLazyListState()
    val messages = SampleData.conversationSample

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = lazyListState
        ) {
            messages.map { item { MessageCard(it) } }
        }
        ScrollToTopBtnWithDerivedStateOf(lazyListState)
    }
}

@Composable
fun DerivedAndRememberedScrollToTop(lazyListState: LazyListState) {
    val isEnabledDerived by remember { derivedStateOf { lazyListState.firstVisibleItemIndex > 1 }}
    val isEnabledRemembered = remember(lazyListState.firstVisibleItemIndex) { lazyListState.firstVisibleItemIndex > 1}

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { /*TODO*/ }, enabled = isEnabledDerived) {
            Text(text = "Derived State Button")
        }

        Button(onClick = { /*TODO*/ }, enabled = isEnabledRemembered) {
            Text(text = "Remembered Button")
        }
    }
}

@Composable
fun ScrollToTopBtnWithoutDerivedStateOf(lazyListState: LazyListState) {
    val isEnabled = lazyListState.firstVisibleItemIndex > 1

    Button(onClick = { /*TODO*/ }, enabled = isEnabled) {
        Text(text = "Scroll To Top")
    }
}

@Composable
fun ScrollToTopBtnWithDerivedStateOf(lazyListState: LazyListState) {
    val isEnabled by remember { derivedStateOf {  lazyListState.firstVisibleItemIndex > 0 } }

    Button(onClick = { /*TODO*/ }, enabled = isEnabled) {
        Text(text = "Scroll To Top")
    }

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
        ChatMessage(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
        ChatMessage(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
        ChatMessage(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
        ChatMessage(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
        ChatMessage(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
        ChatMessage(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
        ChatMessage(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
        ChatMessage(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
        ChatMessage(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
        ChatMessage(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
        ChatMessage(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
        ChatMessage(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
        ChatMessage(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
        ChatMessage(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
        ChatMessage(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
        ChatMessage(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
        ChatMessage(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
        ChatMessage(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),

        )
}

