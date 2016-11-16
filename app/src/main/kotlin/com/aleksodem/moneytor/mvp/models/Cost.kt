package com.aleksodem.moneytor.mvp.models

import org.joda.time.DateTime

class Cost {

    val date: DateTime
    val note: String
    val value: Double
    val category: Category

    constructor(note: String, value: Double, category: Category) {
        date = DateTime.now()
        this.note = note
        this.value = value
        this.category = category
    }
}