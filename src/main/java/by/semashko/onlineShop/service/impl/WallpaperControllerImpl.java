package by.semashko.onlineShop.service.impl;

import by.semashko.onlineShop.controller.WallpaperController;
import by.semashko.onlineShop.controller.constant.WallpaperControllerConstant;
import by.semashko.onlineShop.entity.User;
import by.semashko.onlineShop.entity.WallPaper;
import by.semashko.onlineShop.service.WallpaperService;
import by.semashko.onlineShop.service.exception.WallpaperNameIsExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.util.List;


@Controller
public class WallpaperControllerImpl implements WallpaperController {
    private WallpaperService wallpaperService;

    @Autowired
    public WallpaperControllerImpl(WallpaperService wallpaperService) {
        this.wallpaperService = wallpaperService;
    }

    // spring сам подставит объекты
//    @Autowired
    @GetMapping("/")
    public String welcomePage(){
        return "welcomePage";
    }


    // get запрос на получение списка книг
    @GetMapping("/wallpapers")//localhost:8080/phones
    public String findAllWallpaper(@RequestParam(required = false) String name,  Model model) {
        //Model для работы с фронтэндом
        // вызов метода сервиса
        List<WallPaper> allWallpapers = wallpaperService.findAll(name);
        // добавляем список телефонов в модель для передачи на страницу
        model.addAttribute("color", allWallpapers);
        // resources/templates/books.html
        return "wallpapers";

        //return phoneRepository.findAll();

    }


    @PostMapping("/create")
    public String create(@Validated  WallPaper wallPaper,Model color) {
        try {
            WallPaper newWallpaper = wallpaperService.addNewWallpaper(wallPaper);
            return "redirect:/";
        } catch (WallpaperNameIsExistsException e) {
            color.addAttribute("error",e.getMessage());
            color.addAttribute("createNewWallpaper",wallpaperService.findAll(WallpaperControllerConstant.EMPTY_STR));
            return "createNewWallpaper";
        }



    }


    //@PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/newWallpaper")
    public String forwardCreateWallpaper(@AuthenticationPrincipal User user){
        return "createNewWallpaper";
    }

    @Override
    public String findAllWallpaper(String Name, Color color) {
        return null;
    }

    @Override
    public String create(WallPaper wallPaper, Color color) {
        return null;
    }
}

