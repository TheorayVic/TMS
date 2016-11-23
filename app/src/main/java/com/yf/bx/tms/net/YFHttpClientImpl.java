package com.yf.bx.tms.net;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;

import org.apache.commons.httpclient.HttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.util.List;


/**
 * Created by bai on 2016/10/31.
 */
public class YFHttpClientImpl implements YFHttpClient {
    private static final String TAG = "YFHttpClient";
    private static YFHttpClientImpl sYFHttpClient;
    private String mDeviceInfo;

    // 计算图片的缩放值
    public static int calculateInSampleSize(BitmapFactory.Options options,
                                            int reqWidth, int reqHeight) {
        final int height = options.outHeight;// 获取图片的高
        final int width = options.outWidth;// 获取图片的框
        int inSampleSize = 4;
        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height
                    / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;// 求出缩放值
    }

    private YFHttpClientImpl() {

    }

    public static YFHttpClientImpl getInstance() {
        if (sYFHttpClient == null) {
            sYFHttpClient = new YFHttpClientImpl();
        }
        return sYFHttpClient;
    }

    private Context mContext;

    /**
     * 获取渠道名
     *
     * @param ctx 此处习惯性的设置为activity，实际上context就可以
     * @return 如果没有获取成功，那么返回值为空
     */
    public static String getChannelName(Context ctx) {
        if (ctx == null) {
            return null;
        }
        String channelName = null;
        try {
            PackageManager packageManager = ctx.getPackageManager();
            if (packageManager != null) {
                //注意此处为ApplicationInfo 而不是 ActivityInfo,因为友盟设置的meta-data是在application标签中，而不是某activity标签中，所以用ApplicationInfo
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(ctx.getPackageName(), PackageManager.GET_META_DATA);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
                        channelName = applicationInfo.metaData.getString("UMENG_CHANNEL");
                    }
                }

            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return channelName;
    }

    public void init(Context context) {
        mContext = context;
    }

    public void setToken(String token) {
        this.token = token;
    }

    String token;

    private RequestParams getBaseParams(Context context, String function) {
        RequestParams params = new RequestParams(function);
        if (!TextUtils.isEmpty(token)) {
            params.setHeader("X-YF-Token", token);
        }
        return params;

    }

    @Override
    public void getResortsCategory(Context context, YFAjaxCallBack callBack) {
        RequestParams requestParams = getBaseParams(context, URL_SCENIC_TYPES);
        x.http().post(requestParams, new YFAjaxCallBackHolder(context, URL_SCENIC_TYPES, callBack));
    }

    @Override
    public void getResortsList(Context context, String keyword, int skip, int max, int resortsType, YFAjaxCallBack callBack) {
        RequestParams requestParams = getBaseParams(context, URL_SCENIC_LIST);
        requestParams.addBodyParameter("startIndex", String.valueOf(skip));
        requestParams.addBodyParameter("pageMaxCount", String.valueOf(max));
        if (!TextUtils.isEmpty(keyword)) {
            requestParams.addBodyParameter("searchText", keyword);
        }
        if (resortsType != -1) {
            requestParams.addBodyParameter("typeId", String.valueOf(resortsType));
        }
        x.http().post(requestParams, new YFAjaxCallBackHolder(context, URL_SCENIC_LIST, callBack));
    }

    @Override
    public void getResortsListWithTicket(Context context, String keyword, int skip, int max, int resortsType, YFAjaxCallBack callBack) {
        RequestParams requestParams = getBaseParams(context, URL_GET_RESORT_LISTT_WITH_TICKET);
        requestParams.addBodyParameter("startIndex", String.valueOf(skip));
        requestParams.addBodyParameter("pageMaxCount", String.valueOf(max));
        if (!TextUtils.isEmpty(keyword)) {
            requestParams.addBodyParameter("searchText", keyword);
        }
        if (resortsType != -1) {
            requestParams.addBodyParameter("typeId", String.valueOf(resortsType));
        }
        x.http().post(requestParams, new YFAjaxCallBackHolder(context, URL_GET_RESORT_LISTT_WITH_TICKET, callBack));

    }

