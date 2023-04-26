package com.example.internshiptasks.controller;

import com.example.internshiptasks.Repository.PostsRepository;
import com.example.internshiptasks.entity.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

@Controller
public class PostsController {
    private PostsRepository postsRepository;

    @Autowired
    public void PostsRepository(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }


    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }

    @GetMapping("/home")
    public String getAllStudents(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "default") String[] sort) {
        try {
            if(sort[0].equals("default")){
                Pageable paging = PageRequest.of(page - 1, 30);
                Page<Posts> pagePosts = postsRepository.findAll(paging);
                List<Posts> posts = pagePosts.getContent();


                model.addAttribute("posts", posts);
                model.addAttribute("currentPage", pagePosts.getNumber() + 1);
            }
            else {
                List<Sort.Order> orders = new ArrayList<Order>();
                if (sort[0].contains(",")) {
                    // will sort more than 2 fields
                    // sortOrder="field, direction"
                    for (String sortOrder : sort) {
                        String[] _sort = sortOrder.split(",");
                        orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
                    }
                } else {
                    // sort=[field, direction]
                    orders.add(new Order(getSortDirection(sort[1]), sort[0]));
                }

                Pageable paging = PageRequest.of(page - 1, 30, Sort.by(orders));
                Page<Posts> pagePosts = postsRepository.findAll(paging);
                List<Posts> posts = pagePosts.getContent();


                model.addAttribute("posts", posts);
                model.addAttribute("currentPage", pagePosts.getNumber() + 1);
            }

        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }

        return "all";
    }
}
