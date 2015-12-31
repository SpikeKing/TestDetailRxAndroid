package clwang.chunyu.me.testdetailrxandroid.networks;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 用户获取类
 * <p>
 * Created by wangchenlong on 15/12/31.
 */
public class NetworkWrapper {
    private static final String[] mFamousUsers =
            {"SpikeKing", "JakeWharton", "rock3r", "Takhion", "dextorer", "Mariuxtheone"};

    // 获取用户信息
    public static void getUsersInto(final UserListAdapter adapter) {
        GitHubService gitHubService =
                ServiceFactory.createServiceFrom(GitHubService.class, GitHubService.ENDPOINT);

        Observable.from(mFamousUsers)
                .flatMap(gitHubService::getUserData)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(adapter::addUser);
    }

    // 获取库信息
    public static void getReposInfo(final String username, final RepoListAdapter adapter) {
        GitHubService gitHubService =
                ServiceFactory.createServiceFrom(GitHubService.class, GitHubService.ENDPOINT);

        gitHubService.getRepoData(username)
                .flatMap(Observable::from)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(adapter::addRepo);
    }
}
