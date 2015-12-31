package clwang.chunyu.me.testdetailrxandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.Bind;
import butterknife.ButterKnife;
import clwang.chunyu.me.testdetailrxandroid.networks.NetworkWrapper;
import clwang.chunyu.me.testdetailrxandroid.networks.RepoListAdapter;

/**
 * GitHub的库详细页面
 * <p>
 * Created by wangchenlong on 15/12/31.
 */
public class NetworkDetailActivity extends Activity {

    private static final String USER_KEY = "network_detail_activity.user";

    @Bind(R.id.network_rv_list) RecyclerView mRvList;

    public static Intent from(Context context, String username) {
        Intent intent = new Intent(context, NetworkDetailActivity.class);
        intent.putExtra(USER_KEY, username);
        return intent;
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        ButterKnife.bind(this);

        // 设置布局
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvList.setLayoutManager(manager);

        // 设置Adapter
        RepoListAdapter adapter = new RepoListAdapter();
        NetworkWrapper.getReposInfo(getIntent().getStringExtra(USER_KEY), adapter);
        mRvList.setAdapter(adapter);
    }
}
