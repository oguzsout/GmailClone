package com.oguzdogdu.gmailclone.model

data class Account(
    val icon: Int? = null,
    val userName: String,
    val email: String,
    val unReadMails: Int
)
