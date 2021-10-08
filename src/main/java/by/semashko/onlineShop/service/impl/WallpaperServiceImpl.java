package by.semashko.onlineShop.service.impl;

import by.semashko.onlineShop.entity.WallPaper;
import by.semashko.onlineShop.repository.WallpaperRepository;
import by.semashko.onlineShop.service.WallpaperService;
import by.semashko.onlineShop.service.exception.WallpaperNameIsExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WallpaperServiceImpl implements WallpaperService {
    private static final String WALLPAPER_NAME_IS_EXISTS_EXCEPTION =
            "WallpaperService exception, furniture name is exists";
    private WallpaperRepository wallpaperRepository;

    @Autowired
    public WallpaperServiceImpl(WallpaperRepository wallpaperRepository) {
        this.wallpaperRepository = wallpaperRepository;
    }

    @Override
    public List<WallPaper> findAll(String wallPaperName) {
        if(isStringEqualNullOrBlank(wallPaperName)){
            return wallpaperRepository.findAll();
        }
        String redactedName = "%" + wallPaperName + "%";
        return wallpaperRepository.findWallPaperByNameIsLike(redactedName);
    }

    @Override
    public WallPaper addNewWallPaper(WallPaper wallPaper) throws WallpaperNameIsExistsException {
        return null;
    }


    private boolean isStringEqualNullOrBlank(String text){
        return text == null || text.isBlank();
    }

    @Override
    public WallPaper addNewWallpaper(WallPaper wallPaper) throws WallpaperNameIsExistsException {
        Optional<WallPaper> findWallpaper = wallpaperRepository.findWallPaperByName(wallPaper.getName());
        if (findWallpaper.isPresent()){
            throw new WallpaperNameIsExistsException(WALLPAPER_NAME_IS_EXISTS_EXCEPTION);
        }
        else {
            return wallpaperRepository.save(wallPaper);
        }
}}
