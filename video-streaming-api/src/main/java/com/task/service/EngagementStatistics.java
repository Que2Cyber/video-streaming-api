package com.task.service;

public class EngagementStatistics {
    private long impressions;
    private long views;

    public EngagementStatistics(long impressions, long views) {
        this.impressions = impressions;
        this.views = views;
    }

    public long getImpressions() {
        return impressions;
    }

    public void setImpressions(long impressions) {
        this.impressions = impressions;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }
}
