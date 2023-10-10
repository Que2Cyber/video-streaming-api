package com.task.controller;

import com.example.model.Video;
import com.example.service.VideoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class VideoControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VideoService videoService;

    @BeforeEach
    public void setUp() {
        Video video1 = new Video();
        Video video2 = new Video();
        List<Video> videos = Arrays.asList(video1, video2);
        when(videoService.listAllVideos()).thenReturn(videos);
    }

    @Test
    public void testListAllVideos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/videos/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2)); // Assuming two videos are returned
    }
}
