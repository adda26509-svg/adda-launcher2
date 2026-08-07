package com.adda.launcher.utils.logging

private fun Any.tagName(): String = this::class.simpleName ?: "Unknown"

fun Any.lError(msg: String, t: Throwable? = null) = Logger.error(tagName(), msg, t)
fun Any.lWarning(msg: String, t: Throwable? = null) = Logger.warning(tagName(), msg, t)
fun Any.lInfo(msg: String, t: Throwable? = null) = Logger.info(tagName(), msg, t)
fun Any.lDebug(msg: String, t: Throwable? = null) = Logger.debug(tagName(), msg, t)
