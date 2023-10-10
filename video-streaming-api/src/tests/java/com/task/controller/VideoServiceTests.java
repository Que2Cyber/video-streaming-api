package com.task.service;

import com.task.model.Video;
import com.example.repository.VideoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class VideoServiceTests {

    @InjectMocks
    private VideoServiceImpl videoService;

    @Mock
    private VideoRepository videoRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPublishVideo() {
        Video video = new Video();
        when(videoRepository.save(any(Video.class))).thenReturn(video);

        Video publishedVideo = videoService.publishVideo(video);

        assertNotNull(publishedVideo);
        assertEquals(video, publishedVideo);
    }

    @Test
    public void testListAllVideos() {
        Video video1 = new Video();
        Video video2 = new Video();
        when(videoRepository.findAll()).thenReturn(Arrays.asList(video1, video2));

        List<Video> videos = videoService.listAllVideos();

        assertNotNull(videos);
        assertEquals(2, videos.size());
        assertEquals(video1, videos.get(0));
        assertEquals(video2, videos.get(1));
    }

}
