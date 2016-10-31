package com.yf.bx.tms.net;

import android.content.Context;


import com.yf.bx.tms.BuildConfig;

import java.util.List;

/**
 * Created by bai on 2016/10/31.
 */
public interface YFHttpClient {

    /**
     * 获取景区分类
     *
     * @param context
     * @param callBack
     */
    void getResortsCategory(Context context, YFAjaxCallBack callBack);

    /**
     * 获取景区分类下的景区列表
     *
     * @param context
     * @param keyword
     * @param skip
     * @param max
     * @param resortsType
     * @param callBack
     */
    void getResortsList(Context context, String keyword, int skip, int max, int resortsType, YFAjaxCallBack callBack);

    /**
     * 获取首页景区列表
     * @param context
     * @param keyword
     * @param skip
     * @param max
     * @param resortsType
     * @param callBack
     */
    void getResortsListWithTicket(Context context, String keyword, int skip, int max, int resortsType, YFAjaxCallBack callBack);

    void getResortsBusinessType(Context context, YFAjaxCallBack callBack);

    void getResortsBusiness(Context context, int skip, int max, int businessType, double lat, double lng, int range, YFAjaxCallBack callBack);

    /**
     * 获取景区评论
     *
     * @param context
     * @param mResortsId
     * @param skip
     * @param max
     * @param callBack
     */
    void getResortsCommentList(Context context, int mResortsId, int skip, int max, YFAjaxCallBack callBack);

    /**
     * 获取社区列表
     *
     * @param context
     * @param callBack
     */
    void getCommunityList(Context context, YFAjaxCallBack callBack);

    /**
     * 发送验证码
     *
     * @param context
     * @param phoneNumber
     * @param callBack
     */
    void sendCode(Context context, String phoneNumber, String tag, YFAjaxCallBack callBack);

    void registered(Context context, String phoneNumber, String code, String password, YFAjaxCallBack callBack);

    /**
     * 用户注册
     *
     * @param context
     * @param phoneNumber
     * @param code
     * @param password
     * @param communityId
     * @param callBack
     */
    void registered(Context context, String phoneNumber, String code, String password, int communityId, YFAjaxCallBack callBack);

    /**
     * 获取景区门票
     *
     * @param context
     * @param mResortsId
     * @param callBack
     */
    void getResortsTicket(Context context, int mResortsId, YFAjaxCallBack callBack);

    /**
     * 登陆，获取Token
     *
     * @param context
     * @param userName
     * @param password
     * @param callBack
     */
    void getToken(Context context, String userName, String password, YFAjaxCallBack callBack);

    /**
     * 重置密码
     *
     * @param context
     * @param phoneNumber
     * @param password
     * @param code
     * @param callBack
     */
    void resetPasswoed(Context context, String phoneNumber, String password, String code, YFAjaxCallBack callBack);

    /**
     * 获取用户信息
     *
     * @param context
     * @param callBack
     */
    void getUserInfo(Context context, YFAjaxCallBack callBack);

    /**
     * 修改密码
     *
     * @param context
     * @param newPassword
     * @param callBack
     */
    void changePassword(Context context, String newPassword, YFAjaxCallBack callBack);

    /**
     * 修改用户信息
     *
     * @param context
     * @param userName
     * @param userPhoto
     * @param sex
     * @param callBack
     */
    void changeUserInfo(Context context, String userName, String userPhoto, String sex, YFAjaxCallBack callBack);

    /**
     * 获取活动列表
     *
     * @param context
     * @param serchText
     * @param skip
     * @param max
     * @param type
     * @param callBack
     */
    void getEventList(Context context, String serchText, int skip, int max, int type, YFAjaxCallBack callBack);

    /**
     * 获取优惠券列表
     *
     * @param context
     * @param callBack
     */
    void getCouponsList(Context context, int startIndex, int pageMaxCount, YFAjaxCallBack callBack);

    /**
     * 获取收货地址列表
     *
     * @param context
     * @param startIndex
     * @param pageMaxCount
     * @param callBack
     */
    void getMyAddressList(Context context, int startIndex, int pageMaxCount, YFAjaxCallBack callBack);


    /**
     * 提交订单
     *
     * @param context
     * @param callBack
     */
   // void submitOrder(Context context, YFAjaxCallBack callBack);

//    void submitComment(Context context, int resortsId, String content, List<AddCommentForResortsActivity.ImageFile> imgs,
 //                      YFAjaxCallBack callBack);

    /**
     * 获取我的订单列表
     *
     * @param context
     * @param skip
     * @param max
     * @param callBack
     */
    void getMyOrderList(Context context, int skip, int max, YFAjaxCallBack callBack);


