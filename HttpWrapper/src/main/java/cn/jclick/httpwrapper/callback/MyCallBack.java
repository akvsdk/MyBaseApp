package cn.jclick.httpwrapper.callback;

import com.alibaba.fastjson.TypeReference;

/**
 * author   Joy
 * Date:  2016/3/10.
 * version:  V1.0
 * Description:
 */
public abstract class MyCallBack<T> extends ObjectCallback<T> {

    public MyCallBack() {

    }

    public MyCallBack(TypeReference<T> typeReference) {
        super(typeReference);
    }


    @Override
    protected void onResponse(ResponseData<T> responseData) {

        if (responseData.isSuccess() && responseData.isParseSuccess()) {

            T result = responseData.getData();
            onSuccess(result, responseData.isFromCache());

        } else {

            // Toast.makeText(context, responseData.getDescription(), Toast.LENGTH_SHORT).show();
        }
    }

    protected abstract void onSuccess(T result, boolean isCache);

}
