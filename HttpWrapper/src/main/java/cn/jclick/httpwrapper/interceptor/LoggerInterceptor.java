package cn.jclick.httpwrapper.interceptor;

import com.jiongbull.jlog.JLog;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import cn.jclick.httpwrapper.callback.ResponseData;
import cn.jclick.httpwrapper.request.RequestParams;
import cn.jclick.httpwrapper.utils.WrapperUtils;

/**
 * Created by XuYingjian on 16/1/11.
 */
public class LoggerInterceptor implements HandlerInterceptor {

    private String TAG = getClass().getName();

    @Override
    public boolean preHandler(RequestParams params) {
        JLog.i(TAG, "Request start ! the bare url is " + WrapperUtils.getBareUrl(params));
        return true;
    }

    @Override
    public void postFailedHandler(IOException exception) {
        JLog.e("Request failed !", exception);
    }

    @Override
    public void postSuccessHandler(RequestParams params, int statusCode, Map<String, List<String>> headers) {
        JLog.i(TAG, "Request success !");
    }

    @Override
    public void afterCompletion(RequestParams params, ResponseData<String> responseData) {
        JLog.i(TAG, "Request process completion ! the url is " + WrapperUtils.getUrlWithQueryString(params)
                + "\n response data is :" + responseData);
        JLog.json(responseData.getData());
    }
}
