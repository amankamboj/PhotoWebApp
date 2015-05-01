package com.demo;

import java.util.ArrayList;
import java.util.List;

import org.jinstagram.Instagram;
import org.jinstagram.auth.InstagramAuthService;
import org.jinstagram.auth.model.Token;
import org.jinstagram.auth.model.Verifier;
import org.jinstagram.auth.oauth.InstagramService;
import org.jinstagram.entity.users.feed.MediaFeed;
import org.jinstagram.entity.users.feed.MediaFeedData;
import org.jinstagram.exceptions.InstagramException;


public class PhotoUtil {
	
	public static InstagramService service = new InstagramAuthService()
							    .apiKey("db9afa9230874e9991faaa7ea42ead88")
							    .apiSecret("a6c8da1335084ba1adabb5101376c7e3")
							    .callback("http://localhost:8080/PhotoWebApp/popularPhotos")     
							    .build();
	
	
	public static String getAuthURL(){
		String authURL=service.getAuthorizationUrl(null);
		return authURL;
	}
	
	public static List<PhotoBean> getPopularPhotos(String code,InstagramService instaService){
		List<PhotoBean> photoBeans = new ArrayList<PhotoBean>();
		if(null!=code && null!=instaService){
		Verifier verifier = new Verifier(code);

	      Token accessToken = service.getAccessToken(null, verifier);
	      Instagram instagram = new Instagram(accessToken);
	      try {
			MediaFeed mediaFeed = instagram.getPopularMedia();
			List<MediaFeedData> mediaFeedList = mediaFeed.getData();
			
			for(MediaFeedData data : mediaFeedList){
				PhotoBean photoBean = new PhotoBean();
				if(null!=data.getCaption() && null!=data.getCaption().getText()){
					photoBean.setCaption(data.getCaption().getText());
				}
				photoBean.setImageURL(data.getImages().getStandardResolution().getImageUrl());
				if(null!=data.getLikes()){
					photoBean.setLikes(String.valueOf(data.getLikes().getCount()));
				}
				photoBean.setUsername(data.getUser().getUserName());
				photoBean.setPostedTime(data.getCreatedTime());
				photoBean.setPermalink(data.getLink());
				photoBeans.add(photoBean);
			}
		} catch (InstagramException e) {
			e.printStackTrace();
		}
		}
		return photoBeans;
	}
}
