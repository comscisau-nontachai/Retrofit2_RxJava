package com.becomedev.retrifit2_rxjava.ui

import com.becomedev.retrifit2_rxjava.models.User

interface MainView {
    fun setAdapterData(items:List<User>)
}