package com.example.android.gymondoautomationtest.helpers

import androidx.recyclerview.widget.RecyclerView
import java.util.concurrent.CountDownLatch

class CustomAdapterDataObserver: RecyclerView.AdapterDataObserver() {

    val latch = CountDownLatch(1)

    override fun onChanged() {
        super.onChanged()

        latch.countDown()
    }

}
