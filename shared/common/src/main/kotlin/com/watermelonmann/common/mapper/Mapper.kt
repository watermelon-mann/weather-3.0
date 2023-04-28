package com.watermelonmann.common.mapper

interface Mapper<K, V> {
    fun map(from: K): V
    fun map(from: Iterable<K>): List<V> = from.map(::map)
}