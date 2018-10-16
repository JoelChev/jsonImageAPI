package com.joelcheverie.jsonimageapi.services;

import com.joelcheverie.jsonimageapi.exceptions.NotFoundException;
import com.joelcheverie.jsonimageapi.models.Album;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static org.springframework.http.HttpHeaders.USER_AGENT;

@Service
public class JSONPlaceHolderService {

    @Value("${json.baseEndpoint}")
    private String baseURL;

    public List<Album> getAlbums(){}

    public Album getAlbum() {}

    private String doGET(String url) throws IOException {
        HttpGet request = new HttpGet(url);
        return executeRequest(request);
    }

    private String doPOST(String url) throws IOException {
        HttpPost request = new HttpPost(url);
        return executeRequest(request);
    }

    private String doPUT(String url) throws IOException {
        HttpPut request = new HttpPut(url);
        return executeRequest(request);
    }

    private String doDELETE(String url) throws IOException {
        HttpDelete request = new HttpDelete(url);
        return executeRequest(request);
    }

    private String executeRequest(HttpRequestBase request) throws IOException {
        HttpClient client = new DefaultHttpClient();
        // add request header
        request.addHeader("User-Agent", USER_AGENT);

        HttpResponse response = client.execute(request);

        int responseStatusCode = response.getStatusLine().getStatusCode();
        if(responseStatusCode == 404) {
            throw new NotFoundException("Could not find photos!");
        }

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        return result.toString();
    }
}
