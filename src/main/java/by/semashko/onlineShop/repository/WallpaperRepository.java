package by.semashko.onlineShop.repository;

import by.semashko.onlineShop.entity.WallPaper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WallpaperRepository extends JpaRepository <WallPaper,Integer>
{
    List<WallPaper> findWallPaperByNameIsLike (String name);

    Optional<WallPaper>findWallPaperByName (String name);
}
