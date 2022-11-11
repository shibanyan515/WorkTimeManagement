package com.example.worktimemanagement

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class WorkTime: RealmObject() {
    @PrimaryKey
    var id: Long = 0
    var date: Date = Date()
    var attendance: Date? = Date()
    var leaving: Date? = Date()
    var workTime: String = ""
}