package com.oguzdogdu.gmailclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.oguzdogdu.gmailclone.components.GmailDrawerMenu
import com.oguzdogdu.gmailclone.components.HomeAppBar
import com.oguzdogdu.gmailclone.components.HomeBottomMenu
import com.oguzdogdu.gmailclone.ui.theme.GmailCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GmailCloneTheme {
                Surface(color = MaterialTheme.colors.background) {
                    GmailApp()
                }
            }
        }
    }
}

@Composable
fun GmailApp() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()


    Scaffold(scaffoldState = scaffoldState,
        topBar = { HomeAppBar(scaffoldState, coroutineScope) },
        drawerContent = {
            GmailDrawerMenu(scrollState)
        },
        bottomBar = {
            HomeBottomMenu()
        }) {
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GmailCloneTheme {
        GmailApp()
    }
}