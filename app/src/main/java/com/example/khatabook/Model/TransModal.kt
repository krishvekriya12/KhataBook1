package com.example.khatabook.Model

class TransModal {

    var id = 0
    var amt = 0
    var category = ""
    var note = ""
    var extra = ""
    var isExpenses = 0

    constructor(
        id: Int,
        amt: Int,
        category: String,
        note: String,
        extra: String,
        isExpenses: Int
    ) {

        this.id = id
        this.amt = amt
        this.category = category
        this.note = note
        this.extra = extra
        this.isExpenses = isExpenses
    }
}