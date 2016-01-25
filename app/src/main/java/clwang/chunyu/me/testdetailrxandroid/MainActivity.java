package clwang.chunyu.me.testdetailrxandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;

/**
 * 主Activity, 用于跳转各个模块.
 *
 * @author wangchenlong
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 跳转简单的页面
    public void gotoSimpleModule(View view) {
        startActivity(new Intent(this, SimpleActivity.class));
    }

    // 跳转复杂的页面
    public void gotoMoreModule(View view) {
        startActivity(new Intent(this, MoreActivity.class));
    }

    // 跳转Lambda的页面
    public void gotoLambdaModule(View view) {
        startActivity(new Intent(this, LambdaActivity.class));
    }

    // 跳转网络的页面
    public void gotoNetworkModule(View view) {
        startActivity(new Intent(this, NetworkActivity.class));
    }

    // 跳转线程安全的页面
    public void gotoSafeModule(View view) {
        startActivity(new Intent(this, SafeActivity.class));
    }

    // 跳转RxBinding的页面
    public void gotoBindingModule(View view) {
        startActivity(new Intent(this, BindingActivity.class));
    }
}
