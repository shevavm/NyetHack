package com.bignerdranch.nyethack.extensions


fun <T> Iterable<T>.random(): T = this.shuffled().first()//18.11, 18.13