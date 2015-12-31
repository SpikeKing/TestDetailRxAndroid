package clwang.chunyu.me.testdetailrxandroid.networks;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * GitHub的服务
 * <p>
 * Created by wangchenlong on 15/12/31.
 */
public interface GitHubService {
    String ENDPOINT = "https://api.github.com";

    // 获取个人信息
    @GET("/users/{user}")
    Observable<UserListAdapter.GitHubUser> getUserData(@Path("user") String user);

    // 获取库, 获取的是数组
    @GET("/users/{user}/repos")
    Observable<RepoListAdapter.GitHubRepo[]> getRepoData(@Path("user") String user);
}
