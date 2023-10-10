package com.task.service;

import com.example.model.Video;
import com.example.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public Video publishVideo(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public Video editVideoMetadata(Long videoId, Video updatedVideo) {
        Optional<Video> existingVideo = videoRepository.findById(videoId);
        if (existingVideo.isPresent()) {
            Video videoToUpdate = existingVideo.get();
            videoToUpdate.setTitle(updatedVideo.getTitle());
            videoToUpdate.setSynopsis(updatedVideo.getSynopsis());
            // Update other metadata fields similarly
            return videoRepository.save(videoToUpdate);
        } else {
            throw new VideoNotFoundException("Video with ID " + videoId + " not found.");
        }
    }

    @Override
    public void delistVideo(Long videoId) {
        Optional<Video> existingVideo = videoRepository.findById(videoId);
        if (existingVideo.isPresent()) {
            Video videoToDelist = existingVideo.get();
            videoToDelist.setDelisted(true);
            videoRepository.save(videoToDelist);
        } else {
            throw new VideoNotFoundException("Video with ID " + videoId + " not found.");
        }
    }

    @Override
    public Video loadVideo(Long videoId) {
        Optional<Video> video = videoRepository.findById(videoId);
        if (video.isPresent() && !video.get().isDelisted()) {
            return video.get();
        } else {
            throw new VideoNotFoundException("Video with ID " + videoId + " not found.");
        }
    }

    @Override
    public String playVideo(Long videoId) {
        return "Mock Video Content for Video ID " + videoId;
    }

    @Override
    public List<Video> listAllVideos() {
        return videoRepository.findAll();
    }

    @Override
    public List<Video> searchVideosByDirector(String director) {
        return videoRepository.findByDirector(director);
    }

    @Override
    public EngagementStatistics getEngagementStatistics(Long videoId) {
        //TODO : logic to calculate and return engagement statistics for a video
        return new EngagementStatistics(/* Calculate statistics here */);
    }
}
