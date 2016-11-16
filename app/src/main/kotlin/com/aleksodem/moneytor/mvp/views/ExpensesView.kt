package com.aleksodem.moneytor.mvp.views

import com.aleksodem.moneytor.mvp.models.Cost
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface ExpensesView : MvpView {

    fun onExpensesLoad(expenses : List<Cost>)

}