package pl.marchuck.parki.ui.trending

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import io.reactivex.Observable

class TrendingViewModel : ViewModel() {

    val trendingItems = ObservableField(emptyList<String>())
    val adapter = TrendingAdapter()

    val queryTextListener = object : android.support.v7.widget.SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String): Boolean {
            return false
        }

        override fun onQueryTextChange(newText: String): Boolean {
            println("on query text change : $newText")
            filterResults(newText)
            return false
        }
    }

    private fun filterResults(_newText: String) {
        val newText = _newText.trim()
        if (newText.isBlank()) {
            trendingItems.set(fakeDataSet)
            return
        }

        val results = Observable.defer { return@defer Observable.just(fakeDataSet) }
                .flatMapIterable { it }
                .filter { it.toLowerCase().startsWith(newText.toLowerCase()) }
                .toList()
                .blockingGet()

        trendingItems.set(results)
    }

    val fakeDataSet = arrayListOf(
            "A",
            "AB",
            "ABC",
            "ABCD",
            "ABCDE",
            "ABDEF",
            "ABDEFG",
            "ABDEFGH",
            "ABDEFGHI"
    )
}
