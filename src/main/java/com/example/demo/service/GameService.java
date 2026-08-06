package com.example.demo.service;


import com.example.demo.model.Game;
import com.example.demo.repository.GameRepository;
import com.example.demo.strategy.DiscountContext;
import com.example.demo.strategy.DiscountStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final DiscountContext discountContext;

    public GameService(GameRepository gameRepository,
                       DiscountContext discountContext) {
        this.gameRepository = gameRepository;
        this.discountContext = discountContext;
    }

    // แสดงเกมทั้งหมด
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    // ค้นหาตาม id
    public Optional<Game> findById(Long id) {
        return gameRepository.findById(id);
    }

    // เพิ่มเกม
    public Game save(Game game) {

        DiscountStrategy strategy =
                discountContext.getStrategy(game.getDiscountType());

        game.setDiscountName(strategy.getDiscountName());

        game.setFinalPrice(
                strategy.calculateDiscount(game.getPrice())
        );

        return gameRepository.save(game);
    }

    // แก้ไขเกม
    public Game update(Game game) {

        DiscountStrategy strategy =
                discountContext.getStrategy(game.getDiscountType());

        game.setDiscountName(strategy.getDiscountName());

        game.setFinalPrice(
                strategy.calculateDiscount(game.getPrice())
        );

        return gameRepository.save(game);
    }

    // ลบเกม
    public void delete(Long id) {
        gameRepository.deleteById(id);
    }
}
