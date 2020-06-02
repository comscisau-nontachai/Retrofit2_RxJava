package com.becomedev.retrifit2_rxjava.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView

import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.becomedev.retrifit2_rxjava.R
import com.becomedev.retrifit2_rxjava.adapter.UsersAdapter
import com.becomedev.retrifit2_rxjava.models.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainView {

    val presenter : MainPresenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.hasFixedSize()
        recycler_view.itemAnimator = DefaultItemAnimator()

        search_view.setOnQueryTextListener(object: SearchView.OnQueryTextListener  {
            override fun onQueryTextSubmit(query: String?): Boolean {
                presenter.searchUser(query?:"")
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })



    }

    override fun setAdapterData(items: List<User>) {
        recycler_view.adapter = UsersAdapter(this,items)
    }
}
