package com.aleksodem.moneytor.mvp.presenters

import com.aleksodem.moneytor.R
import com.aleksodem.moneytor.mvp.models.Category
import com.aleksodem.moneytor.mvp.models.Cost
import com.aleksodem.moneytor.mvp.views.ExpensesView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import java.util.*

@InjectViewState
class ExpensesPresenter : MvpPresenter<ExpensesView>() {

    fun onExpensesLoad() {
        val expenses = ArrayList<Cost>()
        expenses.add(Cost("buy food", 150.0, Category("Home", R.drawable.home)))
        viewState.onExpensesLoad(expenses)
    }
}