package com.example.android.gymondoautomationtest.helpers

import com.example.android.gymondoautomationtest.ListActivity
import kotlinx.android.synthetic.main.activity_list.*
import java.util.concurrent.TimeUnit

class SearchScreenExercises(activity: ListActivity) {

    private val activity: ListActivity = activity

    @Throws(RuntimeException::class)
    fun getRandomExercise(timeout: Long = 10, unit: TimeUnit = TimeUnit.SECONDS): String {

        val observer = CustomAdapterDataObserver()
        activity.recycler_view.adapter?.registerAdapterDataObserver(observer)

        try {
            observer.latch.await(timeout, unit)
        } catch (e: RuntimeException) {
            throw RuntimeException("Wasn't able to get list of exercises in reasonable time: $timeout $unit")
        }

        return activity.getListOfExercises().random()
    }

}
