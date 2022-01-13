package com.oguzdogdu.gmailclone.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oguzdogdu.gmailclone.model.MailData
import com.oguzdogdu.gmailclone.ui.theme.CustomFont

@Composable
fun MailList(padding: PaddingValues) {

}

@Composable
fun MailItem(mailData: MailData, modifier: Modifier = Modifier) {
    Row {
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
                fontWeight = FontWeight.Bold
            )
            Text(
                text = mailData.subject,
                fontSize = 15.sp,
                fontFamily = CustomFont,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = mailData.body,
                fontFamily = CustomFont,
                fontSize = 14.sp
            )
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
