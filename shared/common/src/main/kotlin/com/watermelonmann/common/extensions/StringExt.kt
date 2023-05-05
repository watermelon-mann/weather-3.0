package com.watermelonmann.common.extensions

fun String.removeWhitespace() = trim().replace("\\s+".toRegex(), " ")