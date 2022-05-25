package com.miarowski.f1grandprix;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_GRANDPRIX_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        GrandPrixDetailFragment frag = (GrandPrixDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_frag);

        int grandPrixId = (int) getIntent().getExtras().get(EXTRA_GRANDPRIX_ID);
        frag.setGrandprix(grandPrixId);
    }
}