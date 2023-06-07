package com.example.quizebee;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.quizebee.model.Quiz;
import com.example.quizebee.network.FakeApi;
import com.example.quizebee.network.FakeApiService;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getShopDetails() throws IOException {
        FakeApiService fakeApiService = new FakeApi().createFakeApiService();
        Call<List<Quiz>> call = fakeApiService.getDataApi();
        List<Quiz> shop = call.execute().body();
        assertFalse(shop.isEmpty());
        assertNotNull(shop);
        System.out.println(new Gson().toJson(shop));
    }
}