package com.example.megaPassworkSaver.serviceImpl;

import com.example.megaPassworkSaver.data.appConfig.FacebookClientConfig;
import com.example.megaPassworkSaver.data.model.FacebookPost;
import com.example.megaPassworkSaver.service.FacebookService;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PostUpdate;
import facebook4j.conf.ConfigurationBuilder;
import org.springframework.stereotype.Service;

import java.lang.module.Configuration;
@Service
public class FacebookServiceImpl implements FacebookService {


 @Override
 public void postToFacebook(FacebookPost post) {
  ConfigurationBuilder configuration = FacebookClientConfig.getConfiguration();
  Facebook facebook = new FacebookFactory(configuration.build()).getInstance();

  try {
   facebook.postStatusMessage(post.getMessage());
   PostUpdate postUpdate = new PostUpdate("https://graph.facebook.com/me/feed");
   postUpdate.setMessage(post.getMessage());
   postUpdate.setLink(post.getLink());
   postUpdate.setPicture(post.getImageUrl());

   facebook.posts().postFeed(postUpdate);
   System.out.println("Post successful!");
  } catch (FacebookException e) {
   e.printStackTrace();
   System.out.println("Post failed.");
 }

 }
}
