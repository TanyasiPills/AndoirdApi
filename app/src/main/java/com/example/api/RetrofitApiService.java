package com.example.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RetrofitApiService {

    // GET all users
    @GET("acttFJ/people")
    Call<List<Telephones>> getAllPeople();

    // GET user by ID
    @GET("acttFJ/people/{id}")
    Call<Telephones> getPeopleById(@Path("id") int id);

    // POST (create a new user)
    @POST("acttFJ/people")
    Call<Telephones> createPeople(@Body Telephones people);

    // PUT (update a user)
    @PUT("acttFJ/people/{id}")
    Call<Telephones> updatePeople(@Path("id") int id, @Body Telephones people);

    // DELETE (delete a user by ID)
    @DELETE("acttFJ/people/{id}")
    Call<Void> deletePeople(@Path("id") int id);
}