    @Override
    public void getResortsBusinessType(Context context, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_BUSINESS_TYPES);
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_BUSINESS_TYPES, callBack));
    }

    @Override
    public void getResortsBusiness(Context context, int skip, int max, int businessType, double lat, double lng, int range, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_BUSINESS_LIST);
        params.addBodyParameter("startIndex", String.valueOf(skip));
        params.addBodyParameter("pageMaxCount", String.valueOf(max));
        params.addBodyParameter("businessType", String.valueOf(businessType));
        params.addBodyParameter("lat", String.valueOf(lat));
        params.addBodyParameter("lng", String.valueOf(lng));
        params.addBodyParameter("range", String.valueOf(range));
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_BUSINESS_LIST, callBack));
    }

    @Override
    public void getCommunityList(Context context, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_COMMUNITY_LIST);
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_COMMUNITY_LIST, callBack));
    }

    @Override
    public void sendCode(Context context, String phoneNumber, String tag, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_SEND_CODE);
        params.addBodyParameter("phoneNumber", phoneNumber);
        params.addBodyParameter("tag", tag);
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_SEND_CODE, callBack));
    }

    @Override
    public void registered(Context context, String phoneNumber, String code, String password, YFAjaxCallBack callBack) {

    }

    @Override
    public void registered(Context context, String phoneNumber, String code, String password, int communityId, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_REGISTERED);
        params.addBodyParameter("phoneNumber", phoneNumber);
        params.addBodyParameter("code", code);
        params.addBodyParameter("pass", password);
        params.addBodyParameter("communityId", String.valueOf(communityId));
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_REGISTERED, callBack));
    }

    @Override
    public void getResortsTicket(Context context, int mResortsId, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_SCENIC_TICKET_LIST);
        params.addBodyParameter("scenicId", String.valueOf(mResortsId));
        Log.i(TAG, "getResortsTicket: " + mResortsId);
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_SCENIC_TICKET_LIST, callBack));
    }

    @Override
    public void getResortsCommentList(Context context, int mResortsId, int skip, int max, YFAjaxCallBack callBack) {
        RequestParams requestParams = getBaseParams(context, URL_SCENIC_COMMENT_LIST);
        requestParams.addBodyParameter("startIndex", String.valueOf(skip));
        requestParams.addBodyParameter("pageMaxCount", String.valueOf(max));
        requestParams.addBodyParameter("scenicId", String.valueOf(mResortsId));
        x.http().post(requestParams, new YFAjaxCallBackHolder(context, URL_SCENIC_COMMENT_LIST,
                callBack));
    }

    @Override
    public void getToken(Context context, String userName, String password, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_GET_TOKEN);
        params.addBodyParameter("UserName", userName);
        params.addBodyParameter("Passwd", password);
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_GET_TOKEN, callBack));

    }

    @Override
    public void getEventList(Context context, String serchText, int skip, int max, int type, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_SCENIC_EVENT_LIST);
        params.addBodyParameter("pageMaxCount", String.valueOf(max));
        params.addBodyParameter("startIndex", String.valueOf(skip));
        if (!TextUtils.isEmpty(serchText)) {
            params.addBodyParameter("searchText", serchText);
        }
        if (type != -1) {
            params.addBodyParameter("type", String.valueOf(type));
        }
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_SCENIC_EVENT_LIST, callBack));
    }

    @Override
    public void getCouponsList(Context context, int startIndex, int pageMaxCount, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_GET_COUPONS_LIST);
        params.addBodyParameter("startIndex", String.valueOf(startIndex));
        params.addBodyParameter("pageMaxCount", String.valueOf(pageMaxCount));
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_GET_COUPONS_LIST, callBack));
    }

    @Override
    public void getMyAddressList(Context context, int startIndex, int pageMaxCount, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_GET_ADDRESS_LIST);
        params.addBodyParameter("startIndex", startIndex + "");
        params.addBodyParameter("pageMaxCount", pageMaxCount + "");
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_GET_ADDRESS_LIST, callBack));
    }

 //   @Override
