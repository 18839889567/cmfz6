package com.zy.controller;

import com.zy.service.PoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("poi")
public class PoiController {
    @Autowired
    PoiService poiService;

    @RequestMapping("download")
    public void download() {
        poiService.download();
    }

    @RequestMapping("poiImport")
    public void poiImport() {
        poiService.poiImport();
    }
}
