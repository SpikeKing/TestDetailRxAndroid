package clwang.chunyu.me.testdetailrxandroid.networks;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import clwang.chunyu.me.testdetailrxandroid.R;

/**
 * 库的适配器
 * <p>
 * Created by wangchenlong on 15/12/31.
 */
public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.RepoViewHolder> {

    private ArrayList<GitHubRepo> mGitHubRepos;

    public RepoListAdapter() {
        mGitHubRepos = new ArrayList<>();
    }

    public void addRepo(GitHubRepo gitHubRepo) {
        mGitHubRepos.add(gitHubRepo);
        notifyItemInserted(mGitHubRepos.size() - 1);
    }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_network_repo, parent, false);
        return new RepoViewHolder(view);
    }

    @Override public void onBindViewHolder(RepoViewHolder holder, int position) {
        holder.bindTo(mGitHubRepos.get(position));
    }

    @Override public int getItemCount() {
        return mGitHubRepos.size();
    }

    public static class RepoViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.network_item_iv_repo_name) TextView mIvRepoName;
        @Bind(R.id.network_item_iv_repo_detail) TextView mIvRepoDetail;

        public RepoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindTo(GitHubRepo gitHubRepo) {
            mIvRepoName.setText(gitHubRepo.name);
            mIvRepoDetail.setText(
                    String.valueOf("description: " + gitHubRepo.description
                            + ", language: " + gitHubRepo.language));
        }
    }

    public static class GitHubRepo {
        public String name; // 库的名字
        public String description; // 描述
        public String language; // 语言
    }


}
