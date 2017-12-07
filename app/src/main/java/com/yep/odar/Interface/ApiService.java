package com.yep.odar.Interface;

import com.yep.odar.Model.M_Prodect_Review;
import com.yep.odar.Model.M_Product;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by yep on 2017. 10. 14..
 */

public interface ApiService {
    public static final String API_URL = "http://jsonplaceholder.typicode.com/";

    @GET("users/{user}/repos")
    Call<List<M_Product>> listRepos(@Path("user") String user);


}
