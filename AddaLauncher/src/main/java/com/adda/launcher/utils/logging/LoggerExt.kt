package com.adda.launcher.utils.logging

private const val DEFAULT_TAG = "AppLog"

fun lError(msg: String, t: Throwable? = null) = Logger.error(DEFAULT_TAG, msg, t)
fun lWarning(msg: String, t: Throwable? = null) = Logger.warning(DEFAULT_TAG, msg, t)
fun lInfo(msg: String, t: Throwable? = null) = Logger.info(DEFAULT_TAG, msg, t)
fun lDebug(msg: String, t: Throwable? = null) = Logger.debug(DEFAULT_TAG, msg, t)
