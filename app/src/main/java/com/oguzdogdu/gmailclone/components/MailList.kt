package com.oguzdogdu.gmailclone.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oguzdogdu.gmailclone.mailList
import com.oguzdogdu.gmailclone.model.MailData
import com.oguzdogdu.gmailclone.ui.theme.CustomFont

@Composable
fun MailList(padding: PaddingValues,scrollState: ScrollState) {
    Box(modifier = Modifier.padding(padding)) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .scrollable(scrollState, Orientation.Vertical)
        ) {
            items(mailList) { mailData ->
                MailItem(mailData = mailData)
            }
        }
    }
}

@Composable
fun MailItem(mailData: MailData, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        Card(
            modifier = modifier
                .padding(end = 8.dp)
                .size(40.dp)
                .clip(CircleShape),
            backgroundColor = Color.Gray
        ) {
            Text(
                text = mailData.userName[0].toString(),
                textAlign = TextAlign.Center,
                modifier = modifier.padding(8.dp)
            )

        }
        Column(modifier.weight(2.0f)) {
            Text(
                text = mailData.userName,
                fontSize = 18.sp,
                fontFamily = CustomFont,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = mailData.subject,
                fontSize = 15.sp,
                fontFamily = CustomFont,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = mailData.body,
                fontFamily = CustomFont,
                fontSize = 14.sp
            )
        }
        Column {
            Text(text = mailData.timeStamp)
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(50.dp)
                    .padding(top = 16.dp)

            ) {
                Icon(imageVector = Icons.Outlined.StarOutline, "")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MailItemPreview() {
    MailItem(
        mailData = MailData(
            mailId = 4,
            userName = "Angelo",
            subject = "Email regarding job opportunity",
            body = "This is regarding a job opportunity for the profile or android developer in our organisation.",
            timeStamp = "21:10"
        )
    )
}