    /**
     * 新增收货地址
     *
     * @param context
     * @param recvName
     * @param recvPhone
     * @param recvAddress
     * @param isDefault
     * @param recvAdministrative
     * @param callBack
     */
    void addAddress(Context context, String recvName, String recvPhone, String recvAddress,
                    int isDefault, String recvAdministrative, YFAjaxCallBack callBack);

    /**
     * 编辑收货地址
     *
     * @param context
     * @param id
     * @param recvName
     * @param recvPhone
     * @param recvAddress
     * @param isDefault
     * @param recvAdministrative
     * @param callBack
     */
    void editAddress(Context context, int id, String recvName, String recvPhone,
                     String recvAddress, int isDefault, String recvAdministrative, YFAjaxCallBack callBack);

    /**
     * 设置地址为默认
     *
     * @param context
     * @param addressId
     * @param isDefault
     * @param callBack
     */
    void setAddressDefault(Context context, int addressId, int isDefault, YFAjaxCallBack callBack);

    /**
     * 删除地址
     *
     * @param context
     * @param addressId
     * @param callBack
     */
    void deleteAddress(Context context, int addressId, YFAjaxCallBack callBack);


    /**
     * 上传文件
     *
     * @param context
     * @param filePath
     * @param callBack
     */
    void uploadFile(Context context, String filePath, YFAjaxCallBack callBack);

    /**
     * 全局搜索
     *
     * @param context
     * @param skip
     * @param max
     * @param searchText
     * @param callBack
     */
    void globalSearch(Context context, int skip, int max, String searchText, YFAjaxCallBack callBack);

    /**
     * 获取Banner列表
     *
     * @param context
     * @param bannerType
     * @param callBack
     */
    void gainBannerList(Context context, int bannerType, YFAjaxCallBack callBack);

    /**
     * 获取热搜词
     *
     * @param context
     * @param callBack
     */
    void getHotKeyword(Context context, YFAjaxCallBack callBack);

    /**
     * 获取微信支付id
     *
     * @param context
     * @param orderNo
     * @param finalPrice
     * @param callBack
     */
  //  void getPrepayId(Context context, String orderNo, double finalPrice, YFAjaxCallBack callBack);

    /**
     * 增加活动查看量
     *
     * @param context
     * @param activityId
     * @param callBack
     */
    void addActivityReadNum(Context context, int activityId, YFAjaxCallBack callBack);

    /**
     * 增加景区查看量
     *
     * @param context
     * @param scenicId
     * @param callBack
     */
    void addScenicReadNum(Context context, int scenicId, YFAjaxCallBack callBack);

    /**
     * 取消订单
     *
     * @param context
     * @param id
     * @param callBack
     */
    void cancelOrder(Context context, int id, YFAjaxCallBack callBack);

    /**
     * 获取评论列表
     *
     * @param context
     * @param commentStatus
     * @param skip
     * @param max
     * @param callBack
     */
    void getMyCommentList(Context context, int commentStatus, int skip, int max, YFAjaxCallBack callBack);

    /**
     * 是否可以评论
     *
     * @param context
     * @param id
     * @param callBack
     */
    void canAddCommentToResorts(Context context, int id, YFAjaxCallBack callBack);

    /**
     * 获取邮费
     *  @param context
     * @param id
     * @param isEvent
     * @param callBack
     */
    void getPostage(Context context, int id, boolean isEvent, YFAjaxCallBack callBack);

    /**
     * 获取活动门票列表
     *
     * @param context
     * @param id
     * @param callBack
     */
    void getEventTicketList(Context context, int id, YFAjaxCallBack callBack);

    /**
     * 获取景区详情
     *
     * @param context
     * @param resortsId
     * @param callBack
     */
    void getResortsDetail(Context context, int resortsId, YFAjaxCallBack callBack);

    /**
     * 获取活动详情
     *
     * @param context
     * @param eventId
     * @param callBack
     */
    void getEventDetail(Context context, int eventId, YFAjaxCallBack callBack);

    /**
     * 获取二维码列表
     *
     * @param context
     * @param orderId
     * @param callBack
     */
    void getQRCodeList(Context context, int orderId, YFAjaxCallBack callBack);

    /**
     * 获取订单详情
     *
     * @param context
     * @param orderId
     * @param callBack
     */
    void getOrderDetail(Context context, int orderId, YFAjaxCallBack callBack);

    /**
     * 获取消息列表
     *
     * @param context
     * @param startIndex
     * @param pageMaxCount
     * @param callBack
     */
    void getMessage(Context context, int startIndex, int pageMaxCount, YFAjaxCallBack callBack);

