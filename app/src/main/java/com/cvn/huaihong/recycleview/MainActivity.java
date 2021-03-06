package com.cvn.huaihong.recycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;


public class MainActivity extends AppCompatActivity implements Adapter.IonSlidingViewClickListener {
    private final String TAG = "test";
    private SlidingMenu mSlidingMenu;
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setAdapter();

    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
    }

    private void setAdapter() {

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter = new Adapter(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }


    @Override
    public void onItemClick(View view, int position) {
        Log.i(TAG, "����" + position);
    }

    @Override
    public void onDeleteBtnClick(View view, int position) {
        Log.i(TAG, "ɾ���" + position);
        mAdapter.removeData(position);
    }

    @Override
    public void onModifyBtnClick(View view, int position) {
        Log.i(TAG, "ɾ���" + position);
        mAdapter.modifyData(position, ++position);
    }
}
