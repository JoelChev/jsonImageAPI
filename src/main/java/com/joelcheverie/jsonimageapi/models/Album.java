package com.joelcheverie.jsonimageapi.models;

import java.util.List;

public class Album {
    private int albumId;
    private List<Photo> photos;

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
