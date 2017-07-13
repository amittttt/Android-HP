package com.example.minimusic;

import android.graphics.Bitmap;

public class Song {
	private long id;
	private String title;
	private String artist;
	private Bitmap album_art;
	public Song(long songID, String songTitle, String songArtist) {
		  id=songID;
		  title=songTitle;
		  artist=songArtist;
		//  album_art=songAlbum_art;
		}
	public long getID(){return id;}
	public String getTitle(){return title;}
	public String getArtist(){return artist;}
	//public Bitmap getAlbum_art(){return album_art;}
}