//    public void submitOrder(Context context, YFAjaxCallBack callBack) {
//        RequestParams params = getBaseParams(context, URL_SUBMIT_ORDER);
//        JSONObject jsonObject = new JSONObject();
//        ShopCarManager shopCarManager = ShopCarManager.getInstance();
//        try {
//            jsonObject.put("isEticket", shopCarManager.getTicketType());
//            jsonObject.put("totalPrice", shopCarManager.getFinalPrice());
//            if (shopCarManager.getCurrentCouponData() != null) {
//                jsonObject.put("couponsId", shopCarManager.getCurrentCouponData().getId());
//            }
//            Address address = shopCarManager.getCurrentAddress();
//            if (address != null) {
//                JSONObject jsonAddress = new JSONObject();
//                jsonAddress.put("recvAddress", address.getRecvAddress());
//                jsonAddress.put("recvPhone", address.getRecvPhone());
//                jsonAddress.put("recvName", address.getRecvName());
//                jsonObject.put("address", jsonAddress);
//            }
////            jsonObject.put("note", shopCarManager.getTicketType());
//            List<OrderSubmitting.OrderItem> list = shopCarManager.getOrderItems();
//            JSONArray jsonArray = new JSONArray();
//            for (OrderSubmitting.OrderItem o : list) {
//                if (o.getBuyNum() == 0) {
//                    continue;
//                }
//                JSONObject js = new JSONObject();
////                js.put("price", shopCarManager.getMoney(o));
//                js.put("price", o.getPrice());
//                js.put("buyNum", o.getBuyNum());
//                js.put("ticketId", o.getTicketId());
//                js.put("orderType", o.getOrderType());
//                jsonArray.put(js);
////                js.put("activityId",o.getPrice());
////                js.put("note",o.getPrice());
//            }
//            jsonObject.put("orderItemList", jsonArray);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        params.setBodyContent(jsonObject.toString());
//        Log.i(TAG, "submitOrder: " + jsonObject.toString());
//        x.http().post(params, new YFAjaxCallBackHolder(context, URL_SUBMIT_ORDER, callBack));
//    }

//    @Override
//    public void submitComment(Context context, int resortsId, String content, List<AddCommentForResortsActivity.ImageFile> imgs, YFAjaxCallBack callBack) {
//        RequestParams params = getBaseParams(context, URL_SUBMIT_COMMENT);
//        params.addBodyParameter("scenicId", String.valueOf(resortsId));
//        params.addBodyParameter("content", content);
//        if (imgs != null && !imgs.isEmpty()) {
//            StringBuilder b = new StringBuilder();
//            for (int i = 0; i < imgs.size(); i++) {
//                String url = imgs.get(i).url;
//                if (!TextUtils.isEmpty(url)) {
//                    b.append(url);
//                    b.append(";");
//                }
//            }
//            if (b.length() > 1) {
//                b.deleteCharAt(b.length() - 1);
//            }
//            params.addBodyParameter("img", b.toString());
//        }
//        x.http().post(params, new YFAjaxCallBackHolder(context, URL_SUBMIT_COMMENT, callBack));
//    }

    @Override
    public void getMyOrderList(Context context, int skip, int max, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_GET_MY_ORDER_LIST);
        params.addBodyParameter("startIndex", String.valueOf(skip));
        params.addBodyParameter("pageMaxCount", String.valueOf(max));
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_GET_MY_ORDER_LIST, callBack));
    }


    @Override
    public void resetPasswoed(Context context, String phoneNumber, String password, String code, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_RESET_PASSWORD);
        params.addBodyParameter("phoneNumber", phoneNumber);
        params.addBodyParameter("code", code);
        params.addBodyParameter("pass", password);
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_RESET_PASSWORD, callBack));
    }

    @Override
    public void getUserInfo(Context context, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_USER_INFO);
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_USER_INFO, callBack));
    }

    @Override
    public void changePassword(Context context, String newPassword, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_CHANGE_PASSWORD);
        params.addBodyParameter("newPass", newPassword);
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_CHANGE_PASSWORD, callBack));
    }

    @Override
    public void changeUserInfo(Context context, String userName, String userPhoto, String sex, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_CHANGE_USER_INFO);
        params.addBodyParameter("userName", userName);
        params.addBodyParameter("userPhoto", userPhoto);
        params.addBodyParameter("sex", sex);

        x.http().post(params, new YFAjaxCallBackHolder(context, URL_CHANGE_USER_INFO, callBack));
    }


    @Override
    public void addAddress(Context context, String recvName, String recvPhone, String recvAddress,
                           int isDefault, String recvAdministrative, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_ADD_ADDRESS);
        params.addBodyParameter("recvName", recvName);
        params.addBodyParameter("recvPhone", recvPhone);
        params.addBodyParameter("recvAddress", recvAddress);
        params.addBodyParameter("recvAdministrative", recvAdministrative);
        params.addBodyParameter("isDefault", String.valueOf(isDefault));
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_ADD_ADDRESS, callBack));
    }

    @Override
    public void editAddress(Context context, int id, String recvName, String recvPhone, String recvAddress,
                            int isDefault, String recvAdministrative, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_EDIT_ADDRESS);
        params.addBodyParameter("id", String.valueOf(id));
        params.addBodyParameter("recvName", recvName);
        params.addBodyParameter("recvPhone", recvPhone);
        params.addBodyParameter("recvAddress", recvAddress);
        params.addBodyParameter("isDefault", String.valueOf(isDefault));
        params.addBodyParameter("recvAdministrative", recvAdministrative);
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_EDIT_ADDRESS, callBack));
    }

    @Override
    public void setAddressDefault(Context context, int addressId, int isDefault, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_DEFAULT_ADDRESS);
        params.addBodyParameter("addressId", String.valueOf(addressId));
        params.addBodyParameter("isDefault", String.valueOf(isDefault));
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_DEFAULT_ADDRESS, callBack));
    }

    @Override
    public void deleteAddress(Context context, int addressId, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_DELETE_ADDRESS);
        params.addBodyParameter("addressId", String.valueOf(addressId));
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_DEFAULT_ADDRESS, callBack));
    }

    @Override
    public void uploadFile(Context context, String filePath, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_UPLOAD_FILE);
        params.addBodyParameter("data", new File(filePath));
        params.setMultipart(true);
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_UPLOAD_FILE, callBack));
    }

    @Override
    public void globalSearch(Context context, int skip, int max, String searchText, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_GLOBAL_SEARCH);
