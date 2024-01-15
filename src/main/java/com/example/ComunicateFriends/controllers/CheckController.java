package com.example.ComunicateFriends.controllers;

import com.example.ComunicateFriends.models.TaskTable;
import com.example.ComunicateFriends.repo.TaskTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class CheckController {
    @Autowired
    private TaskTableRepository taskTableRepository;
    @GetMapping("/task")
    public String blogMain(Model model){
        Iterable<TaskTable> task = taskTableRepository.findAll();
        model.addAttribute("tasks",task);
        return "task-main";
    }
    @GetMapping("/task/add")
    public String TaskMainAdd(Model model){
        return "task-add";
    }
    @PostMapping("/task/add")
    public String task_add(@RequestParam String title,@RequestParam String namedCompany,@RequestParam String fullText,@RequestParam String deadline, Model model){
        TaskTable taskTable = new TaskTable(title,namedCompany,fullText,deadline);
        taskTableRepository.save(taskTable);
        return "redirect:/task";
    }
    @GetMapping("/task/{id}")
    public String TaskInfo(@PathVariable(value = "id") long id, Model model){
        if (!taskTableRepository.existsById(id)){
            return "redirect:/task";
        }
        Optional<TaskTable> task = taskTableRepository.findById(id);
        ArrayList<TaskTable> res = new ArrayList<>();
        task.ifPresent(res::add);
        model.addAttribute("task",res);
        return "task-details";
    }
    @GetMapping("/task/{id}/edit")
    public String TaskEdit(@PathVariable(value = "id") long id, Model model){
        if (!taskTableRepository.existsById(id)){
            return "redirect:/task";
        }
        Optional<TaskTable> task = taskTableRepository.findById(id);
        ArrayList<TaskTable> res = new ArrayList<>();
        task.ifPresent(res::add);
        model.addAttribute("task",res);
        return "task-edit";
    }
    @PostMapping("/task/{id}/edit")
    public String task_Update(@PathVariable(value = "id") long id, @RequestParam String title,@RequestParam String namedCompany,@RequestParam String fullText,@RequestParam String deadline, Model model) {
        TaskTable taskTable = taskTableRepository.findById(id).orElseThrow();
        taskTable.setTitle(title);
        taskTable.setFullText(fullText);
        taskTable.setNamedCompany(namedCompany);
        taskTable.setDeadline(deadline);
        taskTableRepository.save(taskTable);
        return "redirect:/task";
    }
        @PostMapping("/task/{id}/remove")
        public String task_Delete(@PathVariable(value = "id") long id, Model model){
            TaskTable taskTable = taskTableRepository.findById(id).orElseThrow();
            taskTableRepository.delete(taskTable);
            return "redirect:/task";
    }
}
