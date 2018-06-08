package pl.marchuck.parki.ui.trending

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pl.marchuck.parki.R

class TrendingAdapter : RecyclerView.Adapter<TrendingViewHolder>() {

    var dataset = emptyList<String>()

    fun refreshDataset(set: List<String>) {
        dataset = set
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_trending, parent, false)
        return TrendingViewHolder(view)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        val item = dataset[position]
        holder.bind(item)
    }
}