package by.semashko.onlineShop.controller;

import by.semashko.onlineShop.entity.WallPaper;
import org.springframework.ui.Model;

import java.awt.*;
import java.util.List;

public interface WallpaperController {
    String findAllWallpaper(String Name, Color color);

    String create(WallPaper wallPaper, Color color);

}
