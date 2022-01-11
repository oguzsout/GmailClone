package com.oguzdogdu.gmailclone.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.oguzdogdu.gmailclone.R
import com.oguzdogdu.gmailclone.model.BottomMenuData
import com.oguzdogdu.gmailclone.ui.theme.CustomFont

@Composable
fun HomeBottomMenu() {
    val items = listOf(
        BottomMenuData.Mail,
        BottomMenuData.Meet
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.white),
        contentColor = colorResource(id = R.color.black)
    )
    {
        items.forEach {
            BottomNavigationItem(
                label = { Text(text = it.title, fontFamily = CustomFont) },
                alwaysShowLabel = true,
                selected = false,
                onClick = { },
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.title
                    )
                },
            )
        }
    }
}