package com.todo.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todo.app.entity.Todo;
import com.todo.app.mapper.TodoMapper;
@Controller
public class TodoController {
    @Autowired
    TodoMapper todoMapper;
    @RequestMapping(value="/")
    public String index(Model model) {
//      List<Todo> list = todoMapper.selectAll();
        List<Todo> list = todoMapper.selectTime();
        List<Todo> doneList = todoMapper.selectComplete();
        model.addAttribute("todos",list);
        model.addAttribute("doneTodos",doneList);
        return "index";
    }
    
    //sort追加
    @RequestMapping(value="/sort")
    public String sort(Model model) {   //ビューにデータを渡す
//      List<Todo> list = todoMapper.selectAll();
        List<Todo> tlist = todoMapper.selectTitle();//タイトル情報を取得
        List<Todo> titleList = todoMapper.selectComplete();//完了したtodoの情報を取得
        model.addAttribute("todos",tlist);//ビューにtodosという名前を付けてデータを渡す
        model.addAttribute("doneTodos",titleList);
        return "index"; //indexビューが表示される
    }
    @RequestMapping(value="/add")
    public String add(Todo todo) {
        todoMapper.add(todo);
        return "redirect:/";
    }
    @RequestMapping(value="/update")
    public String update(Todo todo) {
        todoMapper.update(todo);
        return "redirect:/";
    }
    @RequestMapping(value="/delete")
    public String delete() {
        todoMapper.delete();
        return "redirect:/";
    }
    


}


