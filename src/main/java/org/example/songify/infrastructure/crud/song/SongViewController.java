package org.example.songify.infrastructure.crud.song;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@Controller
public class SongViewController {

    private final HashMap<Integer, String> songsDatabase = new HashMap<>();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/view/songs")
    public String songs(Model model) {
        songsDatabase.put(1, "Song1");
        songsDatabase.put(2, "Song2");
        songsDatabase.put(3, "Song3");
        songsDatabase.put(4, "Song4");
        songsDatabase.put(5, "Song5");

        model.addAttribute("songMap", songsDatabase);

        return "songs";
    }
}
