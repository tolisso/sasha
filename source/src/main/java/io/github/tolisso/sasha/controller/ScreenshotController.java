package io.github.tolisso.sasha.controller;

import io.github.tolisso.sasha.service.ScreenshotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class ScreenshotController {

    private final ScreenshotService screenshotService;

    @ResponseBody
    @GetMapping(value = "/screenshot", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] makeScreenshot(@RequestParam int width,
                                 @RequestParam int height,
                                 @RequestParam double timeout,
                                 @RequestParam String url) {
        return screenshotService.makeScreenshot(width, height, timeout, url);
    }
}
