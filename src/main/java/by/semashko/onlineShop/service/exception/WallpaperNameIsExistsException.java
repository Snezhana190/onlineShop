package by.semashko.onlineShop.service.exception;

import by.semashko.onlineShop.entity.WallPaper;

public class WallpaperNameIsExistsException extends Exception{
    public WallpaperNameIsExistsException() {
    }

    public WallpaperNameIsExistsException(String message) {
        super(message);
    }

    public WallpaperNameIsExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public WallpaperNameIsExistsException(Throwable cause) {
        super(cause);
    }

    public WallpaperNameIsExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