//        params.addBodyParameter("pageMaxCount", String.valueOf(max));
//        params.addBodyParameter("startIndex", String.valueOf(skip));
        params.addBodyParameter("searchText", String.valueOf(searchText));
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_GLOBAL_SEARCH, callBack));
    }

    @Override
    public void getHotKeyword(Context context, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_HOT_SEARCH);
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_HOT_SEARCH, callBack));
    }

//    @Override
//    public void getPrepayId(Context context, String orderNo, double finalPrice, YFAjaxCallBack callBack) {
//        RequestParams params = getBaseParams(context, URL_WECHAT_PREPAY_ID);
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("appid", WechatPayUtils.APP_ID);
//            jsonObject.put("attach", "老家河南支付订单");
//            jsonObject.put("body", "老家河南支付订单");
//            jsonObject.put("mch_id", WechatPayUtils.PARTNER_ID);
//            jsonObject.put("out_trade_no", orderNo);
//            jsonObject.put("notify_url", URL_ALIPAY_NOTIFY);
//            jsonObject.put("total_fee", finalPrice);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        Log.i(TAG, "getPrepayId: " + jsonObject.toString());
//        params.setBodyContent(jsonObject.toString());
//        x.http().post(params, new YFAjaxCallBackHolder(context, URL_WECHAT_PREPAY_ID, callBack));
//
//    }

    @Override
    public void addActivityReadNum(Context context, int activityId, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_GET_ADD_ACTIVITY_READ_NUM);
        params.addBodyParameter("activityId", String.valueOf(activityId));
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_GET_ADD_ACTIVITY_READ_NUM, callBack));
    }

    @Override
    public void addScenicReadNum(Context context, int scenicId, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_GET_ADD_SCENIC_READ_NUM);
        params.addBodyParameter("scenicId", String.valueOf(scenicId));
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_GET_ADD_SCENIC_READ_NUM, callBack));
    }

    @Override
    public void cancelOrder(Context context, int id, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_CANCEL_ORDER);
        params.addBodyParameter("orderId", String.valueOf(id));
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_CANCEL_ORDER, callBack));
    }

    @Override
    public void getMyCommentList(Context context, int commentStatus, int skip, int max, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_MY_COMMENT_LIST);
        params.addBodyParameter("pageMaxCount", String.valueOf(max));
        params.addBodyParameter("startIndex", String.valueOf(skip));
        params.addBodyParameter("approved", String.valueOf(commentStatus));
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_MY_COMMENT_LIST, callBack));
    }

    @Override
    public void canAddCommentToResorts(Context context, int id, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_CAN_ADD_COMMENT);
        params.addBodyParameter("scenicId", String.valueOf(id));
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_CAN_ADD_COMMENT, callBack));
    }

    @Override
    public void getPostage(Context context, int id, boolean isEvent, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_GET_POSTAGE);
        if (isEvent) {
            params.addBodyParameter("activityId", String.valueOf(id));
        } else {
            params.addBodyParameter("scenicId", String.valueOf(id));
        }
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_GET_POSTAGE, callBack));
    }

    @Override
    public void getEventTicketList(Context context, int id, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_GET_EVENT_TICKET_LIST);
        params.addBodyParameter("activityId", String.valueOf(id));
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_GET_EVENT_TICKET_LIST, callBack));
    }

    @Override
    public void getResortsDetail(Context context, int resortsId, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_GET_RESORTS);
        params.addBodyParameter("scenicId", String.valueOf(resortsId));
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_GET_RESORTS, callBack));
    }

    @Override
    public void getEventDetail(Context context, int eventId, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_GET_EVENT);
        params.addBodyParameter("activityId", String.valueOf(eventId));
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_GET_EVENT, callBack));
    }

    @Override
    public void getQRCodeList(Context context, int orderId, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_GET_QRCODE_LIST);
        params.addBodyParameter("orderId", String.valueOf(orderId));
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_GET_QRCODE_LIST, callBack));
    }

    @Override
    public void getOrderDetail(Context context, int orderId, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_GET_ORDER_DETAIL);
        params.addBodyParameter("orderId", String.valueOf(orderId));
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_GET_ORDER_DETAIL, callBack));
    }

    @Override
    public void getMessage(Context context, int startIndex, int pageMaxCount, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_GET_MESSAGE);
        params.addBodyParameter("startIndex", String.valueOf(startIndex));
        params.addBodyParameter("pageMaxCount", String.valueOf(pageMaxCount));
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_GET_MESSAGE, callBack));
    }
