package com.miarowski.f1grandprix;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class GrandPrixDetailFragment extends Fragment {
    private long grandprixId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grand_prix_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            GrandPrix grandPrix = GrandPrix.grandPrixes[(int) grandprixId];
            title.setText(grandPrix.getName());
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(grandPrix.getDescription());
        }
    }

    public void setGrandprix(long id){
        this.grandprixId = id;
    }
}