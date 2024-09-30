package ch13.ExtensionsOnPrimitiveTypes

import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration

val Int.days: Duration
    get() = this.toDuration(DurationUnit.DAYS)

val Int.hours: Duration
    get() = this.toDuration(DurationUnit.HOURS)
