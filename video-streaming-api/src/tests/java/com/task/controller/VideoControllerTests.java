package com.task.controller;

import com.task.model.Video;
import com.example.service.VideoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class VideoControllerTests {

    @InjectMocks
    private VideoController videoController;

    @Mock
    private VideoService videoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPublishVideo() {
        Video video = new Video();
        when(videoService.publishVideo(any(Video.class))).thenReturn(video);

        ResponseEntity<Video> response = videoController.publishVideo(video);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(video, response.getBody());
    }

    @Test
    public void testListAllVideos() {
        Video video1 = new Video();
        Video video2 = new Video();
        List<Video> videos = Arrays.asList(video1, video2);
        when(videoService.listAllVideos()).thenReturn(videos);

        ResponseEntity<List<Video>> response = videoController.listAllVideos();

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(videos, response.getBody());
    }

}
