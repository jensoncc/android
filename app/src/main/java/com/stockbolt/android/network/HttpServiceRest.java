package com.stockbolt.android.network;

public interface HttpServiceRest {
//    String URL_LOGIN = "/api/mobile/user/login";
//
//    @Headers("Content-Type: application/json")
//    @POST(URL_LOGIN)
//    Observable<Result<Login>> doLogin(@Body TreeMap<String, Object> paramMap);
//
//    String URL_REGISTER_DEVICE_PUBLIC_TEST = "/api/mobile/user/register-device";
//
//    @Headers("Content-Type: application/json")
//    @POST(URL_REGISTER_DEVICE_PUBLIC_TEST)
//    Observable<Result<String>> registerDevicePublicTest(@Body TreeMap<String, Object> paramMap);
//
//    String URL_REGISTER_DEVICE_PRIVATE_TEST = "/api/mobile/user/register-device";
//
//    @Headers("Content-Type: application/json")
//    @POST(URL_REGISTER_DEVICE_PRIVATE_TEST)
//    Observable<Result<String>> registerDevicePrivateTest(@Header("Authorization") String authToken, @Body TreeMap<String, Object> paramMap);
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /**
//     * reset password
//     */
//
//    String URL_FORGOTTEN_PWD = "/api/mobile/user/password/forget";
//
//    @Headers("Content-Type: application/json")
//    @POST(URL_FORGOTTEN_PWD)
//    Observable<Result<Twillio>> forgetPasswordTest(@Body TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /**
//     * user logout
//     */
//    String URL_LOGOUT_TEST = "/api/mobile/user/logout";
//
//    @FormUrlEncoded
//    @POST(URL_LOGOUT_TEST)
//    Observable<Result<Logout>> doLogoutTest(@Header("Authorization") String authToken, @FieldMap() TreeMap<String, Object> paramMap);
//
//
//    String URL_VERIFY_EMAIL_TEST = "/api/mobile/user/verify/email";
//
//    @FormUrlEncoded
//    @POST(URL_VERIFY_EMAIL_TEST)
//    Observable<Result<String>> verifyEmailTest(@FieldMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * verify phonenumber
//     */
//    String URL_VERIFY_MOBILE = "/api/mobile/user/verify/mobile";
//
//    @FormUrlEncoded
//    @POST(URL_VERIFY_MOBILE)
////    Call<ResponseBody> verifyMobile(@FieldMap() TreeMap<String, Object> paramMap);
//    Observable<Result> verifyMobile(@FieldMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * verify 2 factor
//     */
//    String URL_VERIFY_SMS = "/api/mobile/user/verify/sms";
//
//    @FormUrlEncoded
//    @POST(URL_VERIFY_SMS)
////    Call<ResponseBody> verifySMS(@Header("Authorization") String authToken, @FieldMap() TreeMap<String, Object> paramMap);
//    Observable<Result<String>> verifySMS(@Header("Authorization") String authToken, @FieldMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /**
//     * validate 2 factor sms
//     */
//    String URL_VALIDATE_SMS = "/api/mobile/user/verify/sms/validate";
//
//    @FormUrlEncoded
//    @POST(URL_VALIDATE_SMS)
////    Call<ResponseBody> validateSMS(@Header("Authorization") String authToken, @FieldMap() TreeMap<String, Object> paramMap);
//    Observable<Result> validateSMS(@Header("Authorization") String authToken, @FieldMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /**
//     * validate email
//     */
//    String URL_VALIDATE_EMAIL = "/api/mobile/user/verify/email/validate";
//
//    @FormUrlEncoded
//    @POST(URL_VALIDATE_EMAIL)
////    Call<ResponseBody> validateEmail(@FieldMap() TreeMap<String, Object> paramMap);
//    Observable<Result> validateEmail(@FieldMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * validate phonenumber
//     */
//    String URL_VALIDATE_MOBILE = "/api/mobile/user/verify/mobile/validate";
//
//    @FormUrlEncoded
//    @POST(URL_VALIDATE_MOBILE)
////    Call<ResponseBody> validateMobile(@FieldMap() TreeMap<String, Object> paramMap);
//    Observable<Result> validateMobile(@FieldMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * 创建新用户
//     */
//    String URL_CREATE_USER = "/api/mobile/user/signUp";
//
//    @FormUrlEncoded
//    @POST(URL_CREATE_USER)
//    Observable<Result<User>> signUp(@FieldMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * get static page
//     */
//    String URL_STATIC_PAGE = "/api/mobile/static-page/{name}";
//
//    @GET(URL_STATIC_PAGE)
//    Observable<Result<StaticPage>> getStaticPage(@Path("name") String name, @QueryMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /**
//     * get image
//     */
    String URL_GET_IMAGE = "/api/mobile/image/view";
//
//    @GET(URL_GET_IMAGE)
//    Call<ResponseBody> getGetImage(@QueryMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * get property card-view
//     */
//    String URL_PROPERTY_CARD_VIEW = "/api/mobile/property/list/card-view";
//
//    @GET(URL_PROPERTY_CARD_VIEW)
//    Observable<Result<PropertyList>> getPropertyCardView(@Header("Authorization") String authToken, @QueryMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * get property stock-view
//     */
//    String URL_PROPERTY_STOCK_VIEW = "/api/mobile/property/list/stock-view";
//
//    @GET(URL_PROPERTY_STOCK_VIEW)
//    Observable<Result<PropertyList>> getPropertyStockView(@Header("Authorization") String authToken, @QueryMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * get fund-timeline
//     */
//    String URL_FUND_TIMELINE = "/api/mobile/property/{propertyId}/crowdfunding-timeline";
//
//    @GET(URL_FUND_TIMELINE)
//    Observable<Result<FundingTimeLine>> getFundTimeline(@Header("Authorization") String authToken, @Path("propertyId") String propertyId);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * get invest config
//     */
//    String URL_TXN_CONFIG = "/api/mobile/property/{propertyId}/crowdfunding/invest-estimate";
//
//    @GET(URL_TXN_CONFIG)
//    Observable<Result<TxnFees>> getTxnConfig(@Header("Authorization") String authToken, @Path("propertyId") String propertyId, @QueryMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * get invest preview
//     */
//    String URL_TXN_PREVIEW = "/api/mobile/property/{propertyId}/crowdfunding/invest-preview";
//
//    @FormUrlEncoded
//    @POST(URL_TXN_PREVIEW)
//    Observable<Result<BuyOrder>> getTxnPreview(@Header("Authorization") String authToken, @Path("propertyId") String propertyId, @FieldMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * crowdfunding invest
//     */
//    String URL_INVEST_CROWDFUND = "/api/mobile/property/{propertyId}/crowdfunding/{buyOrderId}/invest";
//
//    @FormUrlEncoded
//    @POST(URL_INVEST_CROWDFUND)
//    Observable<Result<BuyOrder>> investCrowdFund(@Header("Authorization") String authToken, @Path("propertyId") String propertyId, @Path("buyOrderId") String buyOrderId, @FieldMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * get property detail
//     */
//    String URL_PROPERTY_DETAIL = "/api/mobile/property/{propertyId}";
//
//    @GET(URL_PROPERTY_DETAIL)
//    Observable<Result<Property>> getPropertyDetail(@Header("Authorization") String authToken, @Path("propertyId") String propertyId, @QueryMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * get property detail test
//     */
//    String URL_PROPERTY_DETAIL_TEST = "/api/mobile/property/{propertyId}";
//
//    @GET(URL_PROPERTY_DETAIL_TEST)
//    Observable<Result<Property>> getPropertyDetailTest(@Header("Authorization") String authToken, @Path("propertyId") String propertyId, @QueryMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * get user favourite property list
//     */
//    String URL_USER_FAVOURITE_LIST = "/api/mobile/user/favourite/list";
//
//    @GET(URL_USER_FAVOURITE_LIST)
//    Observable<Result<List<Property>>> getUserFavourites(@Header("Authorization") String authToken, @QueryMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * post user favourite property list
//     */
//    String URL_ADD_USER_FAVOURITE_PROPERTY = "/api/mobile/user/favourite";
//
//    @FormUrlEncoded
//    @POST(URL_ADD_USER_FAVOURITE_PROPERTY)
//    Observable<Result<Property>> addUserFavourites(@Header("Authorization") String authToken, @FieldMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * delete user favourite property list
//     */
//    String URL_DEL_USER_FAVOURITE_PROPERTY = "/api/mobile/user/favourite/{propertyId}";
//
//    @DELETE(URL_DEL_USER_FAVOURITE_PROPERTY)
//    Observable<Result<Property>> delUserFavourites(@Header("Authorization") String authToken, @Path("propertyId") String propertyId, @QueryMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * get user crowdfunding investment list
//     */
//    String URL_USER_CROWDFUND_SHARE = "/api/mobile/user/share/crowdfunding";
//
//    @GET(URL_USER_CROWDFUND_SHARE)
//    Observable<Result<Shares>> getUserShareCrowdfunding(@Header("Authorization") String authToken, @QueryMap TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * get user crowdfunding investment list
//     */
//    String URL_USER_SHARE_IN_HAND = "/api/mobile/user/share/on-hand";
//
//    @GET(URL_USER_SHARE_IN_HAND)
//    Observable<Result<Shares>> getUserShareInHand(@Header("Authorization") String authToken, @QueryMap TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * get Dashboard
//     */
//    String URL_USER_DASHBOARD = "/api/mobile/user/dashboard";
//
//    @GET(URL_USER_DASHBOARD)
//    Observable<Result<Dashboard>> getUserDashBoard(@Header("Authorization") String authToken, @QueryMap TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * get user profile
//     */
//    String URL_USER_PROFILE = "/api/mobile/user/profile";
//
//    @GET(URL_USER_PROFILE)
//    Observable<Profile> getUserProfile(@Header("Authorization") String authToken, @QueryMap() TreeMap<String, Object> paramMap);
//
//    /**
//     * withdraw
//     */
//    String URL_USER_WITHDRAW = "/api/mobile/user/account/withdraw-request";
//
//    @FormUrlEncoded
//    @POST(URL_USER_WITHDRAW)
//    Observable<Result<String>> accountWithdraw(@Header("Authorization") String authToken, @FieldMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * withdraw
//     */
//    String URL_USER_BANK_ACCOUNT_LIST = "/api/mobile/user/bank-account/list";
//
//    @GET(URL_USER_BANK_ACCOUNT_LIST)
//    Observable<Result<BankAccount>> getBankAccountList(@Header("Authorization") String authToken, @QueryMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * get user language
//     */
//    String URL_USER_LANGUAGE = "/api/mobile/user/setting/language";
//
//    @Headers("Content-Type: application/json")
//    @PUT(URL_USER_LANGUAGE)
////    Call<ResponseBody> setUserLanguage(@Header("Authorization") String authToken, @Body TreeMap<String, Object> paramMap);
//    Observable<Result<String>> setUserLanguage(@Header("Authorization") String authToken, @Body TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /**
//     * set user notification
//     */
//    String URL_USER_NOTIFICATION = "/api/mobile/user/setting/notification";
//
//    @Headers("Content-Type: application/json")
//    @PUT(URL_USER_NOTIFICATION)
//    Observable<ResponseBody> setUserNotification(@Header("Authorization") String authToken, @Body TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /**
//     * set user investment level
//     */
//    String URL_USER_INVESTMENT_LEVEL = "/api/mobile/user/setting/investment-mode";
//
//    @FormUrlEncoded
//    @PUT(URL_USER_INVESTMENT_LEVEL)
//    Call<ResponseBody> setUserInvestmentLevel(@Header("Authorization") String authToken, @FieldMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    /**
//     * set user security
//     */
//    String URL_USER_SECURITY = "/api/mobile/user/setting/2factor-auth";
//
//    @Headers("Content-Type: application/json")
//    @PUT(URL_USER_SECURITY)
////    Call<ResponseBody> setUserSecurity(@Header("Authorization") String authToken, @FieldMap() TreeMap<String, Object> paramMap);
//    Observable<Result<User>> setUserSecurity(@Header("Authorization") String authToken, @Body TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * set user security
//     */
//    String URL_USER_CHANGE_PASSWORD = "/api/mobile/user/password/change";
//
//    @FormUrlEncoded
//    @POST(URL_USER_CHANGE_PASSWORD)
//    Observable<Result<User>> changeUserPassword(@Header("Authorization") String authToken, @FieldMap() TreeMap<String, Object> paramMap);
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    /**
//     * get history label constant
//     */
//    String URL_HISTORY_ACTION_CONST = "/api/mobile/user/balance/actions/list";
//
//    @GET(URL_HISTORY_ACTION_CONST)
////    Call<ResponseBody> getHistoryBalanceConst(@Header("Authorization") String authToken, @QueryMap() TreeMap<String, Object> paramMap);
//    Observable<Result<ResponseBody>> getHistoryBalanceConst(@Header("Authorization") String authToken, @QueryMap() TreeMap<String, Object> paramMap);
//
//    /**
//     * get user history
//     */
//    String URL_USER_HISTORY_BALANCE = "/api/mobile/user/history/balance";
//
//    @GET(URL_USER_HISTORY_BALANCE)
//    Observable<ResponseBody> getUserHistoryBalance(@Header("Authorization") String authToken, @QueryMap() TreeMap<String, Object> paramMap);
//
//    /**
//     * 4.6上传项目图片文件
//     */
//    /*
//    String URL_UPLOAD_SUGGEST = "articlepub.php";
//
//    @POST(URL_UPLOAD_SUGGEST)
//    Call<ResponseBody> doUploadSuggest(@QueryMap TreeMap<String, Object> paramMap, @Body MultipartBody multipartBody);
//    */
//
//    /**
//     * get Dashboard
//     */
//    String URL_BANK_ACCOUNT = "/api/mobile/stockbolt/bank-account";
//
//    @GET(URL_BANK_ACCOUNT)
//    Observable<Result<BankAccount>> getBankAccount(@Header("Authorization") String authToken, @QueryMap TreeMap<String, Object> paramMap);
//
//    /**
//     * kyc booking
//     */
//    String URL_BOOKING = "/api/mobile/user/kyc-booking";
//
//    @FormUrlEncoded
//    @POST(URL_BOOKING)
//    Observable<Result<String>> kycBooking(@Header("Authorization") String authToken, @QueryMap TreeMap<String, Object> paramMap);
//
//    /**
//     * get resale share distribution
//     */
//    String URL_GET_RESALE_SHARES_DISTRIBUTION_GRAPH = "/api/mobile/property/{propertyId}/resale-shares-distribution-graph";
//
//    @GET(URL_GET_RESALE_SHARES_DISTRIBUTION_GRAPH)
//    Observable<Result<List<PropertyResaleSharesDistributionGraphData>>> getResaleSharesDistributionGraph(@Header("Authorization") String authToken, @Path("propertyId") String propertyId, @QueryMap TreeMap<String, Object> paramMap);


}
