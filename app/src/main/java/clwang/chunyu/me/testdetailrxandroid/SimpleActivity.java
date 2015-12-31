package clwang.chunyu.me.testdetailrxandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * RxJava的基础讲解, 包含一个观察者(Observable), 两个订阅者(Subscriber).
 * <p>
 * Created by wangchenlong on 15/12/30.
 */
public class SimpleActivity extends Activity {

    @Bind(R.id.simple_tv_text) TextView mTvText;

    // 观察事件发生
    private Observable.OnSubscribe mObservableAction = new Observable.OnSubscribe<String>() {
        @Override public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext(sayMyName()); // 发送事件
            subscriber.onCompleted(); // 完成事件
        }
    };

    // 订阅者, 接收字符串, 修改控件
    private Subscriber<String> mTextSubscriber = new Subscriber<String>() {
        @Override public void onCompleted() {

        }

        @Override public void onError(Throwable e) {

        }

        @Override public void onNext(String s) {
            mTvText.setText(s); // 设置文字
        }
    };

    // 订阅者, 接收字符串, 提示信息
    private Subscriber<String> mToastSubscriber = new Subscriber<String>() {
        @Override public void onCompleted() {

        }

        @Override public void onError(Throwable e) {

        }

        @Override public void onNext(String s) {
            Toast.makeText(SimpleActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    };

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        ButterKnife.bind(this);

        // 注册观察活动
        @SuppressWarnings("unchecked")
        Observable<String> observable = Observable.create(mObservableAction);

        // 分发订阅信息
        observable.observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(mTextSubscriber);
        observable.subscribe(mToastSubscriber);
    }

    // 创建字符串
    private String sayMyName() {
        return "Hello, I am your friend, Spike!";
    }
}
