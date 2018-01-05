package com.lw.headlinenews.module.news.content;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lw.commonUtils.StringUtils;
import com.lw.headlinenews.R;
import com.lw.headlinenews.base.BaseFragment;
import com.lw.headlinenews.bean.NewsArticleParcelableBean;

/**
 * Created by lw on 17-12-20.
 */

public class NewsContentFragment extends BaseFragment<NewsContentContact.View, NewsContentPresenter> implements NewsContentContact.View {

    private static String TAG = "NewsContentFragment";
    private WebView webView;
    private Toolbar toolBar;
    private String shareUrl;

    public static NewsContentFragment getInstance(NewsArticleParcelableBean bean) {
        NewsContentFragment fragment = new NewsContentFragment();
        Bundle args = new Bundle();
        args.putParcelable(TAG, bean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int attachLayoutId() {
        return R.layout.news_detail_fragment;
    }

    @Override
    protected NewsContentPresenter createPresenter() {
        return new NewsContentPresenter();
    }

    @Override
    protected void initView(View view) {
        webView = view.findViewById(R.id.webView);
        toolBar = view.findViewById(R.id.toolbar);
        setHasOptionsMenu(true); //must set, for set listener onOptionsItemSelected.
        initToolBar(toolBar, true, getResources().getString(R.string.news));
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebClient() {
        final WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        // 缩放,设置为不能缩放可以防止页面上出现放大和缩小的图标
        settings.setBuiltInZoomControls(false);
        // 缓存
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        // 开启DOM storage API功能
        settings.setDomStorageEnabled(true);
        // 缩放至屏幕的大小
        settings.setLoadWithOverviewMode(true);
        // 开启application Cache功能
        settings.setAppCacheEnabled(true);
        // 判断是否为无图模式
        settings.setBlockNetworkImage(true);//暂时设为无图模式
        settings.setLoadsImagesAutomatically(false);

        // 不调用第三方浏览器即可进行页面反应
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (!StringUtils.isNullOrEmpty(url)) {
                    view.loadUrl(url);
                }
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                settings.setBlockNetworkImage(false);
                settings.setLoadsImagesAutomatically(true);
                super.onPageFinished(view, url);
            }
        });

        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                hideLoadingProgress();
                if ((keyEvent.getKeyCode() == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
                    webView.goBack();
                    return true;
                }
                return false;
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                toolBar.setTitle(title);
                super.onReceivedTitle(view, title);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        });
    }

    @Override
    protected void initData() throws NullPointerException {
        Bundle bundle = getArguments();
        NewsArticleParcelableBean parcelable = bundle.getParcelable(TAG);
        shareUrl = parcelable.getShareUrl();
        initWebClient();
        presenter.doLoadData(parcelable.getDisplayUrl());
        showLoadingProgress(getString(R.string.loading));
    }

    @Override
    public void onStop() {
        clearWebView();
        super.onStop();
    }

    private void clearWebView() {
        if (webView != null) {
            webView.getSettings().setJavaScriptEnabled(false);
            webView.clearHistory();
            ((ViewGroup) webView.getParent()).removeView(webView);
            webView.destroy();
            webView = null;
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    getActivity().onBackPressed();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void setWebViewContent(String url, boolean isText) {
        hideLoadingProgress();
        if (isText) {
            webView.loadDataWithBaseURL(null, url, "text/html", "utf-8", null);
        } else {
            webView.loadUrl(shareUrl);
        }
    }

}
