package di


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

class RetroModule {
   // private  val URL: String = "https://reqres.in/api/users?page=1"
    private  val URL: String = "https://reqres.in/api/"

    var retrofit: Retrofit? = null


    fun getRetroFitClientInstance(): Retrofit? {
        if (retrofit == null) {

            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val httpClient = OkHttpClient.Builder()
                .writeTimeout(5, TimeUnit.MINUTES) // write timeout
                .readTimeout(5, TimeUnit.MINUTES)
                .connectTimeout(5, TimeUnit.MINUTES)
            httpClient.addInterceptor(logging)  // <-- this is the important line!
            retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()


        }
        return retrofit
    }
}