//
//    @Override
//    public void getNearbyResortsList(Context context, Resorts resorts, int skip, int max, YFAjaxCallBack callBack) {
//        RequestParams requestParams = getBaseParams(context, URL_SCENIC_LIST);
//        requestParams.addBodyParameter("startIndex", String.valueOf(skip));
//        requestParams.addBodyParameter("lat", String.valueOf(resorts.getLat()));
//        requestParams.addBodyParameter("lng", String.valueOf(resorts.getLng()));
//        requestParams.addBodyParameter("range", String.valueOf(1000));
//        requestParams.addBodyParameter("pageMaxCount", String.valueOf(max));
//        x.http().post(requestParams, new YFAjaxCallBackHolder(context, URL_SCENIC_LIST, callBack));
//    }

    @Override
    public void getDefaultReceiveAddress(Context context, YFAjaxCallBack callBack) {
        RequestParams requestParams = getBaseParams(context, URL_GET_DEFAULT_ADDRESS);
        x.http().post(requestParams, new YFAjaxCallBackHolder(context, URL_GET_DEFAULT_ADDRESS, callBack));
    }

    @Override
    public void deleteComment(Context context, int commentId, YFAjaxCallBack callBack) {
        RequestParams requestParams = getBaseParams(context, URL_DELETE_COMMENT);
        requestParams.addBodyParameter("commentId", String.valueOf(commentId));
        x.http().post(requestParams, new YFAjaxCallBackHolder(context, URL_DELETE_COMMENT, callBack));
    }

    @Override
    public void getUserBuyLimitCountForTicket(Context context, int ticketId, YFAjaxCallBack callBack) {
        RequestParams requestParams = getBaseParams(context, URL_TICKET_BUY_COUNT);
        requestParams.addBodyParameter("ticketId", String.valueOf(ticketId));
        x.http().post(requestParams, new YFAjaxCallBackHolder(context, URL_TICKET_BUY_COUNT, callBack));
    }

    @Override
    public void checkPhoneCode(Context context, String phoneNumber, String code, String tag, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_CHECK_PHONE_CODE);
        params.addBodyParameter("phoneNumber", phoneNumber);
        params.addBodyParameter("code", code);
        params.addBodyParameter("tag", tag);
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_CHECK_PHONE_CODE, callBack));
    }

    @Override
    public void gainBannerList(Context context, int bannerType, YFAjaxCallBack callBack) {
        RequestParams params = getBaseParams(context, URL_GET_BANNER);
        params.addBodyParameter("bannerType", String.valueOf(bannerType));
        x.http().post(params, new YFAjaxCallBackHolder(context, URL_GET_BANNER, callBack));
    }
}
