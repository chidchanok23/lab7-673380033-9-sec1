package com.example.demo.controller;

import com.example.demo.model.Game;
import com.example.demo.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // ===========================
    // แสดงรายการเกมทั้งหมด
    // ===========================
    @GetMapping
    public String listGames(Model model) {
        model.addAttribute("games", gameService.findAll());
        return "games/list";
    }

    // ===========================
    // แสดงหน้าเพิ่มเกม
    // ===========================
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("game", new Game());
        return "games/add";
    }

    // ===========================
    // บันทึกเกมใหม่
    // ===========================
    @PostMapping("/save")
    public String saveGame(@ModelAttribute Game game,
                           RedirectAttributes redirectAttributes) {

        gameService.save(game);

        redirectAttributes.addFlashAttribute(
                "message",
                "เพิ่มเกมสำเร็จ"
        );

        return "redirect:/games";
    }

    // ===========================
    // แสดงหน้าแก้ไข
    // ===========================
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id,
                               Model model) {

        Game game = gameService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Game ID: " + id));

        model.addAttribute("game", game);

        return "games/edit";
    }

    // ===========================
    // อัปเดตข้อมูลเกม
    // ===========================
    @PostMapping("/update/{id}")
    public String updateGame(@PathVariable Long id,
                             @ModelAttribute Game game,
                             RedirectAttributes redirectAttributes) {

        game.setId(id);

        gameService.update(game);

        redirectAttributes.addFlashAttribute(
                "message",
                "แก้ไขข้อมูลสำเร็จ"
        );

        return "redirect:/games";
    }

    // ===========================
    // แสดงหน้ายืนยันการลบ
    // ===========================
    @GetMapping("/delete/{id}")
    public String showDeletePage(@PathVariable Long id,
                                 Model model) {

        Game game = gameService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Game ID: " + id));

        model.addAttribute("game", game);

        return "games/delete";
    }

    // ===========================
    // ลบเกม
    // ===========================
    @PostMapping("/delete/{id}")
    public String deleteGame(@PathVariable Long id,
                             RedirectAttributes redirectAttributes) {

        gameService.delete(id);

        redirectAttributes.addFlashAttribute(
                "message",
                "ลบเกมสำเร็จ"
        );

        return "redirect:/games";
    }

}
