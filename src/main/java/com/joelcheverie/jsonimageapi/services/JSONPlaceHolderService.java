package com.joelcheverie.jsonimageapi.services;

import com.joelcheverie.jsonimageapi.models.Album;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JSONPlaceHolderService {

    @Value("${json.baseEndpoint}")
    private String baseURL;

    public List<Album> getAlbums(){}

    public Album getAlbum() {}

    private String makeRequest() {
        
    }
}
