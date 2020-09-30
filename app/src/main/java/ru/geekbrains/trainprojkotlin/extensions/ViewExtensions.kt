package ru.geekbrains.trainprojkotlin.extensions

import android.view.View

inline fun View.dip(value: Int) = context.dip(value)

