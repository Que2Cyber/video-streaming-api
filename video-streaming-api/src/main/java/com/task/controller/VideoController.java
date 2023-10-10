package com.task.controller;

import com.example.model.Video;
import com.example.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping("/publish")
    public ResponseEntity<Video> publishVideo(@RequestBody Video video) {
        Video publishedVideo = videoService.publishVideo(video);
        return ResponseEntity.ok(publishedVideo);
    }

    @PutMapping("/edit/{videoId}")
    public ResponseEntity<Video> editVideoMetadata(@PathVariable Long videoId, @RequestBody Video video) {
        Video updatedVideo = videoService.editVideoMetadata(videoId, video);
        return ResponseEntity.ok(updatedVideo);
    }

    @DeleteMapping("/delist/{videoId}")
    public ResponseEntity<Void> delistVideo(@PathVariable Long videoId) {
        videoService.delistVideo(videoId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/load/{videoId}")
    public ResponseEntity<Video> loadVideo(@PathVariable Long videoId) {
        Video video = videoService.loadVideo(videoId);
        return ResponseEntity.ok(video);
    }

    @GetMapping("/play/{videoId}")
    public ResponseEntity<String> playVideo(@PathVariable Long videoId) {
        String content = videoService.playVideo(videoId);
        return ResponseEntity.ok(content);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Video>> listAllVideos() {
        List<Video> videos = videoService.listAllVideos();
        return ResponseEntity.ok(videos);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Video>> searchVideos(@RequestParam("director") String director) {
        List<Video> videos = videoService.searchVideosByDirector(director);
        return ResponseEntity.ok(videos);
    }

    @GetMapping("/engagement/{videoId}")
    public ResponseEntity<EngagementStatistics> getEngagementStatistics(@PathVariable Long videoId) {
        EngagementStatistics statistics = videoService.getEngagementStatistics(videoId);
        return ResponseEntity.ok(statistics);
    }
}