    /**
     * 获取附近的景区
     *
     * @param context
     * @param resorts
     * @param skip
     * @param max
     * @param callBack
     */
    //void getNearbyResortsList(Context context, Resorts resorts, int skip, int max, YFAjaxCallBack callBack);

    /**
     * 获取默认地址
     *
     * @param context
     * @param callBack
     */
    void getDefaultReceiveAddress(Context context, YFAjaxCallBack callBack);

    /**
     * 删除评论
     *
     * @param context
     * @param commentId
     * @param callBack
     */
    void deleteComment(Context context, int commentId, YFAjaxCallBack callBack);

    /**
     * 获取用户能买的票最大数量
     *
     * @param context
     * @param ticketId
     * @param callBack
     */
    void getUserBuyLimitCountForTicket(Context context, int ticketId, YFAjaxCallBack callBack);

    /**
     * 验证验证码
     * @param context
     * @param phoneNumber
     * @param tag
     * @param callBack
     */
    void checkPhoneCode(Context context, String phoneNumber, String code, String tag, YFAjaxCallBack callBack);


    class Server {
        static final String SERVER_DOMAIN;
        static final boolean PAY_ONE_PERCENT;//支付一分
        static final String URL_IMAGE_TOP;
        static final String URL_UPLOAD_IMAGE;

        static final String URL_ALIPAY_NOTIFY;

        static final String URL_WECHATPAY_NOTIFY;

        static {
            if ("release".equals(BuildConfig.BUILD_TYPE)) {//外网服务器版本
                SERVER_DOMAIN = "api.ljhn.yfapp.net:8412/";
                PAY_ONE_PERCENT = BuildConfig.DEBUG;
                URL_IMAGE_TOP = "http://kyk.api.yunfengapp.com:6634/";
                URL_UPLOAD_IMAGE = "http://kyk.api.yunfengapp.com:6634/File/UploadFile/";
                URL_ALIPAY_NOTIFY = "http://api.ljhn.yfapp.net:8412/controllers/payAli.aspx";
                URL_WECHATPAY_NOTIFY = "http://api.ljhn.yfapp.net:8412/Controllers/payWechat.aspx";
            } else {//内网
                SERVER_DOMAIN = "192.168.0.1:8412/";
                PAY_ONE_PERCENT = true;
                URL_IMAGE_TOP = "http://s3.xtox.net:6634/";
                URL_UPLOAD_IMAGE = "http://s3.xtox.net:6634/File/UploadFile/";
                URL_ALIPAY_NOTIFY = "http://s3.xtox.net:8412/controllers/payAli.aspx";
                URL_WECHATPAY_NOTIFY = "http://s3.xtox.net:8412/Controllers/payWechat.aspx";
            }
        }
    }

//    String URL_WECHATPAY_NOTIFY = Server.URL_WECHATPAY_NOTIFY;
//
//    String URL_ALIPAY_NOTIFY = Server.URL_ALIPAY_NOTIFY;
//    boolean PAY_ONE_PERCENT = Server.PAY_ONE_PERCENT;
    String SERVER_DOMAIN = Server.SERVER_DOMAIN;
    String URL_SERVER = "http://" + SERVER_DOMAIN;
    String URL_API = "http://" + SERVER_DOMAIN;
    String URL_IMAGE_TOP = Server.URL_IMAGE_TOP;
    String URL_UPLOAD_IMAGE = Server.URL_UPLOAD_IMAGE;


