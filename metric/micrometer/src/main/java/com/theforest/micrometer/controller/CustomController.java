package com.theforest.micrometer.controller;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.stats.CacheStats;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
public class CustomController {
    private CacheManager cacheManager;

    public CustomController(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @CachePut(cacheNames="msg", value="msg")
    @PostMapping("/send")
    public String send(@RequestBody String msg) {
        log.info("send msg: {}", msg);
        return msg;
    }

    @GetMapping()
    public List<CacheInfoDto> getCacheInfo() {
        return cacheManager.getCacheNames()
                .stream()
                .map(this::getCacheInfo)
                .toList();
    }

    private CacheInfoDto getCacheInfo(String cacheName) {
        Cache<Object, Object> nativeCache =
                (Cache)cacheManager.getCache(cacheName).getNativeCache();
        Set<Object> keys = nativeCache.asMap().keySet();
        CacheStats stats = nativeCache.stats();
        return new CacheInfoDto(
                cacheName, keys.size(), keys, stats.toString());
    }

    private record CacheInfoDto(
            String name, int size, Set<Object> keys, String stats) {}

}
