package clwang.chunyu.me.testdetailrxandroid;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Rx的线程安全
 * <p>
 * Created by wangchenlong on 15/12/31.
 */
public class SafeActivity extends RxAppCompatActivity {
    private static final String TAG = "DEBUG-WCL: " + SafeActivity.class.getSimpleName();

    @Bind(R.id.simple_tv_text) TextView mTvText;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        ButterKnife.bind(this);

        Observable.interval(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .compose(bindToLifecycle()) // 管理生命周期, 防止内存泄露
                .subscribe(this::showTime);
    }

    private void showTime(Long time) {
        mTvText.setText(String.valueOf("时间计数: " + time));
        Log.d(TAG, "时间计数器: " + time);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG, "页面关闭!");
    }
}