    //    String URL_ALIPAY_NOTIFY = URL_SERVER+"/controllers/payAli.aspx";
    String URL_SCENIC_TYPES = URL_SERVER + "v2/Scenic/ScenicTypeList";//景区分类列表
    String URL_SCENIC_LIST = URL_SERVER + "v2/Scenic/ScenicList";//景区列表
    String URL_BUSINESS_TYPES = URL_SERVER + "v2/Business/BusinessTypeList";//商家分类
    String URL_BUSINESS_LIST = URL_SERVER + "v2/Business/BusinessList";//商家列表
    String URL_COMMUNITY_LIST = URL_SERVER + "v2/Community/CommunityList";//社区列表
    String URL_SEND_CODE = URL_SERVER + "v2/User/PhoneCode";//发送验证码
    String URL_REGISTERED = URL_SERVER + "v2/User/RegisterWithCode";//注册账号
    String URL_GET_TOKEN = URL_SERVER + "v2/Login/UserLogin";//获取用户令牌
    String URL_SCENIC_COMMENT_LIST = URL_SERVER + "v2/Comment/CommentList";//景区评论列表
    String URL_SCENIC_TICKET_LIST = URL_SERVER + "v2/Scenic/ScenicTicketList";//景区门票列表
    String URL_SCENIC_EVENT_LIST = URL_SERVER + "v2/Activity/ActivityList2";//活动列表
    String URL_RESET_PASSWORD = URL_SERVER + "v2/User/FindPassWithCode";// 找回密码
    String URL_USER_INFO = URL_SERVER + "v2/User/UserInfo";//获取用户信息
    String URL_CHANGE_PASSWORD = URL_SERVER + "v2/User/ChangePassword"; //修改密码
    String URL_CHANGE_USER_INFO = URL_SERVER + "v2/User/ChangeUserInfo";// 修改用户信息
    String URL_SUBMIT_ORDER = URL_SERVER + "v2/Order/SubmitOrder";// 提交订单
    String URL_SUBMIT_COMMENT = URL_SERVER + "v2/Comment/AddScenicComment";// 提交评论
    String URL_ADD_ADDRESS = URL_SERVER + "v2/Address/AddAddress";// 新增收货地址
    String URL_EDIT_ADDRESS = URL_SERVER + "v2/Address/EditAddress";//修改收货地址
    String URL_DEFAULT_ADDRESS = URL_SERVER + "v2/Address/UpdateAddressDefault";//设置收货地址为默认
    String URL_DELETE_ADDRESS = URL_SERVER + "v2/Address/DelAddress";//删除地址
    String URL_GLOBAL_SEARCH = URL_SERVER + "v2/Scenic/SearchAll";//全局搜索
    String URL_GET_BANNER = URL_SERVER + "v2/Banner/BannerList";//获取Banner列表
    String URL_HOT_SEARCH = URL_SERVER + "v2/Scenic/HotSearchText";//热门搜索
    String URL_UPLOAD_FILE = URL_SERVER + "Controllers/uploadFile.ashx";//上传文件
    String URL_WECHAT_PREPAY_ID = URL_SERVER + "v2/Order/WechatPrepayId";//获取微信preypayid
    String URL_CANCEL_ORDER = URL_SERVER + "v2/Order/CancelOrder";//取消订单
    String URL_MY_COMMENT_LIST = URL_SERVER + "v2/Comment/MyCommentList";//我的评论列表
    String URL_CAN_ADD_COMMENT = URL_SERVER + "v2/Scenic/IsCanComment";//是否可以评论景区
    String URL_GET_EVENT_TICKET_LIST = URL_SERVER + "v2/Activity/ActivityTicketList";//获取活动门票列表
    String URL_GET_RESORTS = URL_SERVER + "v2/Scenic//ScenicDetail";//根据id获取景区内容
    String URL_GET_EVENT = URL_SERVER + "v2/Activity/ActivityDetail";//根据id获取活动内容
    String URL_GET_QRCODE_LIST = URL_SERVER + "v2/Order/OrderDetail";//根据id获取门票二维码列表
    String URL_GET_ORDER_DETAIL = URL_SERVER + "v2/Order/OrderDetail2";//根据id获取订单详情
    String URL_GET_POSTAGE = URL_SERVER + "v2/Order/PostagePrice";//获取邮费
    String URL_DELETE_COMMENT = URL_SERVER + "v2/Comment/DeleteMyComment";//删除评论
    String URL_TICKET_BUY_COUNT = URL_SERVER + "v2/Activity/CanTicketBugNum";//获取用户能买的票的数量
    String URL_GET_DEFAULT_ADDRESS = URL_SERVER + "v2/Address/DefaultAddress";//获取默认收获地址


    String URL_GET_COUPONS_LIST = URL_SERVER + "v2/Coupons/MyCouponsList";  //获取优惠券列表
    String URL_GET_ADDRESS_LIST = URL_SERVER + "v2/Address/MyAddressList";//获取收货地址列表
    String URL_GET_MY_ORDER_LIST = URL_SERVER + "v2/Order/MyOrderList";//获取我的订单
    String URL_GET_ADD_ACTIVITY_READ_NUM = URL_SERVER + "v2/Activity/AddActivityReadNum";//增加活动查看量
    String URL_GET_ADD_SCENIC_READ_NUM = URL_SERVER + "v2/Scenic/AddScenicReadNum";//增加景区查看量
    String URL_GET_MESSAGE = URL_SERVER + "v2/User/MyPushMsgList";  //获取消息列表
    String URL_CHECK_PHONE_CODE = URL_SERVER + "v2/User/CheckPhoneCode"; //验证验证码
    String URL_GET_RESORT_LISTT_WITH_TICKET = URL_SERVER + "v2/Scenic/ScenicListWithTicket"; //获取首页景区列表

}
