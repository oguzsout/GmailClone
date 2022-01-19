package com.oguzdogdu.gmailclone.components

import androidx.compose.foundation.ScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.oguzdogdu.gmailclone.ui.theme.CustomFont

@Composable
fun GmailFab(scrollState: ScrollState) {
    if (scrollState.value > 100) {
        ExtendedFloatingActionButton(
            text = {
                Text(
                    text = "Compose",
                    fontFamily= CustomFont,
                    fontSize = 16.sp
                )
            },
            onClick = {},
            icon = {
                Icon(imageVector = Icons.Default.Edit, "")
            },
            backgroundColor = MaterialTheme.colors.surface,
        )

    } else {
        //Todo 2: add a floating action button
        FloatingActionButton(
            onClick = {},
            backgroundColor = MaterialTheme.colors.surface,
        ) {
            Icon(imageVector = Icons.Default.Edit, "")
        }
    }

}