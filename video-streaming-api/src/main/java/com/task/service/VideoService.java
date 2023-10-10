package com.task.service;

import com.example.model.Video;

import java.util.List;

public interface VideoService {

    Video publishVideo(Video video);

    Video editVideoMetadata(Long videoId, Video updatedVideo);

    void delistVideo(Long videoId);

    Video loadVideo(Long videoId);

    String playVideo(Long videoId);

    List<Video> listAllVideos();

    List<Video> searchVideosByDirector(String director);

    EngagementStatistics getEngagementStatistics(Long videoId);
}
