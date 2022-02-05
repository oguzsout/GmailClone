package com.oguzdogdu.gmailclone.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.oguzdogdu.gmailclone.R
import com.oguzdogdu.gmailclone.accountList
import com.oguzdogdu.gmailclone.model.Account
import com.oguzdogdu.gmailclone.ui.theme.CustomFont

@Composable
fun AccountsDialog(openDialog: MutableState<Boolean>) {
    Dialog(onDismissRequest = { openDialog.value = false }) {
        AccountsDialogUI()
    }
}

@Composable
fun AccountsDialogUI(modifier: Modifier = Modifier) {
    Card {
        Column(
            modifier = Modifier
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = ""
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.google), contentDescription = "",
                    modifier = Modifier
                        .size(30.dp)
                        .weight(2.0f)
                )

            }
            AccountItem(account = accountList[0])
            Row(
                modifier.fillMaxWidth(), horizontalArrangement =
                Arrangement.SpaceEvenly
            ) {
                Card(
                    modifier.requiredWidth(150.dp),
                    shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp, color = Color.Gray)
                ) {
                    Text(
                        text = "Google Account",
                        modifier.padding(8.dp),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier.width(10.dp))
            }
            Divider(modifier.padding(top = 16.dp))
        }
    }
}

@Composable
fun AccountItem(account: Account) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp)
    ) {
        if (account.icon != null) {
            Image(
                painter = painterResource(id = account.icon),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color = Color.Gray)
            )
        } else {
            Card(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(40.dp)
                    .clip(CircleShape),
                backgroundColor = Color.Gray
            ) {

                Text(
                    text = account.userName[0].toString(),
                    textAlign = TextAlign.Center, modifier = Modifier.padding(8.dp),
                    fontFamily = CustomFont
                )
            }
        }
        Column(
            modifier = Modifier
                .weight(2.0f)
                .padding(start = 16.dp, bottom = 16.dp)
        ) {
            Text(text = account.userName, fontWeight = FontWeight.SemiBold,fontFamily = CustomFont)
            Text(text = account.email,fontFamily = CustomFont)
        }

        Text(text = "${account.unReadMails}+", modifier = Modifier.padding(end = 16.dp),fontFamily = CustomFont)
    }
}

@Preview
@Composable
fun AccountsDialogUiPreview() {
    AccountsDialogUI()
}