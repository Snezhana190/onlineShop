package by.semashko.onlineShop.service;

import by.semashko.onlineShop.entity.WallPaper;
import by.semashko.onlineShop.service.exception.WallpaperNameIsExistsException;

import java.util.List;

public interface WallpaperService {
    List<WallPaper> findAll(String wallPaperName);

    WallPaper addNewWallPaper (WallPaper wallPaper)throws WallpaperNameIsExistsException;

    WallPaper addNewWallpaper(WallPaper wallPaper) throws WallpaperNameIsExistsException;
}
