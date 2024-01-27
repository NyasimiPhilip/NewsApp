package com.android.newsapp.data.api

import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsApiServiceTest {

    private lateinit var service: NewsApiService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        // Create a new instance of MockWebServer and Retrofit before each test
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiService::class.java)
    }

    // Enqueue a mock response for testing
    private fun enqueueMockResponse(fileName: String) {
        // Use the class loader to read the JSON file from the resources
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()

        // Create a MockResponse and set its body using the content of the JSON file
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))

        // Enqueue the mock response to the MockWebServer
        server.enqueue(mockResponse)
    }

    @After
    fun tearDown() {
        // Shutdown the MockWebServer after each test to release resources
        server.shutdown()
    }

    @Test
    fun getTopHeadlines_sentRequest_receivedExpected() {
        // Perform the actual test, e.g., make API requests and validate the responses
        runBlocking {
            enqueueMockResponse("newresponse.json")
            val responseBody = service.getTopHeadlines("us", 1).body()
            val request = server.takeRequest()
        }
    }
}
