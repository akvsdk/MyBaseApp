package com.ep.joy.mybaseapp.http;


import com.ep.joy.mybaseapp.entity.News;
import com.ep.joy.mybaseapp.entity.Result;
import com.ep.joy.mybaseapp.entity.User;

import java.util.HashMap;
import java.util.Map;

import cn.jclick.httpwrapper.callback.MyBaseCallBack;
import cn.jclick.httpwrapper.callback.MyCallBack;
import cn.jclick.httpwrapper.request.BaseHttp;

/**
 * author   Joy
 * Date:  2016/2/14.
 * version:  V1.0
 * Description:
 */
public class AppDao {
    private static AppDao instance;


    public static synchronized AppDao getInstance() {
        if (instance == null) {
            instance = new AppDao();
        }
        return instance;
    }


    private AppDao() {
    }

    public Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        return map;
    }


    //    public void getNewsList(ObjectCallback<NewBrand>,String url) {
//        Map<String, String> map = createMap();
//        map.put("newsTypeVal", "CC");
//        RequestParams params = new RequestParams.Builder().requestParams(map).url(url).cacheMode(RequestConfig.HttpCacheMode.ALWAYS_CACHE).post().build();
//        HttpRequestAgent.getInstance().executeRequest(params, callback);
//        HttpRequestAgent.getInstance().(params, callback);
//        Http.post("url", map, listener);
//    }
    public void fuck(int num, MyCallBack<User> callback) {
        Map<String, String> map = createMap();
        String gank = "http://120.25.0.216/userfindmacth.json";
        map.put("pageNo", num + "");
        BaseHttp.post(gank, map, callback);
    }

    public void fuck(MyBaseCallBack<User> callback) {
        Map<String, String> map = createMap();
        String gank = "http://120.25.0.216/userfindmacth.json";
        map.put("pageNo", "1");
        BaseHttp.post(gank, map, callback);
    }

    public void getNews(MyCallBack<Result<News>> callback) {
        Map<String, String> map = createMap();
        String url = "http://222.177.210.200/supplier/news/getNewsList";
        map.put("newsTypeVal", "CC");
        map.put("page", "1");
        BaseHttp.post(url, map, callback);
    }


//    public void gankIo(int index, int page, ObjectCallback<List<GanHuo>> listener) {
//        String type = "all";
//        String gank = "http://gank.avosapps.com/api/data/" + "Android" + "/30/" + "1";
//        BaseHttp.get(gank, listener);
//    }
//
//    public void fuck(ObjectCallback<Gan> callback) {
//        Map<String, String> map = createMap();
//        String gank = "http://120.25.0.216/userfindmacth.json";
//        map.put("pageNo", "1");
//        BaseHttp.post(gank, map, callback);
//    }
//
//
//    public void news(String url, MyCallBack<MyJsonResult<Brand>> callback) {
//        Map<String, String> map = createMap();
//        map.put("newsTypeVal", "CC");
//        BaseHttp.post(url, map, callback);
//    }
//
//
//    public void Te(MyCallBack<Test> callback) {
//        String gank = "https://gank.io/api/data/Android/1/1";
//        BaseHttp.get(gank, callback);
//    }
//
//    public void fu(MyCallBack<DemoResultBean<Location>> callback) {
//        Map<String, String> map = createMap();
//        String gank = "http://ip.taobao.com/service/getIpInfo2.php";
//        map.put("ip", "221.217.176.144");
//
//        BaseHttp.post(gank, map, callback);
//    }

}


