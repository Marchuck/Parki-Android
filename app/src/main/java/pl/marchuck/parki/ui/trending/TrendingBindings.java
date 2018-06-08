package pl.marchuck.parki.ui.trending;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class TrendingBindings {

    @BindingAdapter("android:queryTextListener")
    public static void queryTextListener(android.support.v7.widget.SearchView view, TrendingViewModel viewModel) {
        view.setOnQueryTextListener(viewModel.getQueryTextListener());
    }

    @BindingAdapter("android:recyclerViewSetup")
    public static void recyclerViewSetup(RecyclerView view, TrendingViewModel viewModel) {

        view.setLayoutManager(new LinearLayoutManager(view.getContext()));
        view.setAdapter(viewModel.getAdapter());
    }

    @BindingAdapter("android:trendingItems")
    public static void setTrendingItems(RecyclerView view, List<String> items) {
        TrendingAdapter adapter = ((TrendingAdapter) view.getAdapter());
        if (adapter != null) {
            adapter.refreshDataset(items);
        }
    }
}
